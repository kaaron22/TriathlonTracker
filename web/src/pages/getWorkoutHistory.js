import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the get workout history page of the website.
 */
class GetWorkoutHistory extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'getFullWorkoutHistory', 'addWorkoutsToPage'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.getFullWorkoutHistory);
        this.dataStore.addChangeListener(this.addWorkoutsToPage);
        this.header = new Header(this.dataStore);
        console.log("getWorkoutHistory constructor");
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        document.getElementById('get-full-history').addEventListener('click', this.getFullWorkoutHistory);

        this.header.addHeaderToPage();

        this.client = new MusicPlaylistClient();
    }

    async getFullWorkoutHistory(evt) {
        evt.preventDefault();

        const errorMessageDisplay = document.getElementById('error-message-full-history');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const createButton = document.getElementById('get-full-history');
        const origButtonText = createButton.innerText;
        createButton.innerText = 'Loading Workout History...';

        const urlParams = new URLSearchParams(window.location.search);
        const customerId = urlParams.get('customerId');
        const workouts = await this.client.getFullWorkoutHistoryByCustomer(customerId);
        this.dataStore.set('workouts', workouts);
    }

    addWorkoutsToPage() {
        const workouts = this.dataStore.get('workouts')

        if (workouts == null) {
            return;
        }

        let workoutHtml = '';
        let workout;
        for (workout of workouts) {
            workoutHtml += `
                <li class="song">
                    <span class="title">${workout.workoutId}</span>
                    <span class="title">${workout.date}</span>
                    <span class="title">${workout.workoutType}</span>
                    <span class="title">${workout.durationInHours}</span>
                    <span class="title">${workout.durationInMinutes}</span>
                    <span class="title">${workout.durationInSeconds}</span>
                    <span class="title">${workout.distance}</span>
                </li>
            `;
        }
        document.getElementById('workouts').innerHTML = workoutHtml;

        createButton.innerText = origButtonText;
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const getWorkoutHistory = new GetWorkoutHistory();
    getWorkoutHistory.mount();
};

window.addEventListener('DOMContentLoaded', main);

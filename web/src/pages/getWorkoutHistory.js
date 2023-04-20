import WorkoutClient from '../api/workoutClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the get workout history page of the website.
 */
class GetWorkoutHistory extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'getFullWorkoutHistory'], this);
        this.dataStore = new DataStore();
        // this.dataStore.addChangeListener(this.getFullWorkoutHistory);
        // this.dataStore.addChangeListener(this.addWorkoutsToPage);
        this.header = new Header(this.dataStore);
        // this.authenticator = new Authenticator();
        console.log("getWorkoutHistory constructor");
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        this.header.addHeaderToPage();

        this.client = new WorkoutClient();

        this.getFullWorkoutHistory();


    }


    async clientLoaded() {
        const identity = await this.client.getIdentity();
        const customerId = identity.email;
        document.getElementById('workouts').innerText = "Loading Workouts ...";
        const workouts = await this.client.getFullWorkoutHistoryByCustomer(customerId)
    }

    async getFullWorkoutHistory(evt) {
        const identity = await this.client.getIdentity();
        const customerId = identity.email

        // const errorMessageDisplay = document.getElementById('error-message-full-history');
        // errorMessageDisplay.innerText = ``;
        // errorMessageDisplay.classList.add('hidden');

        const workouts = await this.client.getFullWorkoutHistoryByCustomer(customerId);
        this.dataStore.set('workouts', workouts);
        await this.addWorkoutsToPage();
    }

    async addWorkoutsToPage() {
        const workouts = this.dataStore.get('workouts')

        if (workouts == null) {
            return;
        }

        let workoutHtml = '';
        let workout;
        for (workout of workouts) {
            workoutHtml += `
                <li class="workout">                  
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

        const customerName = document.getElementById("customerName");
        const currentUser = await this.client.getIdentity();
        customerName.innerText = currentUser.name;
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

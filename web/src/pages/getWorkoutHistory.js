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
        console.log("Workouts data:", workouts);
        this.addWorkoutsToPage();
    }

     addWorkoutsToPage() {
        console.log("addWorkoutToPage() start");
        const workouts = this.dataStore.get('workouts')
        console.log(workouts);
        if (workouts == null) {
            return;
        }

        const workoutsList = document.getElementById('workouts');
        console.log("Workouts list element:", workoutsList);
        workoutsList.innerHTML = '';
        for (let workout of workouts) {
            const listItem = document.createElement('li');
            listItem.className = 'workout';

            const dateSpan = document.createElement('span');
            dateSpan.className = 'title';
            dateSpan.textContent = workout.date
            listItem.appendChild(dateSpan);

            workoutsList.appendChild(listItem);
        }
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

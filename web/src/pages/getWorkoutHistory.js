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
        this.header = new Header(this.dataStore);

    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        this.header.addHeaderToPage();

        this.client = new WorkoutClient();

        this.clientLoaded();





    }


    async clientLoaded() {
        const identity = await this.client.getIdentity();
        const customerId = identity.email;
        document.getElementById('workouts').innerText = "Loading Workouts ...";
        const workouts = await this.client.getFullWorkoutHistoryByCustomer(customerId)
        this.dataStore.set('workouts', workouts);
        console.log("End clientLoaded()");
        this.addWorkoutsToPage();

    }

    async getFullWorkoutHistory(evt) {
        const identity = await this.client.getIdentity();
        this.addWorkoutsToPage();
        console.log("end getFullWorkoutHistory()");
    }

     addWorkoutsToPage() {
        console.log("addWorkoutToPage() start");
        const workouts = this.dataStore.get('workouts');
        if (workouts == null) {
            return;
        }

        const workoutsList = document.getElementById('workouts');
        workoutsList.innerHTML = '';

        let workoutHistoryHtml = '';
        workoutHistoryHtml += `<table id="workouts">
                                   <tr>
                                       <th>Date</th>
                                       <th>Workout Type</th>
                                       <th>Hours</th>
                                       <th>Minutes</th>
                                       <th>Seconds</th>
                                       <th>Distance(km)</th>
                                   </tr>
                               </table>`

        let workout;
        for (workout of workouts.workoutModels) {
            workoutHistoryHtml += `
                <table id="workouts">
                    <tr>
                        <td class="date">${workout.date}</td>
                        <td class="workoutType">${workout.workoutType}</td>
                        <td class="workoutDurationHours">${workout.durationInHours}</td>
                        <td class="workoutDurationInMinutes">${workout.durationInMinutes}</td>
                        <td class="workoutDurationInSeconds">${workout.durationInSeconds}</td>
                        <td class="distance">${workout.distance}</td>
                    </tr>
                </table>
            `;
        }
        workoutsList.innerHTML = workoutHistoryHtml;

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

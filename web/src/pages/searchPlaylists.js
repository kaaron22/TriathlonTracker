import WorkoutClient from '../api/workoutClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the get workout history page of the website.
 */
class GetWorkoutHub extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'get7dayWorkout'], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        // this.authenticator = new Authenticator();
        console.log("getWorkoutHub constructor");
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
        console.log(customerId)
        document.getElementById('workouts').innerText = "Loading Workouts ...";
        const workouts = await this.client.sevenDayWorkout(customerId,"7")
        this.dataStore.set('workouts', workouts);
        console.log("Workout object in clientLoaded()", workouts);
        console.log("End clientLoaded()");
        this.addWorkoutsToPage();

    }

    async get7dayWorkout(evt) {
        const identity = await this.client.getIdentity();
        console.log("Workouts data:", workouts);
        this.addWorkoutsToPage();
        console.log("end get7dayWorkout()");
    }

     addWorkoutsToPage() {
        const workouts = this.dataStore.get('workouts');
        if (workouts == null) {
            return;
        }

        const workoutsList = document.getElementById('workouts');
        workoutsList.innerHTML = '';

        let workoutHubHtml = '';

        workoutHubHtml += `<table id="workouts">
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
            console.log(workout.date);
            workoutHubHtml += `
               <table id="workouts">
                   <tr>
                       <td class="date">${workout.date}</td>
                       <td class="workoutType">${workout.workoutType}</td>
                       <td class="workoutDurationInHours">${workout.durationInHours}</td>
                       <td class="workoutDurationInMinutes">${workout.durationInMinutes}</td>
                       <td class="workoutDurationInSeconds">${workout.durationInSeconds}</td>
                       <td class="distance">${workout.distance}</td>
                   </tr>
               </table>
            `;
        }
        workoutsList.innerHTML = workoutHubHtml;

    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const getWorkoutHub = new GetWorkoutHub();
    getWorkoutHub.mount();
};

window.addEventListener('DOMContentLoaded', main);

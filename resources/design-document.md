# Fitness Tracker (to be determined)

## 1. Problem Statement

Fitness Tracker Unlimited is a service featuring several ways to track your personal fitness goals. Our goal is to design and develop a web-based Java application that is easy to use, reliable, and provides users with the tools they need to achieve their fitness goals. The application should allow users to track their workouts and nutrition, set and monitor their progress towards their goals, and view analytics and insights to help them make data-driven decisions about their fitness routines.

## 2. Top Questions to Resolve in Review

1. What are the most important features that users are looking for in a fitness tracking application?
2. How can we ensure that the user application is friendly to use while still providing useful functionality?
3. What endpoints do we need to create (i.e. PUT, POST, etc.)?

## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a Fitness Tracker customer, I want to log exercise sessions as I complete them

U2. As a Fitness Tracker customer, I want to track my weight

U3. As a Fitness Tracker customer, I want to view my workout history

U4. As a Fitness Tracker customer, I want to know when I reach a milestone or new personal best

U5. As a Fitness Tracker customer, I want to log nutritional details of my meals (i.e. carbs, calories)

U6. As a Fitness Tracker customer, I want to be able to log my water intake

U7. As a Fitness Tracker customer, I want to be able to view my water intake history

U8. As a Fitness Tracker customer, I want to view a history of meals

## 4. Project Scope

### 4.1. In Scope

* Creating completed exercise events and retrieving all exercises a customer has created
* Creating current weight values and retrieving a list of weights by date
* Tracking milestones (specifics TBD)
* Creating and retrieving logs with nutritional details of meals 
* Creating and retrieving logs of water intake

### 4.2. Out of Scope

* Integration with external fitness devices
* Personalized workout recommendations
* Nutritional recommendations
* Scheduling workouts / workout reminders
* Social features (sharing favorite workouts, etc.)

## 5. Proposed Architecture Overview

This initial iteration will provide the minimum lovable product (MLP) including creating and retrieving several health and nutrition related statistics for a user.

We will use API Gateway and Lambda to create nine endpoints (CreateExerciseLog, GetExerciseLogs, CreateWeightLog, GetWeightLogs, CreateMealLog, GetMealLogs, CreateWaterIntakeLog, GetWaterIntakeLogs, GetMilestones) that will handle the creation and/or retrieval of the corresponding health information to satisfy our requirements.

We will store completed exercise, meal, and water intake logs each in a separate table in DynamoDB.

FitnessTracker will also provide a web interface for users to manage their fitness logs. A main page providing a list view of all of their fitness events will let them create new logs and link off to pages per-log to update metadata or delete log.

## 6. API

### 6.1. Public Models

```
// WaterLogModel

String customerId
LocalDateTime timestamp
String customerName
Double ounces
```

```
// MealLogModel

String customerId
LocalDateTime timestamp
String name
String type
Double calories
Double carbs
Double protein
Double fat
```

```
// ExerciseLogModel

String customerId
LocalDateTime timestamp
String exerciseType
String description
Double caloriesBurned
Integer numReps
Double numSets
Double duration
Double distance
```

```
// WeightLogModel

String customerId
LocalDateTime timestamp
Double weight
```

### 6.2. _First Endpoint_

_Describe the behavior of the first endpoint you will build into your service API. This should include what data it requires, what data it returns, and how it will handle any known failure cases. You should also include a sequence diagram showing how a user interaction goes from user to website to service to database, and back. This first endpoint can serve as a template for subsequent endpoints. (If there is a significant difference on a subsequent endpoint, review that with your team before building it!)_

_(You should have a separate section for each of the endpoints you are expecting to build...)_

### 6.3 _Second Endpoint_

_(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)_

## 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

## 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)_

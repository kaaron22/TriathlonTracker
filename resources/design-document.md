# Fitness Tracker

## 1. Problem Statement

Fitness Tracker is a service featuring several ways to track your personal health and fitness goals. Our goal is to design and develop a web-based Java application that is easy to use, reliable, and provides users with the tools they need to achieve their fitness goals. The application should allow users to track their workouts and nutrition, and view history to help them make data-driven decisions about their health and fitness routines.

## 2. Top Questions to Resolve in Review

1. What are the most important features that users are looking for in a fitness tracking application?
2. How can we ensure that the user application is friendly to use while still providing useful functionality?
3. What endpoints do we need to create (i.e. PUT, POST, etc.)?

## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a Fitness Tracker customer, I want to log exercise sessions as I complete them

U2. As a Fitness Tracker customer, I want to track my weight

U3. As a Fitness Tracker customer, I want to view my workout history

U4. As a Fitness Tracker customer, I want to log nutritional details of my meals (i.e. carbs, calories)

U5. As a Fitness Tracker customer, I want to be able to log my water intake

U6. As a Fitness Tracker customer, I want to be able to view my water intake history

U7. As a Fitness Tracker customer, I want to view a history of meals

## 4. Project Scope

### 4.1. In Scope

* Creating completed exercise events and retrieving all exercises a customer has created
* Creating current weight values and retrieving a list of weights by date
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

We will use API Gateway and Lambda to create nine endpoints (CreateExerciseLog, GetExerciseLogs, CreateWeightLog, GetWeightLogs, CreateMealLog, GetMealLogs, CreateWaterIntakeLog, GetWaterIntakeLogs) that will handle the creation and/or retrieval of the corresponding health information to satisfy our requirements.

We will store completed exercise, meal, and water intake logs each in a separate table in DynamoDB.

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

### 6.2. CreateExerciseLog Endpoint

* Accepts `POST` requests to `/exercise-logs`
* Accepts data to create a new ExerciseLog with the required fields (customerId, timestamp, exerciseType) and optional fields (description, caloriesBurned, numReps, numSets, duration, distance)

![Client sends create exercise log form to Website Exercise Log page. Website
Exercise Log page sends a create request to CreateExerciseLogActivity.
CreateExerciseLogActivity saves updates to the exercise logs
database.](images/design_document/CreateExerciseLog.png)

### 6.3. GetExerciseLogs Endpoint

* Accepts `GET` requests to `/exercise-logs/:customerId`
* Accepts a customerId and returns the corresponding list of ExerciseLog objects for the specified customer



### 6.4. CreateMealLog Endpoint

* Accepts `POST` requests to `/meal-logs`
* Accepts data to create a new MealLog with the required fields (customerId, timestamp, name, type) and optional fields (calories, carbs, protein, fat)

### 6.5. GetMealLogs Endpoint

* Accepts `GET` requests to `/meal-logs/:customerId`
* Accepts a customerId and returns the corresponding list of MealLog objects for the specified customer

### 6.6. CreateWaterLog Endpoint

* Accepts `POST` requests to `/water-logs`
* Accepts data to create a new ExerciseLog with the required fields (customerId, timestamp, ounces)

### 6.7. GetWaterLogs Endpoint

* Accepts `GET` requests to `/water-logs/:customerId`
* Accepts a customerId and returns the corresponding list of WaterLog objects for the specified customer

### 6.8. CreateWeightLog Endpoint

* Accepts `POST` requests to `/weight-logs`
* Accepts data to create a new ExerciseLog with the required fields (customerId, timestamp, weight)

### 6.9. GetWeightLogs Endpoint

* Accepts `GET` requests to `/weight-logs/:customerId`
* Accepts a customerId and returns the corresponding list of WeightLog objects for the specified customer

## 7. Tables

### 7.1. `water_logs`

```
customerId // partition key, string
timestamp // sort key, string
customerName // string
ounces // number
```

### 7.2. `meal_logs`

```
customerId // partition key, string
timestamp // sort key, string
name // string
type // string
calories // number
carbs // number
protein // number
fat // number
```

### 7.3. `exercise_logs`

```
customerId // partition key, string
timestamp // sort key, string
String exerciseType // string
String description // string
Double caloriesBurned // number
Integer numReps // number
Double numSets // number
Double duration // number
Double distance // number
```

### 7.4. `weight_logs`

```
customerId // partition key, string
timestamp // sort key, string
weight // number
```

## 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)_

package com.nashss.se.musicplaylistservice.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;
import com.nashss.se.musicplaylistservice.models.WorkoutType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nashss.se.musicplaylistservice.models.WorkoutType.SWIMMING;

@Singleton
public class WorkoutDao {
    private final Logger log = LogManager.getLogger();
    private final DynamoDBMapper dynamoDbMapper;
    private final MetricsPublisher metricsPublisher;
    private final String CUSTOMER_ID_INDEX = "CustomerIdIndex";
    private final String WORKOUT_TYPE_INDEX = "WorkoutTypeIndex";
    /**
     * Instantiates a WorkoutDao object.
     *
     * @param dynamoDbMapper   the {@link DynamoDBMapper} used to interact with the triathlon table
     * @param metricsPublisher the {@link MetricsPublisher} used to record metrics.
     */
    @Inject
    public WorkoutDao(DynamoDBMapper dynamoDbMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDbMapper = dynamoDbMapper;
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * Returns the  Workout corresponding to the specified id.
     *
     * @param workoutId the Triathlon ID
     * @return the stored Workout, or null if none was found.
     */
    public Triathlon getTriathlon(String workoutId) {
        return this.dynamoDbMapper.load(Triathlon.class, workoutId);
    }

    public List<Triathlon> getSevenDayHistory (String customerId, int numberOfDays) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(numberOfDays);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;


        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":customerId", new AttributeValue().withS(customerId));
        valueMap.put(":startDate", new AttributeValue().withS(startDate.format(formatter)));
        valueMap.put(":endDate", new AttributeValue().withS(endDate.format(formatter)));

        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("#dateAttr", "date");

        DynamoDBQueryExpression<Triathlon> queryExpression = new DynamoDBQueryExpression<Triathlon>()
                .withIndexName(CUSTOMER_ID_INDEX)
                .withConsistentRead(false)
                .withKeyConditionExpression("customerId = :customerId")
                .withFilterExpression("#dateAttr BETWEEN :startDate and :endDate")
                .withExpressionAttributeValues(valueMap)
                .withExpressionAttributeNames(nameMap);

        return dynamoDbMapper.query(Triathlon.class, queryExpression);

    }
    public Map<String,Integer> getWorkoutTypeNum (String customerId, int numberOfDays) {

        Map<String,Integer> workoutByType = new HashMap<>();
        List<Triathlon> sevenDayResult = getSevenDayHistory(customerId, numberOfDays);
            for(Triathlon workout : sevenDayResult) {
                if(workout.getWorkoutType().equals("SWIMMING")){
                    if(!workoutByType.containsKey("swim")){
                        workoutByType.put("swim", 1);
                    }
                    else{workoutByType.put("swim", workoutByType.get("swim")+1);

                    }
                }
                if(workout.getWorkoutType().equals("BIKING")){
                    if(!workoutByType.containsKey("bike")){
                        workoutByType.put("bike", 1);
                    }
                    else{workoutByType.put("bike", workoutByType.get("bike")+1);

                    }
                }
                if(workout.getWorkoutType().equals("RUNNING")){
                    if(!workoutByType.containsKey("run")){
                        workoutByType.put("run", 1);
                    }
                    else{workoutByType.put("run", workoutByType.get("run")+1);

                    }
                }
            }
            return workoutByType;
    }
//    public Integer getTypeSevenDay (String customerId, int numberOfDays) {
//        LocalDate endDate = LocalDate.now();
//        LocalDate startDate = endDate.minusDays(numberOfDays);
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//
//
//        Map<String, AttributeValue> valueMap = new HashMap<>();
//        valueMap.put(":customerId", new AttributeValue().withS(customerId));
//        valueMap.put(":startDate", new AttributeValue().withS(startDate.format(formatter)));
//        valueMap.put(":endDate", new AttributeValue().withS(endDate.format(formatter)));
//        valueMap.put(":workoutType", new AttributeValue().withS("SWIMMING"));
//
//        Map<String, String> nameMap = new HashMap<>();
//        nameMap.put("#dateAttr", "date");
//
//        DynamoDBQueryExpression<Triathlon> queryExpression = new DynamoDBQueryExpression<Triathlon>()
//                .withIndexName(CUSTOMER_ID_INDEX)
//                .withConsistentRead(false)
//                .withKeyConditionExpression("customerId = :customerId AND workoutType = :workoutType")
//                .withFilterExpression("#dateAttr BETWEEN :startDate and :endDate")
//                .withExpressionAttributeValues(valueMap)
//                .withExpressionAttributeNames(nameMap);
//
//        List<Triathlon> swimList = dynamoDbMapper.query(Triathlon.class, queryExpression);
//        log.info("swim{}", swimList.size());
//        return swimList.size();
//    }

//    public Integer getBikeTypeSevenDay (String customerId, int numberOfDays) {
//        LocalDate endDate = LocalDate.now();
//        LocalDate startDate = endDate.minusDays(numberOfDays);
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//
//
//        Map<String, AttributeValue> valueMap = new HashMap<>();
//        valueMap.put(":customerId", new AttributeValue().withS(customerId));
//        valueMap.put(":startDate", new AttributeValue().withS(startDate.format(formatter)));
//        valueMap.put(":endDate", new AttributeValue().withS(endDate.format(formatter)));
//        valueMap.put(":workoutType", new AttributeValue().withS("BIKING"));
//
//        Map<String, String> nameMap = new HashMap<>();
//        nameMap.put("#dateAttr", "date");
//
//        DynamoDBQueryExpression<Triathlon> queryExpression = new DynamoDBQueryExpression<Triathlon>()
//                .withIndexName(CUSTOMER_ID_INDEX)
//                .withConsistentRead(false)
//                .withKeyConditionExpression("customerId = :customerId AND workoutType = :workoutType")
//                .withFilterExpression("#dateAttr BETWEEN :startDate and :endDate")
//                .withExpressionAttributeValues(valueMap)
//                .withExpressionAttributeNames(nameMap);
//
//        List<Triathlon> bikeList = dynamoDbMapper.query(Triathlon.class, queryExpression);
//        log.info("bike{}", bikeList.size());
//        return bikeList.size();
//    }

//    public Integer getRunTypeSevenDay (String customerId, int numberOfDays) {
//        LocalDate endDate = LocalDate.now();
//        LocalDate startDate = endDate.minusDays(numberOfDays);
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//
//
//        Map<String, AttributeValue> valueMap = new HashMap<>();
//        valueMap.put(":customerId", new AttributeValue().withS(customerId));
//        valueMap.put(":startDate", new AttributeValue().withS(startDate.format(formatter)));
//        valueMap.put(":endDate", new AttributeValue().withS(endDate.format(formatter)));
//        valueMap.put(":workoutType", new AttributeValue().withS("RUNNING"));
//
//        Map<String, String> nameMap = new HashMap<>();
//        nameMap.put("#dateAttr", "date");
//
//        DynamoDBQueryExpression<Triathlon> queryExpression = new DynamoDBQueryExpression<Triathlon>()
//                .withIndexName(CUSTOMER_ID_INDEX)
//                .withConsistentRead(false)
//                .withKeyConditionExpression("customerId = :customerId AND workoutType = :workoutType")
//                .withFilterExpression("#dateAttr BETWEEN :startDate and :endDate")
//                .withExpressionAttributeValues(valueMap)
//                .withExpressionAttributeNames(nameMap);
//
//        List<Triathlon> runList = dynamoDbMapper.query(Triathlon.class, queryExpression);
//        log.info("run{}", runList.size());
//        return runList.size();
//    }
    /**
     * Saves (creates or updates) the given playlist.
     *
     * @param workout The workout to save
     * @return The Triathlon object that was saved
     */
    public Triathlon saveTriathlon(Triathlon workout) {
        this.dynamoDbMapper.save(workout);
        return workout;
    }
}
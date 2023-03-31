## This demo shows how Spring batch works, the workflow of steps, chunking and transaction boundaries with in a chunk


### How to build application

`mvn clean package`

### How to run application

`java -jar target/spring-batch-example.jar`

#### or

`mvn spring-boot:run`


### How to Access H2-console
[H2 Console](http://localhost:8080/h2-console/)

### How to Query the Spring Batch databae, for jobs, Jobs instances and Steps belong to a Job instance
`SELECT BEX.JOB_EXECUTION_ID, BEX.JOB_INSTANCE_ID, BEX.STATUS, BEX.EXIT_CODE, JOB_NAME,JOB_KEY, STEP_EXECUTION_ID,STEP_NAME, BSE.STATUS as Batch_Step_Status, READ_COUNT,WRITE_COUNT, ROLLBACK_COUNT, BSE.EXIT_CODE as Batch_step_exit_code  
FROM BATCH_JOB_EXECUTION as BEX
INNER JOIN BATCH_JOB_INSTANCE AS BJI ON BEX.JOB_INSTANCE_ID = BJI.JOB_INSTANCE_ID
INNER JOIN BATCH_STEP_EXECUTION as BSE ON BSE.JOB_EXECUTION_ID  = BEX.JOB_EXECUTION_ID`

SELECT * FROM BATCH_JOB_EXECUTION;

SELECT * from BATCH_JOB_EXECUTION_PARAMS;

SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT ;

SELECT * FROM BATCH_JOB_INSTANCE;

SELECT * FROM BATCH_STEP_EXECUTION;

SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT;

SELECT * FROM PEOPLE;
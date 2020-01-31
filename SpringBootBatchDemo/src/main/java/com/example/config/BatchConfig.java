package com.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration //Spring Batch의 모든 Job은 @Configuration으로 등록해서 사용합니다.
@EnableBatchProcessing
public class BatchConfig {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  public BatchConfig(
      JobBuilderFactory jobBuilderFactory,
      StepBuilderFactory stepBuilderFactory) {
    this.jobBuilderFactory = jobBuilderFactory;
    this.stepBuilderFactory = stepBuilderFactory;
  }

  @Bean
  public Step myStep() {
//    return stepBuilderFactory.get("myStep").<String, String> chunk(1)
//        .reader(new Reader()).processor(new Processor())
//        .writer(new Writer()).build();

    //simpleStep1 이란 이름의 Batch Step을 생성합니다.
    //jobBuilderFactory.get("simpleJob")와 마찬가지로 Builder를 통해 이름을 지정합니다.
    //Step 안에서 수행될 기능들을 명시합니다.
    //Tasklet은 Step안에서 단일로 수행될 커스텀한 기능들을 선언할때 사용합니다.
    //여기서는 Batch가 수행되면 log.info(">>>>> This is Step1") 가 출력되도록 합니다.
    return stepBuilderFactory.get("simpleStep1")
        .tasklet((contribution, chunkContext) -> {
          System.out.println(">>>>> This is Step1");
          return RepeatStatus.FINISHED;
        })
        .build();
  }

  @Bean
  public Job sampleJob(){
    //simpleJob 이란 이름의 Batch Job을 생성합니다.
    //job의 이름은 별도로 지정하지 않고, 이렇게 Builder를 통해 지정합니다.
    return jobBuilderFactory.get("simpleJob")
        .start(myStep())
        .build();
  }

  @Scheduled(cron = "1 * * * * *")
  public String startScheduler(){
    System.out.println("Start");
    return "start";
  }
}
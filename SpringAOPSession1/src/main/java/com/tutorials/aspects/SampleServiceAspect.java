package com.tutorials.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceAspect.class);
    @Before("execution(* com.tutorials.service.SampleService.createSample (java.lang.String)) && args(sampleName)")
    public void beforeSampleCreation(String sampleName) {
        LOGGER.info("A request was issued for a sample name: "+sampleName);
    }
}
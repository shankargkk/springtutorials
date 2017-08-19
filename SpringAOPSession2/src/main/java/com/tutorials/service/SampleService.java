package com.tutorials.service;

import org.springframework.stereotype.Service;

import com.tutorials.data.Sample;

@Service
public class SampleService {
    public Sample createSample(String sampleName) {
        Sample sample = new Sample();
        sample.setName(sampleName);
        return sample;
    }
}
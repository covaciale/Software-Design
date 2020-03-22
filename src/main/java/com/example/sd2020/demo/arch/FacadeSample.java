package com.example.sd2020.demo.arch;

import java.util.List;

public class FacadeSample {

    private SampleOperations sampleOperations;

    public FacadeSample(SampleOperations sampleOperations) {
        this.sampleOperations = sampleOperations;
    }

    public List<Integer> retrieveList() {
        return sampleOperations.getList();
    }

}

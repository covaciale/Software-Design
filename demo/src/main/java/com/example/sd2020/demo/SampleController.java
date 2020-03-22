package com.example.sd2020.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    private List<Integer> sampleList;

    public SampleController() {
        sampleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sampleList.add(i);
        }
    }

    @GetMapping("/") // localhost:8080/
    public String getHelloWorld() {
        return "Hello SD 2020";
    }

    @GetMapping("/allList") // localhost:8080/allList
    public List<Integer> getAllList() {
        return sampleList;
    }

    @PostMapping("/insertItem")
    public void insertItem(Integer item) {
        sampleList.add(item);
    }
}

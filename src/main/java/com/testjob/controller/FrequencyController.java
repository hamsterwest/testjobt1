package com.testjob.controller;

import com.testjob.service.FrequencyCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class FrequencyController {
    FrequencyCheckService frequencyCheckService = new FrequencyCheckService();
    @GetMapping("/frequency-check")
    public LinkedHashMap getStringForCharacterFrequency(@RequestParam(value = "string") String str) {
        if (str.isEmpty()) {
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("Error", "Query parameter is empty string");
            return map;
        }
        return frequencyCheckService.checkCharacterFrequency(str);
    }
}

package com.testjob.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyCheckService {
    public LinkedHashMap<Character, Long> checkCharacterFrequency(String str) {
        HashMap<Character, Long> map = Arrays
                .asList(str.split("")).stream().map(s -> s.charAt(0))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));

        LinkedHashMap<Character, Long> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        return result;
    }
}

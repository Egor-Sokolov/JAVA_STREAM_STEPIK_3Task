package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // write your code here
        HashMap<String, Integer> result = new HashMap<>();
        // Создаем Map где в качестве ключа слово,
        // а в качестве значения то сколько раз слово встретилось в тексте
        (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                .lines()
                .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .forEach(w -> {
                    if(result.containsKey(w)) result.put(w, result.get(w) + 1);
                    else result.put(w, 1);
                });
        // Сортируем Мапу по количеству слов в обратном порядке, по словам в лексикографическом
        // и выводим первых 10 элементов в stdout
        result.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if(e1.getValue().equals(e2.getValue())) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());})
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}

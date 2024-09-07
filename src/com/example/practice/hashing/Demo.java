package com.example.practice.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * list => 1 2 3 4 5 6 7 8
 * sum = 8
 * find pairs whose sum is 8
 */

/**
 * list => 2 3 1 5 4 1 9 3 2
 * output = 5
 * Find first non repeating number in an list - O(n)
 */
public class Demo {
    public static void main(String[] args) {
//        tryWithIntegers();

        Car car1  = new Car("Tata", "Nexon", 2022);
        Car car2  = new Car("Tata", "Punch", 2023); // 101
        Car punch  = new Car("Tata", "Punch", 2023); // 109
        Car car3  = new Car("Suzuki", "Baleno", 2022);

        HashMap<Car, Integer> priceMap = new HashMap<>();

        priceMap.computeIfAbsent(punch, car -> car.getYear() == 2023 ? 9 : 10); // put the entry if not present
        priceMap.computeIfPresent(car1, (car, integer) -> 12); // update the entry if present

        priceMap.put(car1, 11);
//        priceMap.put(car2, 9);
        priceMap.put(car3, 8);

             priceMap
                .values()
                .stream()
                .filter(price -> price > 10)
                .forEach(System.out::println);

        Integer punchPrice = priceMap.get(punch);
        System.out.println("Price: " + punchPrice);

    }

    private static int getPunchPrice(Map<Car, Integer> priceMap) {
        Car punch  = new Car("Tata", "Punch", 2023);
        return priceMap.get(punch);
    }

    private static void tryWithIntegers() {
        HashMap<Integer, String> cities = new HashMap<>();
        cities.put(1, "Bangalore");
        cities.put(2, "Pune");
        cities.put(3, "Delhi");
        cities.put(4, "Indore");
//        for (int i = 1; i <= 4; i++) {
//            System.out.println(cities.get(i));
//        }

        for(Map.Entry entry : cities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        cities.containsKey(1);
        cities.containsValue("");
        cities.getOrDefault(100, "None");
    }
}

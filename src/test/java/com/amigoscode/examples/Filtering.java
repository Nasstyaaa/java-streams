package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> cars1 = cars.stream()
                .filter(car -> car.getPrice() < 10_000.00)
                .filter(car -> car.getColor().equals("Blue"))
                .collect(Collectors.toList());
        System.out.println(cars1);
    }

    @Test
    public void dropWhile() throws Exception {
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void takeWhile() throws Exception {
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 9, 3, 4, 5, 6, 7, 8, 9, 10};
        int num = Arrays.stream(numbers).filter(n -> n == 9)
                .findFirst()
                .orElse(-1);
        System.out.println(num);
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int num = Arrays.stream(numbers).filter(n -> n == 9)
                .findAny()
                .orElse(-1);
        System.out.println(num);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10, 11};
        boolean match = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(match);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean match = Arrays.stream(evenAndOneOdd).anyMatch(n -> n % 2 == 0);
        System.out.println(match);
    }

}




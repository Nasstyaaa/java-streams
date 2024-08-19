package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> list = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .toList();
        list.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> list = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();
        list.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> list = people.stream()
                .sorted(Comparator
                        .comparing(Person::getFirstName)
                        .reversed())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> list = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Blue"))
                .sorted(Comparator.comparing(Car::getPrice)
                        .reversed())
                .limit(10)
                .toList();
        list.forEach(System.out::println);
    }

}

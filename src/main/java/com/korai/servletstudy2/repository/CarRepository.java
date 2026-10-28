package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static final CarRepository instance = new CarRepository();
    private final List<Car> cars;
    private int lastId = 0;

    private CarRepository() {
        cars = new ArrayList<>();
        insert(new Car(0, "씽씽카", 30000, "삼성"));
        insert(new Car(0, "붕붕카", 30000, "현대"));
    }

    public static CarRepository getInstance() {
        return instance;
    }

    public synchronized void insert(Car car) {
        car.setId(++lastId);   // 1, 2, 3 ... 순서대로 부여
        cars.add(car);
    }

    public synchronized List<Car> findAll() {
        return cars.stream().map(Car::new).toList();
    }
}
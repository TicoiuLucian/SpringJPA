package org.example.repository;

import org.example.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

  List<Car> findByManufacturer(String producator);

  List<Car> findByManufacturerAndModel(String producator, String model);

  @Query(value = "SELECT * FROM CAR c", nativeQuery = true)
  Page<Car> findCars(Pageable pageable);
}

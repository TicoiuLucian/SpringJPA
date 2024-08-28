package org.example;

import jakarta.annotation.PostConstruct;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class Main {

  @Autowired
  private CarRepository carRepository;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @PostConstruct
  public void init() {
    Pageable pageable = PageRequest.of(2, 3);
    Page<Car> all = carRepository.findCars(pageable);
    System.out.println("All elements: " + all.getTotalElements());
    System.out.println("All pages: " + all.getTotalPages());
    all.getContent().forEach(System.out::println);
  }
}
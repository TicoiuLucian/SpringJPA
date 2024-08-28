package org.example;

import jakarta.annotation.PostConstruct;
import org.example.entity.Car;
import org.example.entity.Owner;
import org.example.repository.CarRepository;
import org.example.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class Main {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private OwnerRepository ownerRepository;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @PostConstruct
  public void init() {
//    Pageable pageable = PageRequest.of(2, 3);
//    Page<Car> all = carRepository.findCars(pageable);
//    System.out.println("All elements: " + all.getTotalElements());
//    System.out.println("All pages: " + all.getTotalPages());
//    all.getContent().forEach(System.out::println);

    Owner owner = new Owner("Lucian", 32);
    owner.addCarToOwner(new Car("Audi", "A3", 13999f));
    owner.addCarToOwner(new Car("BMW", "M4", 50000f));
    owner.addCarToOwner(new Car("Dacia", "Logan", 1999f));

    ownerRepository.save(owner);

  }
}
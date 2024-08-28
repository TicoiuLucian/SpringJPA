package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Integer age;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private List<Car> cars = new ArrayList<>();

  public Owner(final String name, final Integer age) {
    this.name = name;
    this.age = age;
  }

  public void addCarToOwner(final Car car) {
    this.cars.add(car);
    car.setOwner(this);
  }
}

package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "sold = false")
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "car_id")
  private Integer carId;

  private String manufacturer;

  private String model;

  private Float price;

  @ManyToOne(cascade = CascadeType.MERGE)
  private Owner owner;

  public Car(final String manufacturer, final String model, final Float price) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.price = price;
  }
}



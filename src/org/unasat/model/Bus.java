package org.unasat.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dionc on 2/24/2017.
 */

@Entity
@Table(name="BUS")
public class Bus implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "brand", nullable = false)
    @NotBlank
    private String brand;

    @Column(name = "max_passengers")
    private Long maxPassengers;

    @Column(name = "licence_plate",unique = true, nullable = false, length = 15)
    @NotBlank
    private String licencePlate;

    public Bus() {
    }

    public Bus(String brand, Long maxPassengers, String licencePlate) {
        this.brand = brand;
        this.maxPassengers = maxPassengers;
        this.licencePlate = licencePlate;
    }

    public Bus(Long id, String brand, Long maxPassengers, String licencePlate) {
        this.id = id;
        this.brand = brand;
        this.maxPassengers = maxPassengers;
        this.licencePlate = licencePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(Long maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}

package org.unasat.model;

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

    @Column(name = "max_passengers", nullable = false)
    @NotBlank
    private Long maxPassengers;

    @Column(name = "licence_plate", nullable = false, length = 15)
    @NotBlank
    private String licencePlate;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude",nullable = false)
    private BigDecimal longitude;

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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
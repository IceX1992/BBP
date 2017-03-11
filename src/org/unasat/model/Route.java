package org.unasat.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dionc on 2/24/2017.
 */
@Entity
@Table(name = "ROUTE")
public class Route implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "departure", nullable = false)
    @NotBlank
    private String departure;

    @Column(name = "destination", nullable = false)
    @NotBlank
    private String destination;

    @Column(name = "price_per_passenger")
    private Double pricePerPassenger;

    public Route(String name, String departure, String destination, Double pricePerPassenger) {
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.pricePerPassenger = pricePerPassenger;
    }

    public Route(Long id,String name, String departure, String destination, Double pricePerPassenger) {
        this.id = id;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.pricePerPassenger = pricePerPassenger;
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getPricePerPassenger() {
        return pricePerPassenger;
    }

    public void setPricePerPassenger(Double pricePerPassenger) {
        this.pricePerPassenger = pricePerPassenger;
    }


}

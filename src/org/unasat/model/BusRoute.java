package org.unasat.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by dionc on 2/25/2017.
 */
@Entity
@Table(name="BUS_ROUTE")
public class BusRoute{


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "estimated_departure", nullable = false, columnDefinition = "DATETIME")
    @NotBlank
    private String estimatedDeparture;

    @Column(name = "estimated_arrival", nullable = false, columnDefinition = "DATETIME")
    @NotBlank
    private String estimatedDArrival;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bus bus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Route route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstimatedDeparture() {
        return estimatedDeparture;
    }

    public void setEstimatedDeparture(String estimatedDeparture) {
        this.estimatedDeparture = estimatedDeparture;
    }

    public String getEstimatedDArrival() {
        return estimatedDArrival;
    }

    public void setEstimatedDArrival(String estimatedDArrival) {
        this.estimatedDArrival = estimatedDArrival;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }





}

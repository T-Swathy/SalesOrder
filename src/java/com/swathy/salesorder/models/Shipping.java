/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swathy.salesorder.models;

/**
 *
 * @author vanit
 */
public class Shipping {

    private String shipmentId;
    private String shipmentDate;
    private String carrier;
    private String trackingId;

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentId() {
        return this.shipmentId;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentDate() {
        return this.shipmentDate;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingId() {
        return this.trackingId;
    }

}


package com.swathy.salesorder.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author swathy
 */
public class Order {

    private String customerName, salesOrderDate, expectedShipmentDate, paymentTerms, salesOrderNo,
            shipmentCharge, totalAmount, orderStatus,
            invoiceStatus, paymentStatus;

    private List<Item> Items = new ArrayList<>();

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(Item item) {
        this.Items.add(item);
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderDate(String salesOrderDate) {
        this.salesOrderDate = salesOrderDate;
    }

    public String getSalesOrderDate() {
        return salesOrderDate;
    }

    public void setExpectedShipmentDate(String expectedShipmentDate) {
        this.expectedShipmentDate = expectedShipmentDate;
    }

    public String getExpectedShipmentDate() {
        return expectedShipmentDate;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setShipmentCharge(String shipmentCharge) {
        this.shipmentCharge = shipmentCharge;
    }

    public String getShipmentCharge() {
        return this.shipmentCharge;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceStatus() {
        return this.invoiceStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

}

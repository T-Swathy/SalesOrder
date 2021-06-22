
package com.swathy.salesorder.models;

/**
 *
 * @author vanit
 */
public class Item {

    private String[] products, quantity, rate, discount, amount;
    private String productRate, productDiscount, productAmount, productName, quantityPacked, quantityShipped, quantityDelivered;

    public String getQuantityDelivered() {
        return quantityDelivered;
    }

    public void setQuantityDelivered(String quantityDelivered) {
        this.quantityDelivered = quantityDelivered;
    }
    private String productQuantity;

    public void setProducts(String[] products) {
        this.products = products;
    }

    public String[] getProducts() {
        return this.products;
    }

    public String getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(String quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public void setQuantity(String[] quantity) {
        this.quantity = quantity;
    }

    ;

public String[] getQuantity() {
        return this.quantity;
    }

    public void setRate(String[] rate) {
        this.rate = rate;
    }

    public String[] getRate() {
        return this.rate;
    }

    public void setDiscount(String[] discount) {
        this.discount = discount;
    }

    public String[] getDiscount() {
        return this.discount;
    }

    public void setAmount(String[] amount) {
        this.amount = amount;
    }

    public String[] getAmount() {
        return this.amount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate;
    }

    public String getProductRate() {
        return this.productRate;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductDiscount() {
        return this.productDiscount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductAmount() {
        return this.productAmount;
    }

    public void setQuantityPacked(String quantityPacked) {
        this.quantityPacked = quantityPacked;
    }

    public String getQuantityPacked() {
        return this.quantityPacked;
    }

}

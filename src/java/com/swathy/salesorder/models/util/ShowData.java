

package com.swathy.salesorder.models.util;

/**
 * @author swathy
 */


// utility model for displaying data in packages ,shipping since this data is combination of multiple models
public class ShowData {
    private String salesOrderNo,salesOrderDate,packageId,packageDate,shipmentId,shipmentDate,quantityPacked;

    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public String getSalesOrderDate() {
        return salesOrderDate;
    }

    public void setSalesOrderDate(String salesOrderDate) {
        this.salesOrderDate = salesOrderDate;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageDate() {
        return packageDate;
    }

    public void setPackageDate(String packageDate) {
        this.packageDate = packageDate;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
   
}

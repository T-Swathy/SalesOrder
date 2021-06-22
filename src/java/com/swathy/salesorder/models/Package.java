
package com.swathy.salesorder.models;

/**
 *
 * @author vanit
 */
public class Package {

    private String packageId;
    private String packageDate, packageStatus;
    private String packageQuantity[], itemName[];

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public void setPackageDate(String packageDate) {
        this.packageDate = packageDate;
    }

    public String getPackageDate() {
        return this.packageDate;
    }
    public void setQuantity(String[] packageQuantity)
    {
        this.packageQuantity=packageQuantity;
    }
    public String[] getQuantity()
    {
        return this.packageQuantity;
    }
    public void setPackageStatus(String packageStatus)
    {
        this.packageStatus=packageStatus;
    }
    public String getPackageStatus()
    {
        return this.packageStatus;
    }
     public void setItemName(String[] itemName)
    {
        this.itemName=itemName;
    }
    public String[] getItemName()
    {
        return this.itemName;
    }
 
    
    
}

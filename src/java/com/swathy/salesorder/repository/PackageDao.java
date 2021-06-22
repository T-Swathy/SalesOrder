package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.models.util.ShowData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackageDao {

    public static List<ShowData> getAllPackages(String salesOrderNo) {
        List<ShowData> list = new ArrayList<ShowData>();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select SalesOrder,SalesOrderDate,PackageId,PackageDate from orderdetails inner join  packages using(SalesOrder) where SalesOrder=? and PackageStatus='Yet to be shipped' ");
            ps.setString(1, salesOrderNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShowData e = new ShowData();
                e.setSalesOrderNo(rs.getString(1));
                e.setSalesOrderDate(rs.getString(2));

                e.setPackageId(rs.getString(3));
                e.setPackageDate(rs.getString(4));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Package getPackageNumber(String salesorderno) {
        Package e = new Package();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select PackageId from packages where SalesOrder=?");
            ps.setString(1, salesorderno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setPackageId(rs.getString(1));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int savePackage(Package e, String salesOrderNo) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into packages(PackageId,SalesOrder,PackageDate,PackageStatus) values (?,?,?,?)");
            ps.setString(1, e.getPackageId());

            ps.setString(2, salesOrderNo);
            ps.setString(3, e.getPackageDate());
            ps.setString(4, "Yet to be shipped");

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int savePackageItems(Package e) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into packageitems(PackageId,Item,Quantity) values (?,?,?)");

            String packageId = e.getPackageId();
            String[] quantities = e.getQuantity();
            String[] itemName = e.getItemName();

            for (int i = 0; i < itemName.length; i++) {

                ps.setString(1, packageId);
                ps.setString(2, itemName[i]);
                ps.setString(3, quantities[i]);

                status = ps.executeUpdate();
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int updatePackageStatus(String packageId) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update packages set PackageStatus='Yet to be delivered' where PackageId=?");
            ps.setString(1, packageId);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int updateDeliveryStatus(String packageId) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update packages set PackageStatus='Delivered' where PackageId=?");
            ps.setString(1, packageId);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}

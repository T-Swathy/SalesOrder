package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Shipping;
import com.swathy.salesorder.models.util.ShowData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShippingDao {

    public static List<ShowData> getAllShippings(String salesOrderNo) {
        List<ShowData> list = new ArrayList<>();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select PackageId,shippingId,shippingDate from packages inner join  shipping using(PackageId) where SalesOrder=? and PackageStatus='Yet to be delivered'");
            ps.setString(1, salesOrderNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShowData e = new ShowData();

                e.setPackageId(rs.getString(1));
                e.setShipmentId(rs.getString(2));
                e.setShipmentDate(rs.getString(3));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int saveShipment(Shipping e, String packageId) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into shipping(PackageId,shippingId,shippingDate,carrier,trackingId) values (?,?,?,?,?)");
            ps.setString(1, packageId);

            ps.setString(2, e.getShipmentId());
            ps.setString(3, e.getShipmentDate());
            ps.setString(4, e.getCarrier());
            ps.setString(5, e.getTrackingId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}


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

    public static List<ShowData> getAllShippings() {
        List<ShowData> list = new ArrayList<>();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select SalesOrder,PackageId,shippingId,shippingDate from orderdetails inner join  shipping using(SalesOrder) where orderStatus='Yet to be delivered'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShowData e = new ShowData();

                e.setSalesOrderNo(rs.getString(1));
                e.setPackageId(rs.getString(2));
                e.setShipmentId(rs.getString(3));
                e.setShipmentDate(rs.getString(4));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int saveShipment(Shipping e, String packageId, String salesOrderNo) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into shipping(PackageId,SalesShipping,shippingId,shippingDate,carrier,trackingId) values (?,?,?,?,?,?)");
            ps.setString(1, packageId);

            ps.setString(2, salesOrderNo);
            ps.setString(3, e.getShipmentId());
            ps.setString(4, e.getShipmentDate());
            ps.setString(5, e.getCarrier());
            ps.setString(6, e.getTrackingId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}

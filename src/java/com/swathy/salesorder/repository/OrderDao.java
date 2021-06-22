package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Order;
import java.util.*;
import java.sql.*;


/**
 *
 * @author swathy
 */
public class OrderDao {

    public static int save(Order e) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into orderdetails(CustomerName,SalesOrder,SalesOrderDate,ExpectedShipmentDate,PaymentTerms,ShippingCharges,TotalAmount,InvoiceStatus,PaymentStatus) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, e.getCustomerName());
            ps.setString(2, e.getSalesOrderNo());
            ps.setString(3, e.getSalesOrderDate());
            ps.setString(4, e.getExpectedShipmentDate());
            ps.setString(5, e.getPaymentTerms());
            ps.setString(6, e.getShipmentCharge());
            ps.setString(7, e.getTotalAmount());

            ps.setString(8, "not invoiced");
            ps.setString(9, "not paid");
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static List<Order> getAllOrder() {
        List<Order> list = new ArrayList<Order>();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select SalesOrder,SalesOrderDate,CustomerName,InvoiceStatus,PaymentStatus from orderdetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order e = new Order();

                e.setSalesOrderNo(rs.getString(1));
                e.setSalesOrderDate(rs.getString(2));
                e.setCustomerName(rs.getString(3));

                e.setInvoiceStatus(rs.getString(4));
                e.setPaymentStatus(rs.getString(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Order getOrderById(String salesorderno) {
        Order e = new Order();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select CustomerName,SalesOrder,SalesOrderDate,ExpectedShipmentDate,PaymentTerms,ShippingCharges,TotalAmount from orderdetails where SalesOrder=?");
            ps.setString(1, salesorderno);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setCustomerName(rs.getString(1));
                e.setSalesOrderNo(rs.getString(2));
                e.setSalesOrderDate(rs.getString(3));
                e.setExpectedShipmentDate(rs.getString(4));
                e.setPaymentTerms(rs.getString(5));
                e.setShipmentCharge(rs.getString(6));
                e.setTotalAmount(rs.getString(7));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int updateInvoice(String salesOrderNo) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update orderdetails set InvoiceStatus='Invoiced' where SalesOrder=?");
            ps.setString(1, salesOrderNo);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int updatePayment(String salesOrderNo) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update orderdetails set PaymentStatus='Paid' where SalesOrder=?");
            ps.setString(1, salesOrderNo);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}

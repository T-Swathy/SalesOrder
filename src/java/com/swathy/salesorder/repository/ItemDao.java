
package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.models.util.ShowData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author swathy
 */
public class ItemDao {

    public static List<Item> getItemByNo(String salesorderno) {
        List<Item> list = new ArrayList<Item>();
        try {
            Connection con = DbOperations.getConnection();

            PreparedStatement ps = con.prepareStatement("select ItemName,Quantity,Rate,Discount,Amount from items where SalesOrder=? order by ItemName ");
            ps.setString(1, salesorderno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item e = new Item();
                e.setProductName(rs.getString(1));
                e.setProductQuantity(rs.getString(2));
                e.setProductRate(rs.getString(3));
                e.setProductDiscount(rs.getString(4));
                e.setProductAmount(rs.getString(5));
                list.add(e);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Item> getQuantitiesPacked(String salesorderno, List<Item> li) {
        List<Item> list = new ArrayList<Item>();

        int i = 0;

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select sum(Quantity) from packages inner join packageitems using(PackageId) where SalesOrder=?  group by Item order by Item");
            ps.setString(1, salesorderno);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {

                while (i <= li.size() - 1) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked("0");
                    list.add(e);
                    i++;

                }
            } else {

                while (rs.next()) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked(rs.getString(1));
                    list.add(e);
                    i++;

                }
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static List<Item> getQuantitiesShipped(String salesorderno, List<Item> li) {
        List<Item> list = new ArrayList<Item>();

        int i = 0;

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select sum(Quantity) from packages inner join packageitems using(PackageId) where SalesOrder=? and (PackageStatus='Yet to be delivered' or PackageStatus='Delivered') group by Item order by Item");
            ps.setString(1, salesorderno);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {

                while (i <= li.size() - 1) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked(li.get(i).getQuantityPacked());
                    e.setQuantityShipped("0");
                    list.add(e);
                    i++;

                }
            } else {

                while (rs.next()) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked(li.get(i).getQuantityPacked());
                    e.setQuantityShipped(rs.getString(1));
                    list.add(e);
                    i++;

                }
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static List<Item> getQuantitiesDelivered(String salesorderno, List<Item> li) {
        List<Item> list = new ArrayList<Item>();

        int i = 0;

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select sum(Quantity) from packages inner join packageitems using(PackageId) where SalesOrder=? and PackageStatus='Delivered'  group by Item order by Item");
            ps.setString(1, salesorderno);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {

                while (i <= li.size() - 1) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked(li.get(i).getQuantityPacked());
                    e.setQuantityShipped(li.get(i).getQuantityShipped());
                    e.setQuantityDelivered("0");
                    list.add(e);
                    i++;

                }
            } else {

                while (rs.next()) {
                    Item e = new Item();
                    e.setProductName(li.get(i).getProductName());
                    e.setProductQuantity(li.get(i).getProductQuantity());
                    e.setProductRate(li.get(i).getProductRate());
                    e.setProductDiscount(li.get(i).getProductDiscount());
                    e.setProductAmount(li.get(i).getProductAmount());
                    e.setQuantityPacked(li.get(i).getQuantityPacked());
                    e.setQuantityShipped(li.get(i).getQuantityShipped());
                    e.setQuantityDelivered(rs.getString(1));
                    list.add(e);
                    i++;

                }
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static List<Item> getPackageById(String packageId) {
        List<Item> list = new ArrayList<Item>();

        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement("select Item,Quantity from packageitems  where PackageId=? ");
            ps.setString(1, packageId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item e = new Item();

                e.setProductName(rs.getString(1));
                e.setQuantityPacked(rs.getString(2));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int saveItems(Item e, String salesOrderNo) {
        int status = 0;
        try {
            Connection con = DbOperations.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into items(SalesOrder,ItemName,Quantity,Rate,Discount,Amount) values (?,?,?,?,?,?)");
            String[] products = e.getProducts();
            String[] quantities = e.getQuantity();
            String[] rates = e.getRate();
            String[] discounts = e.getDiscount();
            String[] amounts = e.getAmount();
            for (int i = 0; i < products.length; i++) {

                ps.setString(1, salesOrderNo);
                ps.setString(2, products[i]);
                ps.setString(3, quantities[i]);
                ps.setString(4, rates[i]);
                ps.setString(5, discounts[i]);
                ps.setString(6, amounts[i]);

                status = ps.executeUpdate();
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}

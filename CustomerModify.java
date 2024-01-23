/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VI TRUNG VIET
 */
public class CustomerModify {

    public static List<Customer> findAll() {
        List<Customer> listCustomer = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {// lay tat ca Khach Hang
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendien", "root","");

            //truy van
            String sql = "Select * from khachhang";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Customer ctm = new Customer(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), 
                        resultSet.getString("address"), resultSet.getInt("num"), resultSet.getInt("money"), resultSet.getString("sdt"));
                
              listCustomer.add(ctm);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null)
                try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listCustomer;

    }

    public static void insert(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {// lay tat ca sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendien", "root", "");

            //truy van
            String sql = "insert into khachhang( name, age, address, num, money,sdt) values (?,?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, customer.getTenKH());
            statement.setInt(2, customer.getNSKH());
            statement.setString(3, customer.getDCKH());
            statement.setInt(4, customer.getSokhoi());
            statement.setInt(5, customer.getThanhtien());
             statement.setString(6, customer.getSDT());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null)
                try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
    public static void update(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {// lay tat ca sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendien", "root", "");

            //truy van
            String sql = "update khachhang set name=?,age=?,address=?,num=?,money=,sdt=?,  where id=?";
            statement = connection.prepareCall(sql);
           
            statement.setString(1, customer.getTenKH());
            statement.setInt(2, customer.getNSKH());
            statement.setString(3, customer.getDCKH());
            statement.setInt(4, customer.getSokhoi());
            statement.setInt(5, customer.getThanhtien());
            statement.setString(6, customer.getSDT());

             
                      statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null)
                try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
       public static void delete(int  id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendien", "root", "");

            //truy van
             String sql = "delete from khachhang where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
        public static List<Customer> findByFullname(String fullname) {
        List<Customer> CustomerList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendien", "root", "");
            
            //query
            String sql = "select * from khachhang where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Customer ctm = new Customer(resultSet.getInt("id"), 
                        resultSet.getString("name"), resultSet.getInt("age"), 
                        resultSet.getString("address"), resultSet.getInt("num"), 
                        resultSet.getInt("money"),resultSet.getString("sdt"));
                CustomerList.add(ctm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return CustomerList;
    }
}

package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;
import entity.Company;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Company objCompany = (Company) obj;
        try {
            String sql = "INSERT INTO company(name, sector, ubication, contact) VALUES(?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objCompany.getName());
            objPrepare.setString(2, objCompany.getSector());
            objPrepare.setString(3, objCompany.getUbication());
            objPrepare.setString(4, objCompany.getContact());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objCompany.setId(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCompany;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listCompany= new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM company;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
                Company objCompany = new Company();
                objCompany.setId(objResult.getInt("id"));
                objCompany.setName(objResult.getString("name"));
                objCompany.setSector(objResult.getString("sector"));
                objCompany.setUbication(objResult.getString("ubication"));
                objCompany.setContact(objResult.getString("contact"));
                listCompany.add(objCompany);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listCompany;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Company objCompany = (Company) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE company SET name = ?, sector = ?, ubication = ?, contact = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objCompany.getName());
            objPrepare.setString(2, objCompany.getSector());
            objPrepare.setString(3, objCompany.getUbication());
            objPrepare.setString(4, objCompany.getContact());
            objPrepare.setInt(5, objCompany.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                isUpDate = true;
                JOptionPane.showMessageDialog(null, "The update was succesful");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isUpDate;
    }

    @Override
    public boolean delete(Object obj) {
        Company objCompany= (Company) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM company WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objCompany.getId());
            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                idDelete = true;
                JOptionPane.showMessageDialog(null, "The delete was succesful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return idDelete;
    }

}

package model;

import database.CRUD;
import database.ConfigDB;
import entity.Company;
import entity.Hiring;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HiringModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Hiring objHiring = (Hiring) obj;
        try {
            String sql = "INSERT INTO hiring(vacant_id, coder_id, date_aplication,state, salary) VALUES(?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objHiring.getVacant_id());
            objPrepare.setInt(2, objHiring.getCoder_id());
            objPrepare.setString(3, objHiring.getDate_aplication());
            objPrepare.setString(4, "INACTIVE");
            objPrepare.setFloat(5, objHiring.getSalary());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objHiring.setId(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objHiring;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listHiring= new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM hiring;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
                Hiring objHiring = new Hiring();
                objHiring.setId(objResult.getInt("id"));
                objHiring.setVacant_id(objResult.getInt("vacant_id"));
                objHiring.setCoder_id(objResult.getInt("coder_id"));
                objHiring.setDate_aplication(objResult.getString("date_aplication"));
                objHiring.setState(objResult.getString("state"));
                objHiring.setSalary(objResult.getFloat("salary"));
                listHiring.add(objHiring);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listHiring;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Hiring objHiring = (Hiring) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE hiring SET vacant_id = ?, coder_id = ?, date_aplication= ?, state = ? ,salary = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objHiring.getVacant_id());
            objPrepare.setInt(2, objHiring.getCoder_id());
            objPrepare.setString(3, objHiring.getDate_aplication());
            objPrepare.setString(4, "INACTIVE");
            objPrepare.setFloat(5, objHiring.getSalary());
            objPrepare.setInt(6, objHiring.getId());

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
        Hiring objHiring= (Hiring) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM hiring WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objHiring.getId());
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

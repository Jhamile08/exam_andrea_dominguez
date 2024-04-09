package model;

import database.ConfigDB;
import entity.Company;
import entity.Vacant;
import database.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacantModel implements CRUD{
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacant objVacant = (Vacant) obj;
        try {
            String sql = "INSERT INTO vacant(company_id, title, description, state, tecnology) VALUES(?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objVacant.getCompany_id());
            objPrepare.setString(2, objVacant.getTitle());
            objPrepare.setString(3, objVacant.getDescription());
            objPrepare.setString(3, objVacant.getDuration());
            objPrepare.setString(4, "ACTIVE");
            objPrepare.setString(5, objVacant.getTecnology());

            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objVacant.setId(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objVacant;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listVacant= new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM vacant;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
                Vacant objVacant = new Vacant();
                objVacant.setId(objResult.getInt("id"));
                objVacant.setCompany_id(objResult.getInt("company_id"));
                objVacant.setTitle(objResult.getString("title"));
                objVacant.setDescription(objResult.getString("description"));
                objVacant.setDuration(objResult.getString("duration"));
                objVacant.setState(objResult.getString("state"));
                System.out.println(objVacant.getState());
                objVacant.setTecnology(objResult.getString("tecnology"));
                listVacant.add(objVacant);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacant;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacant objVacant = (Vacant) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE vacant SET company_id = ?, title = ?, description = ?,duration = ?, tecnology = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objVacant.getCompany_id());
            objPrepare.setString(2, objVacant.getTitle());
            objPrepare.setString(3, objVacant.getDescription());
            objPrepare.setString(4, objVacant.getDuration());
            objPrepare.setString(5, objVacant.getTecnology());
            objPrepare.setInt(6, objVacant.getId());

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
    public boolean upDateState(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacant objVacant = (Vacant) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE vacant SET state = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, "INACTIVE");
            objPrepare.setInt(2, objVacant.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if(totalRowAffected > 0){
                isUpDate = true;
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
        Vacant objVacant= (Vacant) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM vacant WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objVacant.getId());
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

    public List<Vacant> foundByname(String name){
        List<Vacant> listVacant = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM vacant WHERE title or tecnology like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1,"%"+name+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                Vacant objVacant = new Vacant();
                objVacant.setId(objResult.getInt("id"));
                objVacant.setTitle(objResult.getString("title"));
                objVacant.setDescription(objResult.getString("description"));
                objVacant.setTecnology(objResult.getString("tecnology"));
                listVacant.add(objVacant);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listVacant;
    }

    }



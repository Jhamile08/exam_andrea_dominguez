package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        try {
            String sql = "INSERT INTO coder(name, surname, identity, cohorte, cv, clan) VALUES(?,?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setString(2, objCoder.getSurname());
            objPrepare.setString(3, objCoder.getIdentity());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());
            objPrepare.execute();
            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objCoder.setId(objRest.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listCoder= new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM coder;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while(objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setSurname(objResult.getString("surname"));
                objCoder.setIdentity(objResult.getString("identity"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setCv(objResult.getString("cv"));
                listCoder.add(objCoder);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return listCoder;
    }

    @Override
    public boolean upDate(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        boolean isUpDate = false;
        try {
            String sql = "UPDATE coder SET name = ?, surname = ?, identity = ?, cohorte = ?, cv = ?, clan = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setString(2, objCoder.getSurname());
            objPrepare.setString(3, objCoder.getIdentity());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());
            objPrepare.setInt(7, objCoder.getId());

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
        Coder objCoder= (Coder) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean idDelete = false;

        try {
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objCoder.getId());
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
    public List<Coder> foundByName(String name){
        //se crea la lista
        List<Coder> listBooks = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM coder WHERE clan like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1, "%"+name+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

                while(objResult.next()) {
                    Coder objCoder = new Coder();
                    objCoder.setId(objResult.getInt("id"));
                    objCoder.setName(objResult.getString("name"));
                    objCoder.setSurname(objResult.getString("surname"));
                    objCoder.setCohorte(objResult.getInt("cohorte"));
                    objCoder.setClan(objResult.getString("clan"));

                    listBooks.add(objCoder);

                }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listBooks;
    }
    public List<Coder> foundByCohorte(String name){
        //se crea la lista
        List<Coder> listBooks = new ArrayList<>();
        //abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();


        try {
            // Sentencia sql
            String sql = "SELECT * FROM coder WHERE cohorte like ?;";
            // Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // valor al parametro
            objPrepare.setString(1, "%"+name+"%");
            //Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setSurname(objResult.getString("surname"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setClan(objResult.getString("clan"));

                listBooks.add(objCoder);

            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        // Cerrar la conexion
        ConfigDB.closeConnection();
        return listBooks;
    }


}

package database;

import java.sql.*;

// Esta clase se encargara de establecer y cerrar la conexion en la base de datos
public class ConfigDB {
    // este atrubuto tendra el estado de la conexion
    static Connection objConnection = null;
    // Metodo para conectar la bd
    public static Connection openConnection(){
        try {
            //Llamamos al driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos la variable de conexion
            String url = "jdbc:mysql://localhost:3306/coders";
            String user = "root";
            String password = "Rlwl2023.";
            //establecer conexion
            objConnection =  (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecte perfectamente");
        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver no instalado" + error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar la base de datos" + error.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            // Si hay una conexion actica entonces la cierra
            if( objConnection != null) objConnection.close();
            System.out.println("Se finalizo la conexion con exito");
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}

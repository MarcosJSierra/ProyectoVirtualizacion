/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kurokami.proyectovirtualizacion.conexion;

/**
 *
 * @author marcos
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OperacionesSql {
    
    public static int pcSeleccionada;
    
    public OperacionesSql(){
        pcSeleccionada = 1;
    }
    
    public void insertarDato(int dato){
        String sentencia = "INSERT INTO Datos(dato) VALUES(?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexiones.getConnection();
            stmt = conn.prepareStatement(sentencia);
            stmt.setInt(1, dato);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                Conexiones.close(stmt);
                Conexiones.close(conn);
            }
        }
    }
    
    public int getTotal(){
        String sentencia = "SELECT dato FROM Datos";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int acumulador = 0;
        int tmp = pcSeleccionada;
        for(int i = 0; i < 4; i++){
            pcSeleccionada = i;
            try{
                conn = Conexiones.getConnection();
                stmt = conn.prepareStatement(sentencia);
                rs = stmt.executeQuery();
                while(rs.next()){
                    acumulador = acumulador + rs.getInt(1);
                }


            } catch (SQLException exe){
                Logger.getLogger(OperacionesSql.class.getName()).log(Level.SEVERE, null, exe);
            }finally{
                if(conn != null){
                    Conexiones.close(rs);
                    Conexiones.close(stmt);
                    Conexiones.close(conn);
                }
            }
        }
        pcSeleccionada = tmp;
        return acumulador;
    }
    
}

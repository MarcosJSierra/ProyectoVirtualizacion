/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kurokami.proyectovirtualizacion.conexion;

import java.sql.*;


/**
 *
 * @author marcos
 */
public class Conexiones {
    public static final String CADENA_PC_1 = "jdbc:mariadb://192.168.2.120:3306/datosvirtualizacion";
    public static final String CADENA_PC_2 = "jdbc:mariadb://192.168.2.121:3306/datosvirtualizacion";
    public static final String CADENA_PC_3 = "jdbc:mariadb://192.168.2.122:3306/datosvirtualizacion";
    public static final String CADENA_PC_4 = "jdbc:mariadb://192.168.2.123:3306/datosvirtualizacion";
    public static final String USUARIO_PC_1 = "usuariov";
    public static final String PASS_PC_1 = "cliente";
    public static final String USUARIO_PC_2 = "usuariov";
    public static final String PASS_PC_2 = "cliente";
    public static final String USUARIO_PC_3 = "usuariov";
    public static final String PASS_PC_3 = "cliente";
    public static final String USUARIO_PC_4 = "usuariov";
    public static final String PASS_PC_4 = "cliente";
    public static synchronized Connection getConnection() throws SQLException{
        if(org.kurokami.proyectovirtualizacion.conexion.OperacionesSql.pcSeleccionada == 0){
            return DriverManager.getConnection(CADENA_PC_1, USUARIO_PC_1, PASS_PC_1);
        } else if(org.kurokami.proyectovirtualizacion.conexion.OperacionesSql.pcSeleccionada == 1){
            return DriverManager.getConnection(CADENA_PC_2, USUARIO_PC_2, PASS_PC_2);
        } else if(org.kurokami.proyectovirtualizacion.conexion.OperacionesSql.pcSeleccionada == 2){
            return DriverManager.getConnection(CADENA_PC_3, USUARIO_PC_3, PASS_PC_3);
        } else {
            return DriverManager.getConnection(CADENA_PC_4, USUARIO_PC_4, PASS_PC_4);
        }
         
    }
    
    public static void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
}

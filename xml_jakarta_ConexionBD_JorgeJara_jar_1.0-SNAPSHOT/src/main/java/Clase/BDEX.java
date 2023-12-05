/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;


/**
 *
 * Clase de prueba de BDEX para entrar a la bbdd con pool 
 */
public class BDEX {
    
    public void conn(){
        
        try{
            // instancia del tipo PoolData source 
            PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
                    
            pds.setConnectionFactoryClassName("com.mysql.cj.jdbc.Driver"); // datos de conexion para el pool 
            pds.setURL("jdbc:mysql://localhost:3306/jcvd"); // my bbdd 
            pds.setUser("GM"); // my usuario 
            pds.setPassword("1234"); // contraseña 
            
            Connection conn = pds.getConnection(); // en lugar de usar coon , como ejemplos anteriores, usamos la conexion a traves del pools 
            
            System.out.println("\n Connnection obtained from " // mensaje informatvos 
                    + "UnniversalConnectionPool\n");
            
//            String consulta = "Select * from videojuegos";
            Statement stmt = conn.createStatement(); // creamos el statement 
//            ResultSet rs = stmt.executeQuery(consulta);
     
      
            Metodos met = new Metodos();
//            met.lanzaConsulta(consulta);
            
//               while(rs.next()){
////                String Sgenerado = rs.getString(1);
////                System.out.println("Clave generada = "+Sgenerado);
//                System.out.println("      Datos de busqueda");
//                System.out.println("id: " + rs.getInt("id"));
//                System.out.println("Nombre: " + rs.getString("Nombre"));
//                System.out.println("Genero: " + rs.getString("Genero"));
//                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
//                System.out.println("Compañia: " + rs.getString("Compañia"));
//                System.out.println("Precio: " + rs.getFloat("Precio"));
//                System.out.println("-------------------------------------------");
//               }
            
            conn.close();
            conn=null;
            
            System.out.println("Connection returned to the UnniversalConnectionPool\n ");
                    
        }catch( Exception ex){
            
        }
    }
    
}

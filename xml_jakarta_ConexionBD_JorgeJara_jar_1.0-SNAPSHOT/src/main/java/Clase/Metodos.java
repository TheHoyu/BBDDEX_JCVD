package Clase;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import static xml_jakarta.conexionbd_jorgejara.ConexionBD_JorgeJara.pds;

/**
 *
 * @author Hoyu
 */
public class Metodos {

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "GM";
    static final String PASS = "1234";

    

//    public void mostrar() throws SQLException {
//        String QUERY = "SELECT * FROM videojuegos";
//
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(QUERY);
//
//            while (rs.next()) {
//                System.out.println("id: " + rs.getInt("id"));
//                System.out.println("Nombre: " + rs.getString("Nombre"));
//                System.out.println("Genero: " + rs.getString("Genero"));
//                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
//                System.out.println("Compañia: " + rs.getString("Compañia"));
//                System.out.println("Precio: " + rs.getFloat("Precio"));
//                System.out.println("-------------------------------------------");
//            }
//
//            stmt.close();
////            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
        

    public boolean buscaNombre(String nombre) throws SQLException {
        String QUERY = "SELECT * FROM  videojuegos where Nombre = ? ";

        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            String consulta = "Select * from videojuegos where nombre = ? ";
            Connection conn = pds.getConnection(); // usamos el pds establecido en el main . para conectar a la bbdd 
            /*
            // hacemos que la sencencia, en lugar de ir por el objeto conn de ejercicios anteriores ,  vaya por 
            el pool 
            */
            PreparedStatement sentencia = conn.prepareStatement(QUERY); 
            sentencia.setString(1,nombre); // le decimos al programa que la interrogación n1 equivale a nombre 
            ResultSet rs = sentencia.executeQuery(); // ejecutamos la consulta 
            
               /*
            bucle que nos muestra el contenido de la consulta, va extrayendo los métodos 
            get int para sacar numeros enteros, string para los strings, y para sacar fecha
            */
                
            while(rs.next()){
                String Sgenerado = rs.getString(1);
                System.out.println("Clave generada = "+Sgenerado);
                System.out.println("      Datos de busqueda");
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("-------------------------------------------");
                return true;
            }

   

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("El juego no existe ");
        return false;
    }
    
    public void lanzaConsulta (String consulta) throws SQLException {
//        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";
            
        try {
            Connection conn = pds.getConnection(); // usamos el pds establecido en el main . para conectar a la bbdd 
            /*
            // hacemos que la sencencia, en lugar de ir por el objeto conn de ejercicios anteriores ,  vaya por 
            el pool 
            */
            Statement stmt = conn.createStatement(); // sentencia que derivará en Resultset  
            ResultSet rs = stmt.executeQuery(consulta);// resulset que usa , la sencia, y la query 

            /*
            bucle que nos muestra el contenido de la consulta, va extrayendo los métodos 
            get int para sacar numeros enteros, string para los strings, y para sacar fecha
            */
            
            while (rs.next()) {
                System.out.println("Resultado de consulta:");
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("-------------------------------------------");
            
            }

            stmt.close(); // cerramos la conexión 

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
                
    }
    
    public boolean eliminarRegistro (int eliminar) throws SQLException {
        
//        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";
        String QUERY = "DELETE  FROM  videojuegos where id = ?";
            
        try {
            Connection conn = pds.getConnection(); // usamos el pds establecido en el main . para conectar a la bbdd 
            PreparedStatement sentencia = conn.prepareStatement(QUERY); 
            sentencia.setInt(1,eliminar);
            int rs = sentencia.executeUpdate();            
            System.out.println("JUEGO ELIMINADO CON EXITO");

//            while (rs.next()) {
//                System.out.println("Resultado de consulta:");
//                System.out.println("id: " + rs.getInt("id"));
//                System.out.println("Nombre: " + rs.getString("Nombre"));
//                System.out.println("Genero: " + rs.getString("Genero"));
//                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
//                System.out.println("Compañia: " + rs.getString("Compañia"));
//                System.out.println("Precio: " + rs.getFloat("Precio"));
//                System.out.println("-------------------------------------------");
//            
//            }

            conn.close();
        return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("JUEGO NO ELIMINADO");
   return true;
    }

           /*
    Método que pide los datos de juego por teclado, y nos genera un objeto videojuegos 
    */
     public videojuego datosJuego(videojuego newGame) throws ParseException {
        
        Scanner sc = new Scanner(System.in); // generamos el scanner 
        String Nombre, Genero, Compañia, FechaLanzamiento; // instanciamos las variables 
        double Precio; 
        
        System.out.println("Introduce Los datos del juego: ");
        System.out.println("-------------------------------");
        System.out.print("Introduce nombre del juego : ");
        Nombre = sc.nextLine();  // asociamos la variable - al scanner 
        newGame.setNombre(Nombre);
        System.out.println("-------------------------------");
        System.out.print("Introduce Genero del juego : ");
        Genero = sc.nextLine();  // asociamos la variable - al scanner 
        newGame.setGenero(Genero);
        System.out.println("-------------------------------");
        System.out.print("Introduce la Compañia: ");
        Compañia = sc.nextLine();  // asociamos la variable - al scanner 
        newGame.setCompañia(Compañia);
        System.out.println("-------------------------------");

        // <editor-fold defaultstate="collapsed" desc="-Fecha-">
//        System.out.println("Introduce la fecha de lanzamiento");
//        FechaLanzamiento = sc.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
//        newGame.setFechaLanzamiento(fechaLanzamiento);
        // </editor-fold>
//        System.out.print("Introduce la fecha de lanzamiento yyyy-MM-dd: ");
//        FechaLanzamiento = sc.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
//        java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
//        newGame.setFechaLanzamiento(sqlFechaLanzamiento);

        /*
            no nos vamos a engañar, en el tema de la fecha, he usado gpt 
        */

        System.out.print("Introduce la fecha de lanzamiento dd-MM-yyyy: ");
        FechaLanzamiento = sc.nextLine();  // asociamos la variable - al scanner 
        // le damos a la fecha el formato que queremos 
        SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaLanzamiento = dateFormatInput.parse(FechaLanzamiento);

        SimpleDateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
        // usamos java.sql.Date para que el programa lo reconozca coomo fecha 
        
        newGame.setFechaLanzamiento(sqlFechaLanzamiento);
        System.out.println("-------------------------------");
                System.out.print("Introduce el precio: ");
        Precio = sc.nextDouble();
        newGame.setPrecio(Precio);

        return newGame;
        
        }
        
//    public void Insert() throws ParseException {
//
//    videojuego ng = new videojuego();
//    datosJuego(ng);
//
//    String insert = "INSERT INTO videojuegos(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (?,?,?,?,?)";
//
//    try {
//        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        PreparedStatement sentencia = conn.prepareStatement(insert);
//        sentencia.setString(1, ng.getNombre());
//        sentencia.setString(2, ng.getGenero());
//        sentencia.setDate(3, ng.getFechaLanzamiento());
//        sentencia.setString(4, ng.getCompañia());
//        sentencia.setDouble(5, ng.getPrecio());
//
//        // Ejecutar la consulta
//        sentencia.executeUpdate();
//
//        conn.close();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}

    
    public void Insert() throws ParseException {
        
        videojuego ng = new videojuego();
        datosJuego(ng);      
        
        
//        String insert = "INSERT INTO `videojuegos`(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) "
//                + "VALUES ('" + ng.getNombre() + "','" + ng.getGenero() + "','" + ng.getFechaLanzamiento() + "','"
//                + ng.getCompañia() + "'," + ng.getPrecio() + ")";

//        String insert = "INSERT INTO videojuegos(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (null,?,?,?,?,?)";
        String insert = "INSERT INTO videojuegos(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (?,?,?,?,?)";

        

        try {
             Connection conn = pds.getConnection(); // usamos el pds establecido en el main . para conectar a la bbdd 
            /*
            // hacemos que la sencencia, en lugar de ir por el objeto conn de ejercicios anteriores ,  vaya por 
            el pool 
            */
            PreparedStatement sentencia = conn.prepareStatement(insert);
            sentencia.setString(1,ng.getNombre()); // asociamos la ? 1 al nombre 
            sentencia.setString(2, ng.getGenero());// asociamos la ? 2 al genero 
            sentencia.setDate(3, ng.getFechaLanzamiento());// asociamos la ? 3 a la fecha 
            sentencia.setString(4,ng.getCompañia());// asociamos la ? 4 a la fecha 
            sentencia.setDouble(5,ng.getPrecio());// asociamos la ?5 al precio 
            sentencia.executeUpdate();// ejecutamos la consutla 
            
            // <editor-fold defaultstate="collapsed" desc="-Definición-">
            //            while(rs.next()){
//            System.out.println("id: "+rs.getInt("id"));
//            System.out.println("Nombre: "+rs.getString("Nombre"));
//            System.out.println("Genero: "+rs.getString("Genero"));
//            System.out.println("Fecha de lanzamiento: "+rs.getDate("FechaLanzamiento"));
//            System.out.println("Compañia: "+rs.getString("Compañia"));
//            System.out.println("Precio: "+rs.getFloat("Precio"));
//            System.out.println("-------------------------------------------");
//            }
            // </editor-fold>
            
            
            conn.close();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } 
        
    /*
    metodo con el que insertamos el videojuego por parámetro 
    en lugar de general el juego, lo damos nosotrs escribiendolo a traves del programa ( en el main ) 
    */
    
    
    public void Insert_param(String nombre,String genero, Date fechaLanzamiento, String Compañia, int Precio) throws ParseException {



        String insert = "INSERT INTO videojuegos(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (?,?,?,?,?)";

        try {
        
              Connection conn = pds.getConnection(); // usamos el pds establecido en el main . para conectar a la bbdd 
            /*
            // hacemos que la sencencia, en lugar de ir por el objeto conn de ejercicios anteriores ,  vaya por 
            el pool 
            */
            
            PreparedStatement sentencia = conn.prepareStatement(insert);
            sentencia.setString(1,nombre); // asociamos la ? 1 al nombre
            sentencia.setString(2, genero); // asociamos la ? 2 al genero
//            sentencia.setDate(3,date.valueof(fechaLanzamiento)); // asociamos la ? 3 al fecha 
            sentencia.setString(4,Compañia); // asociamos la 4 a la compañia 
            sentencia.setInt(5,Precio);// asociamos la 5 al precioi 
            
//            while(rs.next()){
//            System.out.println("id: "+rs.getInt("id"));
//            System.out.println("Nombre: "+rs.getString("Nombre"));
//            System.out.println("Genero: "+rs.getString("Genero"));
//            System.out.println("Fecha de lanzamiento: "+rs.getDate("FechaLanzamiento"));
//            System.out.println("Compañia: "+rs.getString("Compañia"));
//            System.out.println("Precio: "+rs.getFloat("Precio"));
//            System.out.println("-------------------------------------------");
//            }
            conn.close();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

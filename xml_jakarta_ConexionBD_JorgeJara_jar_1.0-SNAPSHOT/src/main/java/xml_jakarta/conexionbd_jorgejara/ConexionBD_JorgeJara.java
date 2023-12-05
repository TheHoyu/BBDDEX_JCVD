package xml_jakarta.conexionbd_jorgejara;

import Clase.BDEX;
import Clase.Metodos;
import Clase.videojuego;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class ConexionBD_JorgeJara {

    public static PoolDataSource pds; // instanciamos pds como static y public, para que sea accesible dedse todo el código 

    public static void main(String[] args) throws SQLException, ParseException {
        
        /*
        Usamos pds para instanciar el pool, 
        */

        pds = PoolDataSourceFactory.getPoolDataSource();

        pds.setConnectionFactoryClassName("com.mysql.cj.jdbc.Driver"); // driver 
        pds.setURL("jdbc:mysql://localhost:3306/jcvd"); // mi bbdd
        pds.setUser("GM"); // mi usuario 
        pds.setPassword("1234");// mi contrasñeña 

        Connection conn = pds.getConnection(); // obtenemos la conexion 

        System.out.println("\n Connnection obtained from UnniversalConnectionPool\n");
        Statement stmt = conn.createStatement();
//        Metodos met = new Metodos();
//
////        met.buscaNombre("Carlos Duty");
//        met.eliminarRegistro(18);
//        met.Insert();
        
      
            
           Metodos met = new Metodos(); // instanciamos la clase metodos 
           Scanner sc = new Scanner(System.in); // generamos escaner 
           boolean continua=true; // boolean para continuar el menu hasta seleccionar salir 
                System.out.println("Bienvenido a la base de datos JCVD"); 
           System.out.println("-------------------------------------");
               System.out.println("1-buscaNombre por parametro ");
               System.out.println("2-lanzaConsulta por parametro");
               System.out.println("3-NuevoRegistro por parametro");
               System.out.println("4-NuevoRegistro  por teclado");
               System.out.println("5-elimiarRegistro");
               System.out.println("6-salir");
               System.out.println("-------------------------------------");   

               
        while (continua) { // bucle para usar el menu con variable booleana 
            System.out.println("-------------------------------------");
            System.out.print("Introduce un nº para elegir opcion: ");

            int opcion = sc.nextInt(); // opcion para el menú 
            
            switch (opcion) {
                case 1:
                    met.buscaNombre("Carlos Duty"); // metodoque busca juego por nombre por parámetro 
                    break;

                case 2: // metodo que genera una busqueda a traves de parámetro 
                    String consulta = "Select * from videojuegos where genero ='Drama social' ";
                    met.lanzaConsulta(consulta);
                    break;

                case 3: // uso del método que pide insertar un juego , por parámetro 
                    String nombre="Soldado Universal 37";
                    String genero="Drama social";
                    String FechaLanzamiento = "1994-04-19";
                    // me recalco y soy sincero, en el tema fechas chat gpt que me ha echado un cable 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                    Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
                    java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
                    String Compañia="El torete SL";
                    int Precio = 10;
                    met.Insert_param(nombre, genero, sqlFechaLanzamiento, Compañia, Precio);
                    System.out.println("INSERCION CORRECTA");
                    break;

                case 4:
                    met.Insert(); // metodo que inserta un juego a través de teclado 
                    System.out.println("INSERCION CORRECTA");
                    break;

                case 5:
                    int eliminar = 13; // método que elimina un juego pedidi por parámetro 
                    met.eliminarRegistro(eliminar);
                    break;

                case 6: // opcion de salir, rompemos la continuidad booleana, salimos del ciclo, vencemos a la matrix 
                    System.out.println("Saliendo de la base de datos");
                    continua = false;
                    break;

                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 6.");
                    break;
            }
        }
        
        sc.close(); // Cierra el scanner al finalizar el programa
        

               
        
           
//           
//           met.buscaNombre("CarlosDuty");
//           met.mostrar();
//           met.buscaNombre("Carlos Duty");
//           videojuego ng = new videojuego();
//           met.datosJuego(ng);
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Introduce nombre : ");
//            String nombre = sc.nextLine();
//            met.buscarNombre(nombre);
//
//            met.Insert();
//              String nombre="El Retorno del vaquilla";
//              String genero="Drama social";
//              String FechaLanzamiento = "1994-04-19";
//              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//              Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
//              java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
//              String Compañia="El torete SL";
//              int Precio = 10;
//              
//   
//              met.Insert_param(nombre, genero, sqlFechaLanzamiento, Compañia, Precio);
//
//            String consulta="Select * from videojuegos where genero ='Drama social' ";
//            met.lanzaConsulta(consulta );
    }
}



package xml_jakarta.conexionbd_jorgejara;

import Clase.Metodos;
import Clase.videojuego;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ConexionBD_JorgeJara {

    public static void main(String[] args) throws SQLException, ParseException {
           Metodos met = new Metodos();
           Scanner sc = new Scanner(System.in);
           boolean continua=true;
           System.out.println("Bienvenido a la base de datos JCVD");
           System.out.println("-------------------------------------");
               System.out.println("1-buscaNombre por parametro ");
               System.out.println("2-lanzaConsulta por parametro");
               System.out.println("3-NuevoRegistro por parametro");
               System.out.println("4-NuevoRegistro  por teclado");
               System.out.println("5-elimiarRegistro");
               System.out.println("6-salir");
               System.out.println("-------------------------------------");   

        while (continua) {
            System.out.println("-------------------------------------");
            System.out.print("Introduce un nº para elegir opcion: ");

            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    
                    met.buscaNombre("CupHead");
                    break;

                case 2:
                    String consulta = "Select * from videojuegos where genero ='Drama social' ";
                    met.lanzaConsulta(consulta);
                    break;

                case 3:
                
                    String nombre="EL VAQUILLA STRIKES BACK ";
                    String genero="Drama social";
                    String FechaLanzamiento = "1994-04-19";
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
                    java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
                    String Compañia="El torete SL";
                    int Precio = 10;
                    met.Insert_param(nombre, genero, sqlFechaLanzamiento, Compañia, Precio);
                    System.out.println("INSERCION CORRECTA");
                    break;

                case 4:
                    met.Insert();
                    System.out.println("INSERCION CORRECTA");
                    break;

                case 5:
                    int eliminar = 12;
                    met.eliminarRegistro(eliminar);
                    break;

                case 6:
                    System.out.println("Saliendo de la base de datos");
                    continua = false;
                    break;

                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 6.");
                    break;
            }
        }
        
        sc.close(); // Cierra el scanner al finalizar el programa
               
        
           
           
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
////            met.Insert();
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

//            String consulta="Select * from videojuegos where genero ='Drama social' ";
//            met.lanzaConsulta(consulta );
                    
            
    }
}

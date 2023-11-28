
package Clase;

import java.sql.Date;

/**
 *
 * @author Hoyu
 */
public class videojuego {
    
    private int id ;
    private String Nombre;
    private String Genero;
    private Date FechaLanzamiento;
    private String Compañia;
    private double Precio;

    public videojuego() {
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Date getFechaLanzamiento() {
        return FechaLanzamiento;
    }

    public void setFechaLanzamiento(Date FechaLanzamiento) {
        this.FechaLanzamiento = FechaLanzamiento;
    }



 

    public String getCompañia() {
        return Compañia;
    }

    public void setCompañia(String Compañia) {
        this.Compañia = Compañia;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }


}

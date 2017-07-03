/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemateca;

/**
 *
 * @author jucasval
 */
public class Peliculas {
    
    private String titulo, director;
    private int duracion;

    public Peliculas() {
    }

    public Peliculas(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    

    @Override
    public String toString() {
        return "Pelicula: "+this.titulo +"\tDirector: "+this.director+
                "\tDuración: "+this.duracion +" minutos.";
    }
    
    
    
}

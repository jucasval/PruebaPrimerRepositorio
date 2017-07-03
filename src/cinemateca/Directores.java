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
public class Directores {
    
    private String nombre, nacionalidad;
    private Peliculas p1;

    public Directores() {
    }

    public Directores(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Peliculas getP1() {
        return p1;
    }

    public void setP1(Peliculas p1) {
        this.p1 = p1;
    }
    
    

    @Override
    public String toString() {
        return "Nombre: "+this.nombre+"\tNacionalidad: "+this.nacionalidad;
    }
    
    
    
}


package cinemateca;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

/**
 *
 * @author jucasval
 */
public class Cinemateca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), 
                "cinemateca.db4o");
        
        try {
            
            //almacenarObjetos(db);
            
            QBEmostrarDatosPeliculas(db);
            System.out.println("");
            
            System.out.println("Consulta QBY");
            qbePeliculaSpielber100_180(db);
            
            System.out.println("");
            System.out.println("Consulta SODA");
            SODApeliculasSpielberg100_180(db);
            
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
            db.close();
            
        }
        
    }//fin main
    
    public static void almacenarObjetos(ObjectContainer db){
        
        Peliculas p1 = new Peliculas("Mi amigo el gigante", "Steven Spielberg", 117);
        Peliculas p2 = new Peliculas("La lista de Schindler", "Steven Spielberg",195);
        Peliculas p3 = new Peliculas("Exodo", "Otto Preminger", 213);
        Peliculas p4 = new Peliculas("Antes del amanecer", "Richard Linklater", 101);
        
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        
        Directores d1 = new Directores("Steven Spielberg", "USA");
        Directores d2 = new Directores("Otto Preminger", "Alemán");
        Directores d3 = new Directores("Richard Linklater", "USA");
        
        d1.setP1(p1);
        d1.setP1(p2);
        d2.setP1(p3);
        d3.setP1(p4);
        
        db.store(d1);
        db.store(d2);
        db.store(d3);
        
        
        
    }//fin método almacenarObjetos
    
    //consulta QBE "mostrar datos de la base de datos"
    public static void QBEmostrarDatosPeliculas(ObjectContainer db){
        
        System.out.println("=============");
        System.out.println("PELICULAS consulta QBE");
        System.out.println("=============");
        Peliculas p = new Peliculas(null, null, 0);
        ObjectSet res = db.queryByExample(p);
        mostrarConsulta(res);
        
        System.out.println("");
        System.out.println("=============");
        System.out.println("DIRECTORES consulta QBE");
        System.out.println("=============");
        Directores d = new Directores(null, null);
        ObjectSet resDir = db.queryByExample(d);
        mostrarConsulta(resDir);
        
    }
    
    //consulta SODA "mostrar datos de la base de datos
    
    //consulta QBE "películas de Steven Spielberg en 100 y 180 minutos de duración"
    public static void qbePeliculaSpielber100_180(ObjectContainer db){
        
        Peliculas p = new Peliculas(null, "Steven Spielberg",0);
        ObjectSet res = db.queryByExample(p);
        Peliculas resultadoFinal;
        
        while(res.hasNext()){
             resultadoFinal = (Peliculas) res.next();
             if(resultadoFinal.getDuracion()<181 && resultadoFinal.getDuracion()>99){
                 System.out.println(resultadoFinal);
             }
           
        }
        
        
    }//fin metodo qbePeliculaSpielber100_180()
    
    //Consulta SODA "películas de Steven Spielberg en 100 y 180 minutos de duración"
    public static void SODApeliculasSpielberg100_180(ObjectContainer db){
        
        Query query = db.query();
        query.constrain(Peliculas.class);
        Constraint contra1 = query.descend("duracion").constrain(181).smaller();
        Constraint contra2 = query.descend("duracion").constrain(99).greater();
        query.descend("director").constrain("Steven Spielberg").and(contra1).and(contra2);
        ObjectSet res = query.execute();
        mostrarConsulta(res);
        
    }
    
    public static void mostrarConsulta(ObjectSet resul){
        
        System.out.println("Recuperados "+resul.size()+" objetos.");
        while(resul.hasNext()){
            System.out.println(resul.next());
        }
        
    }
    
    
    
}//fin class

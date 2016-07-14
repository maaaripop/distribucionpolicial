package model;
// Generated 14-jul-2016 1:18:20 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Delito generated by hbm2java
 */
public class Delito  implements java.io.Serializable {


     private int idDelito;
     private Turno turno;
     private Tipodelito tipodelito;
     private String descripcion;
     private Integer latitud;
     private Integer longitud;
     private Date fecha;

    public Delito() {
    }

	
    public Delito(int idDelito, Turno turno, Tipodelito tipodelito) {
        this.idDelito = idDelito;
        this.turno = turno;
        this.tipodelito = tipodelito;
    }
    public Delito(int idDelito, Turno turno, Tipodelito tipodelito, String descripcion, Integer latitud, Integer longitud, Date fecha) {
       this.idDelito = idDelito;
       this.turno = turno;
       this.tipodelito = tipodelito;
       this.descripcion = descripcion;
       this.latitud = latitud;
       this.longitud = longitud;
       this.fecha = fecha;
    }
   
    public int getIdDelito() {
        return this.idDelito;
    }
    
    public void setIdDelito(int idDelito) {
        this.idDelito = idDelito;
    }
    public Turno getTurno() {
        return this.turno;
    }
    
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public Tipodelito getTipodelito() {
        return this.tipodelito;
    }
    
    public void setTipodelito(Tipodelito tipodelito) {
        this.tipodelito = tipodelito;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }
    public Integer getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}



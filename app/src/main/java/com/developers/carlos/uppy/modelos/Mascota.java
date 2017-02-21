package com.developers.carlos.uppy.modelos;

/**
 * Created by carlos on 29/09/16.
 */

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int cantidadMeGusta;
    private boolean meGusta;


    public Mascota() {
    }

    public Mascota(String nombre, int foto, int cantidadMeGusta, boolean meGusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadMeGusta = cantidadMeGusta;
        this.meGusta = meGusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(int cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMeGusta() {
        return meGusta;
    }

    public void setMeGusta(boolean meGusta) {
        this.meGusta = meGusta;
    }
}

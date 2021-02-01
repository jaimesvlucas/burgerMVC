/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author User
 */
public class Producto {
    private int id;
    private String nombre, categoria, imagen;
    private float precio;
    private int unidadesPedidas;

    public Producto(int id, String nombre, String imagen, String categoria, float precio, int unidadesPedidas) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;
        this.unidadesPedidas = unidadesPedidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidadesPedidas() {
        return unidadesPedidas;
    }

    public void setUnidadesPedidas(int unidadesPedidas) {
        this.unidadesPedidas = unidadesPedidas;
    }
    
}

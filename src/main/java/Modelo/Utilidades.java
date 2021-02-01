/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import Modelo.Producto;
/**
 *
 * @author User
 */
public class Utilidades {
    public static ArrayList<Producto> getProductos(String fichero) throws FileNotFoundException, IOException{
            ArrayList<Producto> productos = new ArrayList<Producto>();
            Producto p;
            try {

                    BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "utf-8"));
                    String producto;
                    String productoLinea[];
                    try {

                            while((producto = buffer.readLine())!=null) {
                                    productoLinea=producto.split(",");
                                    p = new Producto(Integer.parseInt(productoLinea[0]),productoLinea[1],productoLinea[2],productoLinea[3],Float.parseFloat(productoLinea[4]),0);
                                    productos.add(p);					
                             }

                            buffer.close();
                    } catch (IOException e) {

                    }

            } catch (FileNotFoundException | UnsupportedEncodingException e) {

            }
            return productos;		
    }
}

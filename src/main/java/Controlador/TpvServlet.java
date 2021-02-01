/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Producto;
import Modelo.Utilidades;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;

/**
 *
 * @author User
 */
public class TpvServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private ArrayList<Producto> listadoProductos = null;
    private ArrayList<Producto> hamburguesas = null;
    private ArrayList<Producto> complementos = null;
    private ArrayList<Producto> bebidas = null;
    private String rutaFichero;
    
    public void init(ServletConfig config) throws ServletException {
            listadoProductos = new ArrayList<Producto>();

            rutaFichero = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros").concat(File.separator).concat("productos.txt");
            
        try {
            listadoProductos = Utilidades.getProductos(rutaFichero);
            /**listadoProductos.add(new Producto(1,"Hamburguesa normal","burger/normal.png","hamburguesas",5.00f,0));
             * listadoProductos.add(new Producto(2,"Hamburguesa con queso","burger/queso.png","hamburguesas",5.50f,0));
             * listadoProductos.add(new Producto(3,"Hamburguesa doble","burger/doble.png","hamburguesas",7.00f,0));
             * listadoProductos.add(new Producto(4,"Patatas fritas","burger/patatas.png","complementos",1.50f,0));
             * listadoProductos.add(new Producto(5,"Nuggets","burger/nuggets.png","complementos",3.00f,0));
             * listadoProductos.add(new Producto(6,"Aros de cebolla","burger/aros.png","complementos",2.00f,0));
             * listadoProductos.add(new Producto(7,"Agua","burger/agua.png","bebidas",1.00f,0));
             * listadoProductos.add(new Producto(8,"Coca-Cola","burger/cocacola.png","bebidas",2.00f,0));
             * listadoProductos.add(new Producto(9,"Sprite","burger/sprite.png","bebidas",2.00f,0));
             * listadoProductos.add(new Producto(10,"Fanta","burger/fanta.png","bebidas",2.00f,0));*/
        } catch (IOException ex) {
            Logger.getLogger(TpvServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


           hamburguesas = new ArrayList<Producto>();
           complementos = new ArrayList<Producto>();
           bebidas = new ArrayList<Producto>();
           for ( int i=0;i<listadoProductos.size();i++) {
               Producto miProducto = listadoProductos.get(i);
               String categoria = miProducto.getCategoria();
                switch ( categoria  ) {
                    case "hamburguesas":
                            hamburguesas.add(miProducto);
                            break;
                    case "complementos":
                            complementos.add(miProducto);
                            break;
                    case "bebidas":
                            bebidas.add(miProducto); 
                            break;
                }       
            } /*for*/
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TpvServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TpvServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("hamburguesas", hamburguesas);
        request.setAttribute("bebidas", bebidas);
        request.setAttribute("complementos", complementos);
        request.getRequestDispatcher("vista/Tpv.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Producto> carrito = new ArrayList<Producto>();
        Float total = 0f;
        int numProductos = listadoProductos.size();
        int ultimoId = listadoProductos.get(numProductos-1).getId();
        int unidades=0;
        Producto productoAlCarrito;
        for(int cont=1;cont<=ultimoId;cont++){
            if(request.getParameter(String.valueOf(cont))!=null){
                if(!request.getParameter(String.valueOf(cont)).equals("")){
                    unidades = Integer.parseInt(request.getParameter(String.valueOf(cont)));
                }
            }
            if(unidades>0){
                for(Producto p:listadoProductos){
                    if(p.getId()==cont){
                        total+=p.getPrecio()*unidades;
                        productoAlCarrito = new Producto(p.getId(),p.getNombre(),p.getImagen(),p.getCategoria(),p.getPrecio(),unidades);
                        carrito.add(productoAlCarrito);
                    }
                }
            }   
        }
        request.setAttribute("carrito",carrito);
        request.setAttribute("total", total);
        request.getRequestDispatcher("vista/resumen.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

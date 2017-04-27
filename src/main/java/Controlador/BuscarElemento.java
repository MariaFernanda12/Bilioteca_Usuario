package Controlador;

import DAO.DaoElementos;
import Modelo.Elemento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarElemento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /* try (PrintWriter out = response.getWriter()) {
        
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Buscar Por nombre
        String parametro = request.getParameter("Buscar");

        Elemento elm = new Elemento();
        //1. Crear instancia del DAO        
        DaoElementos daoE = new DaoElementos();
        //Lista todos los elementos.
        elm = daoE.buscarPorNombre(parametro);
        //2. Envio de los datos por el request.
        request.setAttribute("etiqueta", elm);
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Buscar por etiqueta
        String parametro = request.getParameter("Buscar");

        Elemento elm = new Elemento();

        DaoElementos daoE = new DaoElementos();

        elm = daoE.buscar(Integer.parseInt(parametro));

        request.setAttribute("etiqueta", elm);
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("BuscarElemento.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

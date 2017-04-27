package Controlador;

import DAO.DaoPrestamo;
import Modelo.Prestamo;
import Modelo.Solicitante;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Estado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Prestamo> lista = null;
        HttpSession sesion = request.getSession();
        DaoPrestamo daoPr = new DaoPrestamo();
        Solicitante sol = (Solicitante) sesion.getAttribute("usuario");
        long id = sol.getIdentificador();
        lista = daoPr.listarActivo(id);
        request.setAttribute("Prestamo", lista);
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("EstadoUsuarios.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

package Controlador;

import DAO.DaoUsuario;
import Modelo.Solicitante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CambiarClave extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String claveNueva = request.getParameter("ClaveNueva");
        String claveAntigua = request.getParameter("ClaveAntigua");

        HttpSession sesion = request.getSession();
        DaoUsuario daoUser = new DaoUsuario();
        Solicitante sol = (Solicitante) sesion.getAttribute("usuario");
        long id = sol.getIdentificador();        
        boolean resultado = daoUser.cambiarClave(id, claveNueva, claveAntigua);

        request.setAttribute("CambioClave", resultado);
        RequestDispatcher rd = request.getRequestDispatcher("CambiarClave.jsp");
        rd.forward(request, response);

    }

}

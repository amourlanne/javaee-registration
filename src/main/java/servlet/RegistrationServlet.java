package servlet;

import entity.Inscription;
import validator.RegistrationFormValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( "/registration.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RegistrationFormValidator validator = new RegistrationFormValidator(request);
        Boolean isValid = validator.validate();

        if(isValid) {
            Inscription inscription = new Inscription(request.getParameter("email"), new Date());
            request.setAttribute("inscription", inscription);
        } else {
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("errors", validator.getErrors());
        }

        this.getServletContext().getRequestDispatcher( "/registration.jsp" ).forward( request, response );
    }
}

package servlet;

import entity.Inscription;
import validator.RegistrationFormValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( "/registration.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password-repeat");
        boolean approvedTerms = Boolean.parseBoolean(request.getParameter("approved-terms"));

        RegistrationFormValidator validator = new RegistrationFormValidator(approvedTerms, email, password, passwordRepeat);

        if(validator.isValid()) {
            Inscription inscription = validator.getInscription();
            // Persist inscription
            request.setAttribute("inscription", inscription);
            this.getServletContext().getRequestDispatcher( "/registration-success.jsp" ).forward( request, response );
        } else {
            request.setAttribute("email", email);
            request.setAttribute("errors", validator.getErrors());
            this.getServletContext().getRequestDispatcher( "/registration.jsp" ).forward( request, response );
        }
    }
}

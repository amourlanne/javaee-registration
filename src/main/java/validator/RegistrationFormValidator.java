package validator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegistrationFormValidator
 * Created by Alexis on 28/03/2019
 */
public class RegistrationFormValidator extends FormValidator {

    public RegistrationFormValidator(HttpServletRequest request) {
        super(request);
    }

    @Override
    public boolean validate() {

        this.init();

        this.validateEmail();
        this.validatePassword();
        this.validateApprovedTerms();

        return valid;
    }

    private void validateApprovedTerms() {
        boolean approvedTerms = Boolean.parseBoolean(request.getParameter("approved-terms"));
        this.validateInput(approvedTerms, "Terms must be approved");
    }

    private void validateEmail() {

        String email = request.getParameter("email");

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        this.validateInput(matcher.matches(),"Invalid Email" );
    }

    private void validatePassword() {
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password-repeat");
        this.validateInput(password.length() >= 8, "Password must have a minimum of 8 character" );
        this.validateInput(password.equals(passwordRepeat), "Both password mus be equals");
    }
}

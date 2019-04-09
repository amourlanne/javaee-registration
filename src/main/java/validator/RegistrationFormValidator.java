package validator;

import entity.Inscription;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegistrationFormValidator
 * Created by Alexis on 28/03/2019
 */
public class RegistrationFormValidator extends FormValidator {

    private boolean approvedTerms;
    private String email;
    private String password;
    private String passwordRepeat;

    private Inscription inscription;

    public RegistrationFormValidator(boolean approvedTerms,
                                     String email,
                                     String password,
                                     String passwordRepeat ) {
        super();
        this.approvedTerms = approvedTerms;
        this.email = email;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.valid = false;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public boolean isValid() {

        valid = true;

        this.errors.clear();

        if(!approvedTerms) {
            valid = false;
            this.addError("Terms must be approved");
        }

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()) {
            valid = false;
            this.addError("Invalid Email");
        }

        if(password.length() < 8) {
            valid = false;
            this.addError("Password must have a minimum of 8 character");
        }

        if(!password.equals(passwordRepeat)) {
            valid = false;
            this.addError("Both password mus be equals");
        }

        if(valid) this.inscription = new Inscription(email, new Date());

        return valid;
    }
}

package validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Class FormValidator
 * Created by Alexis on 28/03/2019
 */
public abstract class FormValidator {

    protected HttpServletRequest request;
    private List<String> errors;
    protected boolean valid;

    public FormValidator(HttpServletRequest request) {
        this.request = request;
        this.valid = false;
        this.errors = new ArrayList<>();
    }

    public void init() {
        this.errors.clear();
        this.valid = true;
    }

    public abstract boolean validate();

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public void validateInput(boolean valid, String error) {
        if(!valid) {
            this.valid = false;
            this.addError(error);
        }
    }
}

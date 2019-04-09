package validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Class FormValidator
 * Created by Alexis on 28/03/2019
 */
public abstract class FormValidator {

    protected List<String> errors;
    protected boolean valid;

    public FormValidator() {
        this.valid = false;
        this.errors = new ArrayList<>();
    }

    public abstract boolean isValid();

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

}

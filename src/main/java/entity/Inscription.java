package entity;

import java.util.Date;

/**
 * Class Inscription
 * Created by Alexis on 28/03/2019
 */
public class Inscription {
    public String email;
    public Date date;

    public Inscription(String email, Date date) {
        this.email = email;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

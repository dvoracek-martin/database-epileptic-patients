package cz.cvut.fit.genepi.businessLayer.BO.form;

import javax.validation.constraints.Size;
import java.util.Date;

public class NewsMessageFormBO {

    private int id;

    @Size(min = 1, max = 200)
    private String heading;

    /**
     * The message.
     */
    private String message;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

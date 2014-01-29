package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class NewsMessageEntity.
 */
@Entity
@Table(name = "NEWS_MESSAGE")
public class NewsMessageEntity {

    /**
     * The id.
     */
    @Id
    @Column(name = "ID", precision = 6, scale = 0, nullable = false)
    @GeneratedValue
    private int id;

    /**
     * The message.
     */
    @Size(max = 2000)
    @Column(name = "MESSAGE", length = 2000, nullable = false)
    private String message;

    @Column(name = "DATE", nullable = true)
    private Date date;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        /*fomrmat date here*/
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

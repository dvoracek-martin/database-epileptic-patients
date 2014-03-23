package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.*;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class NewsMessageEntity.
 */
@Entity
@Table(name = "NEWS_MESSAGE")
public class NewsMessageEntity implements
        Comparable<NewsMessageEntity> {

    /**
     * The id.
     */
    @Id
    @Column(name = "ID", precision = 6, scale = 0, nullable = false)
    @GeneratedValue
    private int id;

    @Column(name = "heading")
    private String heading;
    /**
     * The message.
     */
    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "DATE", nullable = true)
    private Date date;


    @Override
    public int compareTo(NewsMessageEntity o) {
        int dateComparison = this.date.compareTo(o.getDate());
        int idComparison = this.id - o.getId();
        if (dateComparison > 0) {
            return -1;
        } else if (dateComparison == 0) {
            if (idComparison < 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }


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


    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

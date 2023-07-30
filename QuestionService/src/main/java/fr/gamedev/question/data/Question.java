package fr.gamedev.question.data;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author djer1
 *
 */
@Entity
public class Question extends RepresentationModel<Question> {
    /**id.*/
    @GeneratedValue
    @Id
    private long id;

    /**content.*/
    private String content;
    /** @return the id */
    public long getId() {
        return id;
    }
    /**
     * @param newId the id to set
     */
    public void setId(final long newId) {
        this.id = newId;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param newContent the content to set
     */
    public void setContent(final String newContent) {
        this.content = newContent;
    }
}

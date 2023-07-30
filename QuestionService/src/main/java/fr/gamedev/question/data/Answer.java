package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author djer1
 *
 */
@Entity
public class Answer {

    /**
     * id.
     */
    @GeneratedValue
    @Id
    private long id;

    /** question.*/
    @OneToOne
    private Question question;
    /** correctAnswer.*/
    private Boolean correctAnswer;


    /** @return the id*/
    public long getId() {
        return id;
    }
    /**@param newId the id to set*/
    public void setId(final long newId) {
        this.id = newId;
    }
    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }
    /**
     * @param newQuestion the question to set
     */
    public void setQuestion(final Question newQuestion) {
        this.question = newQuestion;
    }
    /**
     * @return the correctAnswer
     */
    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * @param newCorrectAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(final Boolean newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
    }
}

package fr.gamedev.question.dto;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class UserAnswerDto {

    private long id;

    /** User answering providing answer. */
    private Long userId;
    /** The correct answer (linked to the question). */

    //Many to one
    private long answerId;
    /** Points earn by user for this answer. */
    private Integer points;

    public UserAnswerDto(long id, Long userId, long answerId, Integer points) {
        this.id = id;
        this.userId = userId;
        this.answerId = answerId;
        this.points = points;
    }

    public UserAnswerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}

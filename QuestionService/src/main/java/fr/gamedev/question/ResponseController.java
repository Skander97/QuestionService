package fr.gamedev.question;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.Question;
import fr.gamedev.question.dto.UserAnswerDto;
import fr.gamedev.question.repository.AnswerRepository;
import fr.gamedev.question.repository.QuestionRepository;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author djer1
 */
@RestController
public class ResponseController {
    /**
     * @param questionId
     * @param answer
     * @param userId
     * @return response
     */

    AnswerRepository answerRepository;

    ResponseController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    @GetMapping("/response")
    public String answer(@RequestParam final long questionId, @RequestParam final Boolean booleanAnswer,
                         @RequestParam final long userId) {
        String response;
        Answer answer = answerRepository.findByQuestionId(questionId);
        UserAnswerDto userAnswerDto = getByUserAndAnswer(userId, answer.getId());
        if(userAnswerDto == null){
            return "La question n'est pas disponible pour l'utilisateur";
        }

        if (booleanAnswer == Boolean.TRUE) {
            //Ajouter des points
            userAnswerDto.setPoints(1);
            patchUserAnswer(userAnswerDto.getId(), 1, userId, answer.getId());
            response = "Bravo ! vous avez trouvé ! ";
        } else {
            //Ne pas ajouter de points
            response = "Oops ! Ca n'est pas correcte";
        }
        return response;
    }

    private UserAnswerDto getByUserAndAnswer(long userId, long answerId) {
        String uri = "http://localhost:8081/userAnswer?userId="+userId+"&answerId="+answerId;
        RestTemplate restTemplate = new RestTemplate();

        return  restTemplate.getForObject(uri, UserAnswerDto.class);
    }

    private void patchUserAnswer(Long userAnswerId, int points, Long userId, Long answerId) {
        String uri = "http://localhost:8081/userAnswer/"+userAnswerId+"/points/"+points;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, null, UserAnswerDto.class);
    }
}

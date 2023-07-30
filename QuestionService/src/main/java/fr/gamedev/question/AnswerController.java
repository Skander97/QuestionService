package fr.gamedev.question;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.Question;
import fr.gamedev.question.repository.AnswerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    AnswerRepository answerRepository;

    AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    @GetMapping("/answer/{id}/question")
    public Question getQuestion(@PathVariable final long id) {
        Answer answer = answerRepository.findById(id).get();
        return answer.getQuestion();
    }
}

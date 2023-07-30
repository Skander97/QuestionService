package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Question;

import javax.transaction.Transactional;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "question", path = "question")
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    @Override
    @Transactional
    void delete(Question question);

    @Override
    @Transactional
    void deleteById(Long id);

}

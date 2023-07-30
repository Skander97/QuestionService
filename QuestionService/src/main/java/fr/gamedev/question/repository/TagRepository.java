package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Tag;

import javax.transaction.Transactional;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

    @Override
    @Transactional
    void delete(Tag tag);

    @Override
    @Transactional
    void deleteById(Long id);
}

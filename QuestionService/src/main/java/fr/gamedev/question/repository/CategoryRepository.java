package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Category;

import javax.transaction.Transactional;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    @Override
    @Transactional
    void delete(Category category);

    @Override
    @Transactional
    void deleteById(Long id);
}

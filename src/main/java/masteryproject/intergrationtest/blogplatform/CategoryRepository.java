package masteryproject.intergrationtest.blogplatform;

import org.springframework.data.repository.CrudRepository;

import masteryproject.blogplatform.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);

}
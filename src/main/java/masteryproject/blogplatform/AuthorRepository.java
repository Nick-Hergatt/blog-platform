package masteryproject.blogplatform;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	Category findByName(String name);

}

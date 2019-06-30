package masteryproject.blogplatform;

import org.springframework.data.repository.CrudRepository;


public interface TagRepository  extends CrudRepository<PostTag, Long> {
	PostTag findByName(String name);
}

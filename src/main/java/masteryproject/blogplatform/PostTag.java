package masteryproject.blogplatform;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class PostTag {

	private String name;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "postTags")
	private Collection<Post> post;

	
	public PostTag() {

	}

	public PostTag(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Post> getPosts() {
		return post;
	}

}

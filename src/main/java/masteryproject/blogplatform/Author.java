package masteryproject.blogplatform;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
		
	@OneToMany(mappedBy = "author")
	private List<Post> posts;
	
	private String name;
	
	@Id
	@GeneratedValue
	private Long id;
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	
	}

	protected Author() {

	}

	public Author(String name) {
		this.name = name;
	}
	public Collection<Post> getPosts() {
		return posts;
	}
	
}
package masteryproject.blogplatform;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@OneToMany(mappedBy = "category")
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

	protected Category() {

	}

	public Category(String name) {
		this.name = name;
	}

	public Collection<Post> getPosts() {
		return posts;

	}


}

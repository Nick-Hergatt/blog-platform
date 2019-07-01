package masteryproject.blogplatform;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {


	@Id
	@GeneratedValue
	private long id;

	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Author author;
	
	@ManyToMany
	private List<PostTag> postTags;
	
	LocalTime localDateTime = LocalTime.now();
	private String title;

	@Lob
	private String content;

	public List<PostTag> getPostTags() {
		return postTags;
	}

	
	protected Post() {

	}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.postTags = new ArrayList<>();

	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void addPostTag(PostTag postTag) {
		this.postTags.add(postTag);
	}
	
	public void addCategory(Category category) {
		this.category = category;
	}
	
	public void addAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	
	public void addDateTime() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}

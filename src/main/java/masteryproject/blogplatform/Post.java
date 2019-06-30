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

	@ManyToMany
	private List<PostTag> postTags;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Author author;
	
	LocalTime localDateTime = LocalTime.now();
	private String title;

	@Lob
	private String content;

	public List<PostTag> getPostTags() {
		return postTags;
	}

	@SuppressWarnings("unused")
	private Post() {

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

	public void addTag(PostTag postTag) {
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

}

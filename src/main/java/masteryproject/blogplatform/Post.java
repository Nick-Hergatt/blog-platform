package masteryproject.blogplatform;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private long id;

	@ManyToMany
	private List<Tag> reviewTags;
	
	LocalTime localDateTime = LocalTime.now();
	private String title;

	@Lob
	private String content;

	public List<Tag> getReviewTags() {
		return reviewTags;
	}

	@SuppressWarnings("unused")
	private Post() {

	}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.reviewTags = new ArrayList<>();

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

	public void addReviewTag(Tag reviewTag) {
		this.reviewTags.add(reviewTag);
	}
	
	public void addDateTime() {
		
	}

}

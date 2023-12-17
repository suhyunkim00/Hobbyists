package model;

import java.util.List;

public class Post {
	private String title;
    private String content;
    private String dateTime;
    private User creator;
    private Integer viewCount;   

    public Post() {
        // Default constructor
    }

    public Post(int id, String title, String content, String dateTime, User creator) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
        this.creator = creator;
    }
    
    private int id;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	 public Integer getViewCount() {
	    	return viewCount;
	    }
	 
	 public void setViewCount(Integer viewCount) {
	    	this.viewCount = viewCount;
	    }
 
	 
    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content
                + ", dateTime=" + dateTime + "]";
    }

    
}

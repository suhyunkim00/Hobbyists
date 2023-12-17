package model;

import java.util.List;

public class Class {
	private String title;
	private String photo;
	private String content;
	private String uploader;
	private int view;
	private int id;

	public Class() {
        // Default constructor
    }

    public Class(String loation, String title, String photo, String content, 
    				String  uploader, int view, int id) {
        super();
        this.location = location;
        this.title = title;
        this.photo = photo;
        this.content = content;
        this.uploader = uploader;
        this.view = view;
        this.id = id;
    }    
    
	private String location;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

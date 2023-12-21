package model;

import java.util.List;

public class Class {
	private String location;
	private String title;
	private String photo;
	private String content;
	private String uploader;
	private int view;
	private int id;
	private int cateId;
	private String cateName;
	private int numOfMembers;
	private List<User> memberList;

	public Class() {
        // Default constructor
    }

    public Class(String location, String title, String photo, String content, 
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
    
	public Class(String location, String title, String photo, String content, String uploader, int view, int id,
			int cateId, String cateName, int numOfMembers, List<User> memberList) {
		super();
		this.location = location;
		this.title = title;
		this.photo = photo;
		this.content = content;
		this.uploader = uploader;
		this.view = view;
		this.id = id;
		this.cateId = cateId;
		this.cateName = cateName;
		this.numOfMembers = numOfMembers;
		this.memberList = memberList;
	}

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

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public List<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<User> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "Class [location=" + location + ", title=" + title + ", photo=" + photo + ", content=" + content
				+ ", uploader=" + uploader + ", view=" + view + ", id=" + id + ", cateId=" + cateId + ", cateName="
				+ cateName + ", numOfMembers=" + numOfMembers + ", memberList=" + memberList + "]";
	}

}

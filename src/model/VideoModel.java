package model;


//Is the Blueprint of our mock database
public class VideoModel {
	
//an id as a unique identifier 
private Integer id;

//Title of Netflix vid 
private String title;

//Image of Netflix vid 
private String image;

//Category of Netflix vid
private String category;


//Constructor
public VideoModel(Integer id, String title, String image, String category) {
	//Inheritance --> Refers to the this class' parent which is Object
	super();
	this.id = id;
	this.title = title;
	this.image = image;
	this.category = category;
}


//We have getters to have classes access the private values through then (Tier 3).
//Setters - give the class variables local method values so that Java can distinguish that it is using the variable value from the local value
//in the setter method

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}













}



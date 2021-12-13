//package model;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Formatter;
//
//public class VideosCollection {
//private ArrayList<VideoModel> videos = new ArrayList<VideoModel>();
//private final String PATH = "assets/videos.csv";
//
//
//// A constructor that calls the readArchives method to read our csv
//public VideosCollection() {
//	readArchives();
//}
//
////add a new entry of a video for our mock datatbase 
//public void add (VideoModel video) {
//	getVideos().add(video);
//	updateArchives();
//}
//
////remove a video
//public Boolean delete(VideoModel video) {
//	if(getVideos().contains(video)) {
//	   getVideos().remove(video);
//	   updateArchives();
//	   return true;
//	}
//	return false;
//}
//
////checks everything of the current videos we have
//public ArrayList<VideoModel> analyzeVideos(){
//	return getVideos();
//}
//
//private void readArchives() {
//	String[] data;
//	try(Scanner input = new Scanner(Paths.get(PATH))){
//		//regex expresssion (regular expressions)
//		//\\r is the representation of the special character carriage return, moves the cursor to the beginning of the line.
//		//\\n - line feed, moves the cursor to the next line. 
//		// \r\n indicate the end of a line 
//		input.useDelimiter("\\r\n|\\n\\r");
//		
//		while (input.hasNext()) {
//			data = input.next().split(";");
//			//splits the csv info into 4 data values (id, title, image, category)
//			getVideos().add(new VideoModel(Integer.valueOf(data[0]), data[1], data[2], data[3]));
//		}
//	}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//}
//
////format our csv info for each video nicely
//private void updateArchives() {
//	try(Formatter output = new Formatter(PATH)){
//		for (VideoModel video: getVideos()) {
//			output.format("%d;%s;%s;%s%n", video.getId(),video.getTitle(), video.getImage(),
//				video.getCategory());
//		}
//		
//	} catch(FileNotFoundException e) {
//		e.printStackTrace();
//	}
//}
//	
////gets number of videos
//	public Integer getLastId() {
//		return getVideos().size();
//	}
//	
//	/*GETTERS AND SETTERS*/
//	private ArrayList<VideoModel> getVideos(){
//		return videos;
//	}
//	
//	private void setVideos(ArrayList<VideoModel> videos) {
//		this.videos = videos;
//}
//	/*GETTERS AND SETTERS*/
//
//
//
//
//
//
//}

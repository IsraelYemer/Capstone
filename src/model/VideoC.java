package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideoC implements C<VideoModel>{
	
	private Database db = Database.getInstance();
	
	

	@Override
	public Optional<VideoModel> get(Integer id) {
		VideoModel video = null;
		ResultSet rs = getDb().query("SELECT * FROM video WHERE video.id = " +id+ " LIMIT 1");
		try {
			while(rs.next()) {
				String title = rs.getString(2);
				String image =  rs.getString(3);
				String category =  rs.getString(4);
				video = new VideoModel(id,title,image,category);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Optional.ofNullable(video);
	}

	@Override
	public List<VideoModel> getAll() {
		List <VideoModel> videos = new ArrayList<VideoModel>();
		ResultSet rs = getDb().query("SELECT * FROM video");
//		Integer id = rs.getInt(1);
		try {
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String title = rs.getString(2);
				String image =  rs.getString(3);
				String category =  rs.getString(4);
				VideoModel video = new VideoModel(id,title,image,category);
				videos.add(video);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		return Optional.ofNullable(video);
		return videos;
	}
	
	@Override
	public void save(VideoModel t) {
		ResultSet rs = getDb().query("INSERT INTO public.video (title,image,category) VALUES ("
				+"'"+t.getTitle()+"'::character varying, '"+t.getImage()+"'::character varying,'"+t.getCategory()+"'::character varying)"
				+ "returning id;");

	}

	@Override
	public void update(VideoModel t) {
		ResultSet rs = getDb().query("UPDATE public.video SET category = '"+t.getCategory()+"'::character varying," + "image = '"+t.getImage()+"'::character varying," + "title = '"+t.getTitle()+"'::character varying WHERE id = "+ t.getId()+";");
		
	}

	@Override
	public void delete(VideoModel t) {
		ResultSet rs = getDb().query("DELETE FROM public.video WHERE id IN ("+t.getId()+");");
		
	}
	
	public Integer maxId() {
		Integer id = 1;
		ResultSet rs = getDb().query("SELECT id FROM public.video ORDER BY id DESC LIMIT 1;");
		try {
			if(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	

}

package controller;

import java.awt.event.ActionEvent;

import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.table.DefaultTableModel;


import model.VideoC;
import model.VideoModel;
import view.VideoManagmentView;

public class ControllerVideoManagement implements ActionListener, WindowListener {

	
	private VideoC videos;
	private VideoManagmentView view;
	
	
	public ControllerVideoManagement() {
		videos= new VideoC();
		view = new VideoManagmentView(this);
		view.setVisible(true);
		updateTableModel();
	}
	
	private void updateTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("title");
		tableModel.addColumn("category");
		
		
		for(VideoModel video :getVideos().getAll() ) {
			Vector <String> vector = new Vector<String>();
			vector.add(video.getTitle());
			vector.add(video.getCategory());
			tableModel.addRow(vector);
		}
		getView().getTable().setModel(tableModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getView().getBtnNew())) {
			new ControllerNewVideo();
		}
		if(e.getSource().equals(getView().getBtnPreview())) {
			new ControllerMainView();
		}
	}
	
//	public VideosCollection getVideosCollection() {
//		return videosCollection;
//	}
//	
//	public void setVideosCollection(VideosCollection videosCollections) {
//		this.videosCollection = videosCollections;
//	}
	
	public VideoManagmentView getView() {
		return view;
	}
	
	public void setView(VideoManagmentView view) {
		this.view = view;
	}
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		updateTableModel();
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public VideoC getVideos() {
		return videos;
	}

	public void setVideos(VideoC videos) {
		this.videos = videos;
	}
	
	
}

package controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


import model.VideoC;
import model.VideoModel;
import view.NewVideoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/*NEW VIDEO CONTROLLER*/
public class ControllerNewVideo implements ActionListener, MouseListener {

	private VideoC model;
	private NewVideoView view;
	private File image;
	
	public ControllerNewVideo () {
		this.model = new VideoC();
		this.view = new NewVideoView(this);
		this.view.setVisible(true);
		
	}
/*NEW VIDEO CONTROLLER*/
	
	/*Implementation means that ControllerNewVideo must use all methods from the interface (ActionListener,MouseListener) we are implementing. 
	 * The methods we are forced to use is the actionPerformed (is what happens when a component with an actionListener is triggered.
	 *  An event happens, and its called an ActionEvent). If the source button we press is the "Accept" component in NewVideoView
	 *  set the title,pathImage, and category values to the values below.  */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getView().getBtnAccept())) {
			Integer id = getModel().maxId()+1;
			String title = getView().getTxtName().getText();
			String pathImage = ".\\assets\\img\\video"+ id +".jpg";
			String category = getView().getComboCategory().getSelectedItem().toString();
			
			Path copy = Paths.get(pathImage);
			/* Get the exact image from the absolute pathname we put for pathImage*/
			Path pathOriginal = Paths.get(getImage().getAbsolutePath());
			try {
				/*Make file copy for our program to use*/
				Files.copy(pathOriginal, copy, StandardCopyOption.REPLACE_EXISTING);
	
			} catch(IOException e1) {
				
				e1.printStackTrace();
				
				
			}
			
			/*Add new entry with VideoModel structure*/
			getModel().save(new VideoModel(id,title,pathImage,category));
			
		}
		
		/* When done, NEW VIDEO GUI disappears*/
		getView().dispose();
		
	}

	/*The other methods come from the MouseListener. Names of methods explain the action
	 *  needed to trigger them. We use mousePressed(). Mouse is pressed in NewVideoView "click to find image" component, we trigger the image 
	 *  file selected to be the icon for that entry */
	@Override
	public void mousePressed(MouseEvent e) {
		JFileChooser f = new JFileChooser();
		f.setFileSelectionMode(JFileChooser.FILES_ONLY);
		f.showSaveDialog(getView());
		
		if(f.getSelectedFile() != null) {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(f.getSelectedFile().getPath()).getImage().getScaledInstance(170, 96, 0));
			
			getView().getLblImage().setIcon(imageIcon);
			setImage(f.getSelectedFile());
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*GETTERS AND SETTERS*/
	public VideoC getModel() {
		return model;
	}

	public void setModel( VideoC model) {
		this.model = model;
	}

	public NewVideoView getView() {
		return view;
	}

	public void setView(NewVideoView view) {
		this.view = view;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
	/*GETTERS AND SETTERS*/
	
	
}

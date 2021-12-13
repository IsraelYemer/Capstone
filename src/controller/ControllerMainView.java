package controller;


import model.VideoC;
import view.MainView;



/*MAIN VIEW CONTROLLER*/
public class ControllerMainView {

	private VideoC model;
	private MainView view;
	
	public ControllerMainView() {
		super();
		this.model = new VideoC();
		//Connecting this ControllerMainView to the MainView cause it handles it directly.
		this.view = new MainView(this);
		//Make GUI visible
		this.view.setVisible(true);
	}


/*MAIN VIEW CONTROLLER*/

	/*GETTERS AND SETTERS*/
	public VideoC getModel() {
		return model;
	}

	public void setModel(VideoC model) {
		this.model = model;
	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}
	/*GETTERS AND SETTERS*/
}

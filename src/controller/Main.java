package controller;


import java.awt.EventQueue;



public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControllerVideoManagement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



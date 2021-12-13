package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;


import controller.ControllerNewVideo;


/* New Video View where we see our form to add a new video to our Netflix account */
public class NewVideoView extends JFrame{
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox comboCategory;
	private JButton btnAccept;
	private JButton btnCancel;
	private ControllerNewVideo newVideoController;
	private JLabel lblImage;
	private JPanel panel;


	public NewVideoView(ControllerNewVideo c) {
		setNewVideoController(c);
		setTitle("New Video");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		/*JLabel set with "Name" text*/
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 63, 46, 14);
		contentPane.add(lblNewLabel);

		/*text field to set value of "Name"*/
		txtName = new JTextField();
		txtName.setBounds(120, 57, 170, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);


		/*JLabel set with "New video" text*/
		JLabel lblNewLabel_1 = new JLabel("New video");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 11, 432, 33);
		contentPane.add(lblNewLabel_1);


		/*JLabel set with "Category" text*/
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(23, 109, 66, 14);
		contentPane.add(lblNewLabel_2);

		/*Drop down menu to select category for video*/
		comboCategory = new JComboBox();
		comboCategory.setModel(new DefaultComboBoxModel(new String[] { "TV FOR YOU", "MOVIES FOR YOU", "KEEP WATCHING" }));
		comboCategory.setBounds(120,105,170,22);
		contentPane.add(comboCategory);

		/*Accept button with listener that adds new video to the csv file so it can be viewed in the MainView and is controlled by
		 * NewVideoController*/
		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(getNewVideoController());
		btnAccept.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnAccept.setBounds(58,302,89,23);
		contentPane.add(btnAccept);

		/*Cancel button with listener that cancels entry of new video to the csv file and is controlled by
		 * NewVideoController*/
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(getNewVideoController());
		btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnCancel.setBounds(180, 302, 89, 23);
		contentPane.add(btnCancel);

		
		/* Design border around area we click to open up file explorer to select an image for our video*/
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,new Color(255,255,255),new Color(160,160,160)),"Image",
				TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0,0,0)));
		panel.setBounds(78, 144, 182, 118);
		contentPane.add(panel);
		panel.setLayout(null);

		/*Label "click to find image" that has a listener to open file explorer so we can select image file from a selected path
		 * and is controlled by NewVideoController */
		lblImage = new JLabel("click to find image");
		lblImage.addMouseListener(this.getNewVideoController());
		lblImage.setBounds(7, 14, 170, 96);
		panel.add(lblImage);
		lblImage.setForeground(Color.BLACK);
		lblImage.setBackground(Color.WHITE);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		/*Flexible layout*/
		setLocationRelativeTo(null);

	}

	
	/*GETTERS AND SETTERS*/
	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JComboBox getComboCategory() {
		return comboCategory;
	}

	public void setComboCategory(JComboBox comboCategory) {
		this.comboCategory = comboCategory;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public ControllerNewVideo getNewVideoController() {
		return newVideoController;
	}

	public void setNewVideoController(ControllerNewVideo newVideoController) {
		this.newVideoController = newVideoController;
	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

//	public JPanel getPanel() {
//		return panel;
//	}
//
//	public void setPanel(JPanel panel) {
//		this.panel = panel;
//	}
	/*GETTERS AND SETTERS*/
}
package view;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerVideoManagement;

public class VideoManagmentView extends JFrame{




	/* Video Managment View where we see our form to add a new video to our Netflix account */
	private JPanel contentPane;
	private JTextField textField;
	private ControllerVideoManagement videoManagementController;
	private JButton btnNew;
	private JScrollPane scrollPane;
	private JButton btnPreview;
	private JTable table;



	public VideoManagmentView(ControllerVideoManagement c){
		setVideoManagementController(c);
		addWindowListener(this.getVideoManagementController());
		setTitle("Managment of Videos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,569,512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setBounds(21,11,46,14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(88,8,273,20);
		contentPane.add(textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21,48,498,380);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"Title",
						"Category",
						"Url"
				}
		));
		scrollPane.setViewportView(table);

		btnNew = new JButton("New");
		btnNew.addActionListener(getVideoManagementController());
		btnNew.setBounds(442,7,77,23);
		contentPane.add(btnNew);

		btnPreview = new JButton("Preview");
		btnPreview.addActionListener(getVideoManagementController());
		btnPreview.setBounds(430,439,89,23);
		contentPane.add(btnPreview);
		setLocationRelativeTo(null);


	}
	public ControllerVideoManagement getVideoManagementController() {
		return videoManagementController;
	}

	public void setVideoManagementController(ControllerVideoManagement videoManagementController) {
		this.videoManagementController = videoManagementController;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnPreview() {
		return btnPreview;
	}

	public void setBtnPreview(JButton btnPreview) {
		this.btnPreview = btnPreview;
	}


}
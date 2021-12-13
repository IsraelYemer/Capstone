package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ControllerMainView;
import model.VideoModel;

public class MainView extends JFrame {
    private JPanel contentPane;
    private ArrayList<JLabel> videos = new ArrayList<JLabel>();
    private ControllerMainView mainController;

    /* MainView where we see our preview of our Netflix account */
    public MainView(ControllerMainView c) {
        setMainController(c);
        setForeground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1929, 1080);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(9, 9, 9));
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*JLabel set with image logo.png from specified path*/
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(".\\assets\\img\\vistaprincipal\\Hulu.png"));
        lblNewLabel.setBounds(30, 11, 71, 25);
        contentPane.add(lblNewLabel);

        /*JLabel set with "Home" text*/
        JLabel lblNewLabel_1 = new JLabel("Home");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(160, 50, 71, 25);
        contentPane.add(lblNewLabel_1);

        /*JLabel set with "TV" text*/
        JLabel lblNewLabel_2 = new JLabel("TV");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(227, 50, 71, 25);
        contentPane.add(lblNewLabel_2);

        /*JLabel set with "Movies" text to represent the category*/
        JLabel lblNewLabel_2_1 = new JLabel("Movies");
        lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setBounds(292, 50, 71, 25);
        contentPane.add(lblNewLabel_2_1);

        /*JLabel set with "Holidays" text*/
        JLabel lblNewLabel_2_2 = new JLabel("Holidays");
        lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setBounds(362, 52, 108, 20);
        contentPane.add(lblNewLabel_2_2);

        /*JLabel set with "My Stuff" text*/
        JLabel lblNewLabel_2_3 = new JLabel("My Stuff");
        lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_3.setForeground(Color.WHITE);
        lblNewLabel_2_3.setBounds(478, 50, 71, 25);
        contentPane.add(lblNewLabel_2_3);

        /*JLabel set with "Settings" text*/
        JLabel lblNewLabel_2_4 = new JLabel("Settings");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setBounds(578, 50, 71, 25);
		contentPane.add(lblNewLabel_2_4);


        JComboBox comboBoxSettings = new JComboBox(new String[]{" EN ", " ES ", " Light Mode "});
//		JComboBox comboBoxSettings = new JComboBox(new String[]{"Settings", "Language", "Mode"});
//		comboBoxSettings.addActionListener((ActionListener) this);


		comboBoxSettings.setPreferredSize(new Dimension(100, 30));
        comboBoxSettings.setSize(100, 50);
        comboBoxSettings.setLocation(0, 1);
        comboBoxSettings.setForeground(Color.BLACK);
        comboBoxSettings.setBounds(678, 50, 90, 25);






        contentPane.add(comboBoxSettings);

        /*RIGHT SKEWED IMAGES*/
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(".\\assets\\img\\vistaprincipal\\menu.PNG"));
        lblNewLabel_3.setBounds(1670, 44, 134, 28);
        contentPane.add(lblNewLabel_3);


        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(".\\assets\\img\\vistaprincipal\\user.PNG"));
        lblNewLabel_4.setBounds(1817, 33, 55, 48);
        contentPane.add(lblNewLabel_4);
        /*RIGHT SKEWED IMAGES*/


        /*JLabel set with "TV for You" text to represent the category*/
        JLabel lblNewLabel_5 = new JLabel("TV FOR YOU");
        lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 25));
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setBounds(30, 110, 268, 42);
        contentPane.add(lblNewLabel_5);

        /*JLabel set with "Movies for You" text to represent the category*/
        JLabel lblNewLabel_5_1 = new JLabel("MOVIES FOR YOU");
        lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 25));
        lblNewLabel_5_1.setForeground(Color.WHITE);
        lblNewLabel_5_1.setBounds(30, 360, 268, 42);
        contentPane.add(lblNewLabel_5_1);

        /*JLabel set with "Keep Watching" text to represent the category*/
        JLabel lblNewLabel_5_2 = new JLabel("KEEP WATCHING");
        lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 25));
        lblNewLabel_5_2.setForeground(Color.WHITE);
        lblNewLabel_5_2.setBounds(30, 610, 268, 42);
        contentPane.add(lblNewLabel_5_2);

        updateVideos();

    }

    private void updateVideos() {
        ArrayList<VideoModel> videos = (ArrayList<VideoModel>) getMainController().getModel().getAll();
        Integer xTvForYou = 30;
        Integer xMoviesForYou = 30;
        Integer xKeepWatching = 30;

        // for loop to generate each Label at its specific bounds and width depending on the case
        for (VideoModel video : videos) {
            JLabel lbl = new JLabel("");
            //update videos images because we added a new entry
            lbl.setIcon(new ImageIcon(video.getImage()));

            switch (video.getCategory()) {
                case "TV FOR YOU":
                    lbl.setBounds(xTvForYou, 160, 341, 192);
                    xTvForYou = xTvForYou + 345;
                    break;
                case "MOVIES FOR YOU":
                    lbl.setBounds(xMoviesForYou, 410, 341, 192);
                    xTvForYou = xTvForYou + 345;
                    break;
                case "KEEP WATCHING":
                    lbl.setBounds(xKeepWatching, 660, 341, 192);
                    xTvForYou = xTvForYou + 345;
                    break;
            }
            contentPane.add(lbl);
        }

    }


    /*GETTERS AND SETTERS*/
    public ControllerMainView getMainController() {
        return mainController;
    }

    public void setMainController(ControllerMainView mainController) {
        this.mainController = mainController;
    }

    public ArrayList<JLabel> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<JLabel> videos) {
        this.videos = videos;
    }
    /*GETTERS AND SETTERS*/


}

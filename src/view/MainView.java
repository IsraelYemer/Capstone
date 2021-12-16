package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ControllerMainView;
import controller.Main;
import model.VideoModel;
import java.net.URL;

public class MainView extends JFrame {
    private JPanel contentPane;
    private ArrayList<JLabel> videos = new ArrayList<JLabel>();
    private ControllerMainView mainController;
    Color darkBG = new Color(9, 9, 9);
    Color lightBG = new Color(255, 255, 255);


    /* MainView where we see our preview of our Netflix account */
    public MainView(ControllerMainView c) {
        setMainController(c);
        setForeground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1929, 1080);
        contentPane = new JPanel();
        contentPane.setBackground(darkBG);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /*JLabel set with image logo.png from specified path*/
        JLabel lblNewLabel = new JLabel("");
        //lblNewLabel.setIcon(new ImageIcon(".\\assets\\img\\vistaprincipal\\Hulu.jpg"));

        lblNewLabel.setIcon(new ImageIcon("./assets/img/vistaprincipal/hululogo2.png"));
        lblNewLabel.setBounds(30, 30, 100, 50);
        contentPane.add(lblNewLabel);

        /*JLabel set with "Home" text*/
        JLabel lblNewLabel_1 = new JLabel("Home");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_1.setForeground(lightBG);
        lblNewLabel_1.setBounds(160, 50, 71, 25);
        contentPane.add(lblNewLabel_1);

        /*JLabel set with "TV" text*/
        JLabel lblNewLabel_2 = new JLabel("TV");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2.setForeground(lightBG);
        lblNewLabel_2.setBounds(227, 50, 71, 25);
        contentPane.add(lblNewLabel_2);

        /*JLabel set with "Movies" text to represent the category*/
        JLabel lblNewLabel_2_1 = new JLabel("Movies");
        lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_1.setForeground(lightBG);
        lblNewLabel_2_1.setBounds(292, 50, 115, 25);
        contentPane.add(lblNewLabel_2_1);

        /*JLabel set with "Holidays" text*/
        JLabel lblNewLabel_2_2 = new JLabel("Holidays");
        lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_2.setForeground(lightBG);
        lblNewLabel_2_2.setBounds(362, 52, 115, 20);
        contentPane.add(lblNewLabel_2_2);

        /*JLabel set with "My Stuff" text*/
        JLabel lblNewLabel_2_3 = new JLabel("My Stuff");
        lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_3.setForeground(lightBG);
        lblNewLabel_2_3.setBounds(478, 50, 115, 25);
        contentPane.add(lblNewLabel_2_3);

        /*JMenuBar set with "Settings" text*/
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(115, 50);
        menuBar.setLocation(0, 1);
        menuBar.setBounds(578, 50, 79, 25);
        // create a menu
        JMenu menu = new JMenu("Settings");
        menu.setFont(new Font("Arial", Font.PLAIN, 17));

        JMenu language = new JMenu("Language");
        JMenu mode = new JMenu("Mode");

        JMenuItem langEN = new JMenuItem("EN");

        JMenuItem langES = new JMenuItem("ES");
        JMenuItem darkMode = new JMenuItem("Dark Mode");
        JMenuItem lightMode = new JMenuItem("Light Mode");


        language.add(langES);
        mode.add(lightMode);
        menu.add(language);
        menu.add(mode);
        menuBar.add(menu);
        contentPane.add(menuBar);

        JLabel lblNewLabel_2_4 = new JLabel("IY");
        lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNewLabel_2_4.setForeground(Color.WHITE);
        lblNewLabel_2_4.setBounds(1600, 50, 71, 25);
        contentPane.add(lblNewLabel_2_4);

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

        /* light mode setter */
        lightMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contentPane.setBackground(lightBG);

                mode.add(darkMode);
                mode.remove(lightMode);
                lblNewLabel_1.setForeground(darkBG);
                lblNewLabel_2.setForeground(darkBG);
                lblNewLabel_2_1.setForeground(darkBG);
                lblNewLabel_2_2.setForeground(darkBG);
                lblNewLabel_2_3.setForeground(darkBG);
                lblNewLabel_2_4.setForeground(darkBG);
                lblNewLabel_5.setForeground(darkBG);
                lblNewLabel_5_1.setForeground(darkBG);
                lblNewLabel_5_2.setForeground(darkBG);
            }
        });

        /* dark mode setter */
        darkMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contentPane.setBackground(darkBG);

                mode.add(lightMode);
                mode.remove(darkMode);
                lblNewLabel_1.setForeground(lightBG);
                lblNewLabel_2.setForeground(lightBG);
                lblNewLabel_2_1.setForeground(lightBG);
                lblNewLabel_2_2.setForeground(lightBG);
                lblNewLabel_2_3.setForeground(lightBG);
                lblNewLabel_2_4.setForeground(lightBG);
                menuBar.setBackground(lightBG);
                lblNewLabel_5.setForeground(lightBG);
                lblNewLabel_5_1.setForeground(lightBG);
                lblNewLabel_5_2.setForeground(lightBG);
            }
        });

        // add ActionListener to menuItems
        langEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                language.add(langES);
                language.remove(langEN);
                lblNewLabel_1.setText("Home");
                lblNewLabel_2.setText("TV");
                lblNewLabel_2_1.setText("Movies");
                lblNewLabel_2_2.setText("Holidays");
                lblNewLabel_2_3.setText("My Stuff");
                menu.setText("Settings");
                language.setText("Language");
                mode.setText("Mode");
                darkMode.setText("Dark Mode");
                lightMode.setText("Light Mode");
                lblNewLabel_5.setText("TV FOR YOU");
                lblNewLabel_5_1.setText("MOVIES FOR YOU");
                lblNewLabel_5_2.setText("KEEP WATCHING");
            }
        });
        langES.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                language.add(langEN);
                language.remove(langES);
                lblNewLabel_1.setText("Casa");
                lblNewLabel_2.setText("TV");
                lblNewLabel_2_1.setText("Películas");
                lblNewLabel_2_2.setText("Días festivos");
                lblNewLabel_2_3.setText("Mis cosas");
                menu.setText("Ajustes");
                language.setText("Idioma");
                mode.setText("Modo");
                darkMode.setText("Oscura Mode");
                lightMode.setText("Ligera Mode");
                lblNewLabel_5.setText("TV PARA TI");
                lblNewLabel_5_1.setText("PELICULAS PARA TI");
                lblNewLabel_5_2.setText("SIGUE MIRANDO");
            }
        });

    }

    private void updateVideos() {
        ArrayList<VideoModel> videos = (ArrayList<VideoModel>) getMainController().getModel().getAll();
        Integer xTvForYou = 30;
        Integer xMoviesForYou = 30;
        Integer xKeepWatching = 30;

        // for loop to generate each Label at its specific bounds and width depending on the case
        for (VideoModel video : videos) {
            JButton button = new JButton();

            //update videos images because we added a new entry
            button.setIcon(new ImageIcon(video.getImage()));

            switch (video.getCategory()) {
                case "TV FOR YOU":
                    button.setBounds(xTvForYou, 160, 341, 192);
                    xTvForYou = xTvForYou + 345;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                // for (VideoModel video : videos) {
                                Desktop.getDesktop().browse(new URL(video.getUrl()).toURI());
                                // }
                            } catch (IOException | URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    break;
                case "MOVIES FOR YOU":
                    button.setBounds(xMoviesForYou, 410, 341, 192);
                    xMoviesForYou = xMoviesForYou + 345;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                // for (VideoModel video : videos) {
                                Desktop.getDesktop().browse(new URL(video.getUrl()).toURI());
                                // }
                            } catch (IOException | URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    break;
                case "KEEP WATCHING":
                    button.setBounds(xKeepWatching, 660, 341, 192);
                    xKeepWatching = xKeepWatching + 345;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                // for (VideoModel video : videos) {
                                Desktop.getDesktop().browse(new URL(video.getUrl()).toURI());
                                // }
                            } catch (IOException | URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    break;
            }

            contentPane.add(button);
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

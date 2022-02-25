package j2eelearn.j2eelearn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import j2eelearn.contents.EastPanel;
import j2eelearn.contents.EntetePane;
import j2eelearn.contents.WestPanel;

public class J2eeLearn extends JFrame {
    private EntetePane northPane;
    private WestPanel westPane;
    private EastPanel eastPane;

	public J2eeLearn () {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screen.width/2, screen.width/2);
        this.setTitle("J2eeLearn");
        this.setLocation(screen.width, 0);
        
        //déclaration des trois blocs
        eastPane = new EastPanel();
        westPane = new WestPanel(eastPane);
        northPane = new EntetePane(eastPane,westPane);
        
       

        this.getContentPane().add(northPane.getPane(),BorderLayout.NORTH);
        this.getContentPane().add(westPane.getPane(),BorderLayout.WEST);
        this.getContentPane().add(eastPane.getPane(),BorderLayout.CENTER);
        this.setVisible(true);
	}
}

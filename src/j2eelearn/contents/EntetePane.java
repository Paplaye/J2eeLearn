package j2eelearn.contents;

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

import j2eelearn.j2eelearn.J2eeLearn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;


public class EntetePane {
    private JPanel entete;
    private EastPanel eastPane;
    private WestPanel westPane;

    public EntetePane (EastPanel eastPane,WestPanel westPane) {
        this.eastPane = eastPane;
        this.westPane = westPane;
        this.entete = new JPanel(new GridLayout(2,1));
        this.entete.add(logoBar());
		this.entete.add(menu());
    }
    public JPanel getPane () {
        return entete;
    }
    //Cette fonction renvoie un jpanel qui contient un jlabel positionner à gauche
    public JPanel logoBar () {
		JPanel north = new JPanel(new FlowLayout (FlowLayout.LEFT));
		JLabel logo = new JLabel ("J2eeLearn");
		logo.setFont(new Font("Serif",Font.BOLD|Font.PLAIN,25));
		logo.setForeground(Color.WHITE);
		north.setBackground(new Color (0x228be6));
		north.add(logo);
		return north;
	}
    //cette fonction renvoie un jpanel qui fait office de menu dont les éléments sont placés à gauche
    //En meme temps une gestion des évènements provoqués par un clique sur un composant
	public JPanel menu () {
        JPanel west = new JPanel (new FlowLayout (FlowLayout.LEFT));
        west.setBorder(BorderFactory.createLineBorder(new Color(0xB0AFAE)));
        
        JLabel home = new JLabel();
		ImageIcon imH = new ImageIcon(J2eeLearn.class.getResource("/icons/home.png"));
		home.setIcon(new ImageIcon (imH.getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH)));
        west.add (home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Home");
                westPane.eraseBackground();
            }
        });
        
        JLabel glossaire = new JLabel();
        ImageIcon imG = new ImageIcon(J2eeLearn.class.getResource("/icons/glossaire.png"));
        glossaire.setIcon(new ImageIcon (imG.getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH)));
        west.add(glossaire);
        glossaire.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Glossaire");
                westPane.eraseBackground();
            }
        });

        JLabel faq = new JLabel();
        ImageIcon imgF = new ImageIcon(J2eeLearn.class.getResource("/icons/faq.jpg"));
        faq.setIcon(new ImageIcon (imgF.getImage().getScaledInstance(35, 45, Image.SCALE_SMOOTH)));
        west.add(faq);
        faq.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Faq");
                westPane.eraseBackground();
            }
        });

        JLabel help = new JLabel();
        ImageIcon imgHe = new ImageIcon(J2eeLearn.class.getResource("/icons/help.png"));
        help.setIcon(new ImageIcon (imgHe.getImage().getScaledInstance(30, 40, Image.SCALE_SMOOTH)));
        west.add(help);
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Help");
                westPane.eraseBackground();
            }
        });
        
		west.setBackground(Color.WHITE);
		return west;
	}
}

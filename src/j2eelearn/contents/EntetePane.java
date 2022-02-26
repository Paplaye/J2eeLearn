package j2eelearn.contents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import j2eelearn.utils.Utils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;

/***
 * Cette classe :
    - compose un JPanel entete qui represente l'entete de notre plugin
    - agrège WestPanel et EastPanel
 */
public class EntetePane {
    private JPanel entete;
    private EastPanel eastPane;
    private WestPanel westPane;

    public EntetePane (EastPanel eastPane,WestPanel westPane) {
        this.eastPane = eastPane;
        this.westPane = westPane;
        this.entete   = new JPanel(new GridLayout(2,1));
        this.entete.add(logoBar());
		this.entete.add(menu());
    }
    // getter qui renvoie le JPanel entete
    public JPanel getPane () {
        return this.entete;
    }

    /*Cette fonction :
        - ne prend rien en argument
        - elle renvoie un JPanel qui contient la barrière en bleu de l'entete qui fait office de loggo
    */
    public JPanel logoBar () {
		JPanel north = new JPanel(Utils.getInstance().fleft);
		JLabel logo = new JLabel ("J2eeLearn");
		logo.setFont(new Font("Serif",Font.BOLD|Font.PLAIN,25));
		logo.setForeground(Color.WHITE);
		north.setBackground(new Color (0x228be6));
		north.add(logo);
		return north;
	}
    /*Cette fonction :
        - ne prend aucun argument
        - elle retourne un JPanel qui contient des composants cliquable qui est la deuxième bannière de l'entete
    */
	public JPanel menu () {
        JPanel west = new JPanel (Utils.getInstance().fleft);//un JPanel dont les éléments sont à gauche
        west.setBorder(Utils.getInstance().lineborder);//une bordure à ce composant
        
        //la page d'accueil
        JLabel home = new JLabel();
		home.setIcon(Utils.getInstance().getImageIcon(30,40, "home.png"));
        west.add (home);
        //un clic sur cet élément déclenche un un évenement qui change le contenu du Panel EST
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Home");//modification de eastPane
                Utils.getInstance().eraseBackground(westPane.getLabels());
            }
        });
        //le glossaire
        JLabel glossaire = new JLabel();
        glossaire.setIcon(Utils.getInstance().getImageIcon(30,40, "glossaire.png"));
        west.add(glossaire);
        //un clic sur cet élément déclenche un un évenement qui change le contenu du Panel EST
        glossaire.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Glossaire");//modification de eastPane
                Utils.getInstance().eraseBackground(westPane.getLabels());
            }
        });
        //la Faq
        JLabel faq = new JLabel();
        faq.setIcon(Utils.getInstance().getImageIcon(35,45, "faq.jpg"));
        west.add(faq);
        //un clic sur cet élément déclenche un un évenement qui change le contenu du Panel EST
        faq.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Faq");//modification de eastPane
                Utils.getInstance().eraseBackground(westPane.getLabels());
            }
        });
        //Le help
        JLabel help = new JLabel();
        help.setIcon(Utils.getInstance().getImageIcon(30,40, "help.png"));
        west.add(help);
        //un clic sur cet élément déclenche un un évenement qui change le contenu du Panel EST
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eastPane.setPane("Help");//modification de eastPane
                Utils.getInstance().eraseBackground(westPane.getLabels());
            }
        });
		west.setBackground(Color.WHITE);
		return west;
	}
}

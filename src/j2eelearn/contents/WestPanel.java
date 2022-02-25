package j2eelearn.contents;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import j2eelearn.j2eelearn.J2eeLearn;

import javax.swing.SwingConstants; 
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WestPanel {
    private JPanel pane;
    private EastPanel eastPane;
    private int c = 0;
    private JLabel [] labels;

    public WestPanel (EastPanel eastPane) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.eastPane = eastPane;
        this.pane = new JPanel();
        this.pane.setBorder(new EmptyBorder(25,1,1,1));
        this.pane.setPreferredSize(new Dimension ((int)screen.getHeight()/5,(int)screen.getHeight()));
        this.pane.add(menuLeft(this.pane.getPreferredSize()));
	    this.pane.setBackground(new Color(0xB0AFAE));
    }
    public JPanel getPane () {
        return this.pane;
    }
    
    //crée un tableau de label des titres des chapitres
    private JLabel [] createChapitre () {
        JLabel [] chapitres = {
            new JLabel("Chapitre 1"),new JLabel("Chapitre 2"),new JLabel("Chapitre 3"),
            new JLabel("Chapitre 4"),new JLabel("Chapitre 5"),new JLabel("Chapitre 6"),
            new JLabel("Chapitre 7")
        };
        Border lineborder = BorderFactory.createLineBorder(new Color(0xB0AFAE));
        ImageIcon imH = new ImageIcon(J2eeLearn.class.getResource("/icons/course.png"));
        int i = 0;
        for (i = 0;i < chapitres.length; i ++ ) {
            chapitres[i].setBorder(lineborder);
            chapitres[i].setHorizontalAlignment(SwingConstants.LEFT);
            chapitres[i].setIcon(new ImageIcon (imH.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            chapitres[i].setIconTextGap(10);
            chapitres[i].setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            chapitres[i].setOpaque(true);
        }
        return chapitres;
    }
    //Cette fonction efface le background de tous les Labels excepté celui à l'indice k (celui selectionné)
    public void eraseBackground () {    
       for (int i = 0;  i < this.labels.length; i ++) {
            this. labels[i].setBackground(null);
            this.labels[i].setForeground(Color.BLACK);
        }
    }
    //cette fonction renvoie un JPanel des chapitres dont le click sur un chapitre renvoie sur le
    //chapitre correspondant
    public JPanel menuLeft (Dimension dim) {
        JPanel left = new JPanel(new GridLayout(7,1));
        Border lineborder = BorderFactory.createLineBorder(new Color(0xB0AFAE));
        left.setPreferredSize(new Dimension ((int)dim.getWidth()-15,(int)dim.getHeight()/3));
        labels = createChapitre();
        labels[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[0].setBackground(new Color (0x228be6));
                labels[0].setForeground(Color.WHITE);
                eastPane.setPane(labels[0].getText());
                
            }
        });
        labels[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[1].setBackground(new Color (0x228be6));
                labels[1].setForeground(Color.WHITE);
                eastPane.setPane(labels[1].getText());
                
            }
        });
        labels[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[2].setBackground(new Color (0x228be6));
                labels[2].setForeground(Color.WHITE);
                eastPane.setPane(labels[2].getText());
                
            }
        });
        labels[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[3].setBackground(new Color (0x228be6));
                labels[3].setForeground(Color.WHITE);
                eastPane.setPane(labels[3].getText());
            }
        });
        labels[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[4].setBackground(new Color (0x228be6));
                labels[4].setForeground(Color.WHITE);
                eastPane.setPane(labels[4].getText());
            }
        });

        labels[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[5].setBackground(new Color (0x228be6));
                labels[5].setForeground(Color.WHITE);
                eastPane.setPane(labels[5].getText());
            }
        });
        labels[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eraseBackground ();
                labels[6].setBackground(new Color (0x228be6));
                labels[6].setForeground(Color.WHITE);
                eastPane.setPane(labels[6].getText());
            }
        });

        for (int i = 0; i < labels.length;i ++)
            left.add(labels[i]);
        left.setBackground(Color.WHITE);
        return left;
    }

    public JLabel [] getLabels () {
        return this.labels;
    }
}

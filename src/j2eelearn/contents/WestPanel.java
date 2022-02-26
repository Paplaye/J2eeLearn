package j2eelearn.contents;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import j2eelearn.utils.Utils;

import javax.swing.SwingConstants; 
import java.awt.Color;
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

/**
 * Cette classe :
 * - agrège EastPanel
 * - compose un JPanel qui correspondant au bloc qui apparait à gauche et qui contient les différents chapitres ou
 *  modules
 * - Le JPanel pane contient des éléments qui déclent des évenements suite à un clic qui provoque une modification 
 *  de EastPanel
 */
public class WestPanel {
    private JPanel pane;
    private EastPanel eastPane;
    private JLabel [] labels;

    //constructeur 
    public WestPanel (EastPanel eastPane) {
        Dimension sc = Utils.getInstance().screen;
        this.eastPane = eastPane;
        this.pane = new JPanel();
        this.pane.setBorder(new EmptyBorder(25,1,1,1));
        this.pane.setPreferredSize(new Dimension ((int)sc.getHeight()/5,(int)sc.getHeight()));
        this.pane.add(menuLeft(this.pane.getPreferredSize()));
	    this.pane.setBackground(new Color(0xB0AFAE));
    }
    /**
     * retourne pane
     */
    public JPanel getPane () {
        return this.pane;
    }
    
    /**
     * 
     * @param dim
     * @return un JPanel contenant les chapitres ou modules sur les quels un clic déclence un évenèment
     */
    public JPanel menuLeft (Dimension dim) {
        JPanel left = new JPanel(new GridLayout(Utils.getInstance().size(),1));//le JPanel de plusieurs lignes et 1 colonne

        left.setPreferredSize(new Dimension ((int)dim.getWidth()-15,(int)dim.getHeight()/3));
        labels = Utils.getInstance().createChapitre();//les titres des chapitres ou modules
        //un clic sur ce label provoque la modification de eastPane
        labels[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[0].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[0].setForeground(Color.WHITE);
                eastPane.setPane(labels[0].getText());
                
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[1].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[1].setForeground(Color.WHITE);
                eastPane.setPane(labels[1].getText());//modification de eastPane
                
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[2].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[2].setForeground(Color.WHITE);
                eastPane.setPane(labels[2].getText());//modification de eastPane
                
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[3].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[3].setForeground(Color.WHITE);
                eastPane.setPane(labels[3].getText());//modification de eastPane
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[4].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[4].setForeground(Color.WHITE);
                eastPane.setPane(labels[4].getText());//modification de eastPane
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[5].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[5].setForeground(Color.WHITE);
                eastPane.setPane(labels[5].getText());//modification de eastPane
            }
        });
        //un clic sur ce label provoque la modification de eastPane
        labels[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utils.getInstance().eraseBackground(labels);//on efface la couleur de fond de tous les composants du panel left
                labels[6].setBackground(new Color (0x228be6));//on colorie en bleu l'élement concerné
                labels[6].setForeground(Color.WHITE);
                eastPane.setPane(labels[6].getText());//modification de eastPane
            }
        });

        for (int i = 0; i < labels.length;i ++)
            left.add(labels[i]);
        left.setBackground(Color.WHITE);
        return left;
    }
    //Renvoie le tableau de labels des chapitres
    public JLabel [] getLabels () {
        return this.labels;
    }
}

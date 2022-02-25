package j2eelearn.contents;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import j2eelearn.modules.Chapitre1;
import j2eelearn.modules.Utils;

import java.awt.*;
import java.awt.event.*;

public  class BodyPane {
    private JPanel pane;
    private JPanel south;
    private JPanel north;
    private JLabel tit;

    public BodyPane (String titre,String [] content,int etat) {
        this.pane = new JPanel(new BorderLayout(10, 10));
        this.pane.setBorder(new EmptyBorder(25,15,15,15));
        this.north = new JPanel (new GridLayout (2,1));
        south = new JPanel();

        if (titre.compareTo("Home") == 0) { 
            createNorth("Bienvenue Chez J2eeLearn",content,etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        } else {
            createNorth(titre,content,etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        }
        
        tit = new JLabel();
        
        createSouth(titre);
        this.pane.add(south);
    }
    private JPanel ChapsPane (String chap,String []content,int etat) {
        JPanel lessons = new JPanel(new GridLayout(1,2));
        lessons.add(eventLessons(chap));
		lessons.add(eventsTps(chap));
        return lessons;
    }
    
    private void createNorth (String titre,String [] content,int etat) {
        JPanel titrePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.north.setBorder(BorderFactory.createLineBorder(new Color(0xB0AFAE)));
		
        JPanel lessonsPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel tpsPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel lessons = new JPanel();

        if (etat != 0) {
            lessons = ChapsPane(titre,content,etat);
        }  else {
            tit = new JLabel(titre);
        }

        tit.setFont(new Font("Serif", Font.PLAIN, 30));
		titrePane.add(tit);

        this.north.add(titrePane);
		this.north.add(lessons);
    }

    private void createSouth (String action) {
		this.south.setBorder(BorderFactory.createLineBorder(new Color(0xB0AFAE)));
        this.south.add(creatConteHome(),BorderLayout.NORTH);
        switch (action) {
            case "Home":
                this.south.removeAll();
                this.south.add(creatConteHome(),BorderLayout.NORTH);
            break;
            case "Faq":
                this.south.removeAll();
                //TDO: faire le nécessaire pour la FAQ
            break;
            case "Glossaire":
                this.south.removeAll();
                //TDO: faire le nécessaire pour le glossaire
            break;
            case "Help":
                this.south.removeAll();
                //TDO: faire le nécessaire pour le help
            break;
            default:
                this.south.removeAll();
                this.south.add(createChapIntro(action),BorderLayout.NORTH);
            break;
            
        }
        south.revalidate();
        south.repaint();
    }


    public JPanel creatConteHome () {
        JPanel home = new JPanel(new FlowLayout (FlowLayout.LEFT));
        String mgs = new Utils ().home;
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }

    public JPanel createChapIntro (String chap) {
        JPanel home = new JPanel(new FlowLayout (FlowLayout.LEFT));
        String mgs = new String ("");
            
        switch (chap) {
            case "Chapitre 1":
                
                mgs = new Utils().chap1_intro;
            break;
            case "Chapitre 2":
                mgs = new Utils().chap2_intro;
            break;
            case "Chapitre 3":
                mgs = new Utils().chap3_intro;
            break;
            case "Chapitre 4":
                mgs = new Utils().chap4_intro;
            break;
            case "Chapitre 5":
                //TDO: à remplacer par les bonnes info
                mgs = new Utils().chap5_intro;
            break;
            case "Chapitre 6":
                //TDO: à remplacer par les bonnes info
                mgs = new Utils().chap6_intro;
            break;
            case "Chapitre 7":
                //TDO: à remplacer par les bonnes info
                mgs = new Utils().chap7_intro;
            break;
            default:
                mgs = new Utils().home;
            break;
        }
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }

    private JPanel eventLessons (String chap) {
        JPanel lessonsPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.tit = new JLabel(chap);

        switch (chap) {
            case "Chapitre 1":
                Chapitre1 c1 = new Chapitre1(chap, north, south);
                lessonsPane = c1.getLessonsPane();
                this.north =  c1.getNorth();
                this.south = c1.getSouth();
            break;
            case "Chapitre 2":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
            case "Chapitre 3":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
            case "Chapitre 4":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
            case "Chapitre 5":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
            case "Chapitre 6":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
            case "Chapitre 7":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 1
            break;
        }
        return lessonsPane;
    }
    private JPanel eventsTps (String chap) {
        JPanel tpsPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        switch (chap) {
            case "Chapitre 1":
                Chapitre1 c1 = new Chapitre1(chap, north, south);
                tpsPane = c1.getTpsPane();
                this.north =  c1.getNorth();
                this.south = c1.getSouth();
            break;
            case "Chapitre 2":
                //TDO:
            break;
            case "Chapitre 3":
                //TDO:
            break;
            case "Chapitre 4":
                //TDO:
            break;
            case "Chapitre 5":
            //TDO:
            break;
            case "Chapitre 6":
                //TDO:
            break;
            case "Chapitre 7":
            //TDO:
            break;
        }
        return tpsPane;
    }

    
    public JPanel getPane () {
        return this.pane;
    }
}

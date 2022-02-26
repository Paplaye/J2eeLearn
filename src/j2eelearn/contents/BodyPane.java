package j2eelearn.contents;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import j2eelearn.modules.Chapitre1;
import j2eelearn.utils.Intros;
import j2eelearn.utils.Utils;

import java.awt.*;
import java.awt.event.*;


/***
 * Cette classe est en quelques sorte le coeur de fonctionnement de la classe EeastPanel
 * En fonction de l'évnènement sur le panel de l'entête ou celui à droite un nouveau JPanel est créé pour changer
 * le EastPanel
 * Vous remarquerez le bloc du milieu est divisé en 2 . C'est pourquoi cette classe compose 2 JPanels south et north
 */
public  class BodyPane {
    private JPanel pane;
    private JPanel south;
    private JPanel north;
    private JLabel tit;

    public BodyPane (String titre,int etat) {
        this.pane = new JPanel(new BorderLayout(10, 10));
        this.pane.setBorder(new EmptyBorder(25,15,15,15));
        this.north = new JPanel (new GridLayout (2,1));//north qui est constitué de 2 lignes
        south = new JPanel(); //le south qui contient les informations de la page

        if (titre.compareTo("Home") == 0) { 
            createNorth("Bienvenue Chez J2eeLearn",etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        } else {
            createNorth(titre,etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        }
        
        tit = new JLabel();//le titre
        createSouth(titre);
        this.pane.add(south);
    }
    //le nouveau JPanel renvoyé
    public JPanel getPane () {
        return this.pane;
    }
    //modifie le JPanel du nord
    private void createNorth (String titre,int etat) {
        JPanel titrePane = new JPanel(Utils.getInstance().fcenter);
		this.north.setBorder(Utils.getInstance().lineborder);
		
        JPanel lessonsPane = new JPanel(Utils.getInstance().fleft);//un panel des lessons du module ou chapitre
        JPanel tpsPane     = new JPanel(Utils.getInstance().fright);//un panel des tps du module ou chapitre
        JPanel lessons     = new JPanel();

        if (etat != 0) {
            lessons = ChapsPane(titre,etat);
        }  else {
            tit = new JLabel(titre);
        }

        tit.setFont(new Font("Serif", Font.PLAIN, 30));
		titrePane.add(tit);

        this.north.add(titrePane);
		this.north.add(lessons);
    }
    //modifie le panel du sud
    private void createSouth (String action) {
		this.south.setBorder(Utils.getInstance().lineborder);
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

   //en fonction du titre chap ou autres des informations sont affichées
    //pour les chapitre ou module par défaut c'est l'intro qui est affiché
    public JPanel createChapIntro (String chap) {
        JPanel home = new JPanel(Utils.getInstance().fleft);
        String mgs = new String ("");
        switch (chap) {
            case "Chapitre 1":
                mgs = Intros.getInst().getIntro(0);//intro chap1
            break;
            case "Chapitre 2":
                mgs = Intros.getInst().getIntro(1);//intro chap2
            break;
            case "Chapitre 3":
                mgs = Intros.getInst().getIntro(2);//intro chap3
            break;
            case "Chapitre 4":
                mgs = Intros.getInst().getIntro(3);//intro chap4
            break;
            case "Chapitre 5":
                //TDO: à remplacer par les bonnes info
                mgs = Intros.getInst().getIntro(4);//intro chap5
            break;
            case "Chapitre 6":
                //TDO: à remplacer par les bonnes info
                mgs = Intros.getInst().getIntro(5);//intro chap6
            break;
            case "Chapitre 7":
                //TDO: à remplacer par les bonnes info
                mgs = Intros.getInst().getIntro(6);//intro chap7
            break;
            default:
                mgs = Intros.getInst().homeText();//message d'accueil
            break;
        }
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }
    //gestion des lessons du module ou chapitre avec les évènements qui vont avec
    private JPanel eventLessons (String chap) {
        JPanel lessonsPane = new JPanel(Utils.getInstance().fleft);
        this.tit = new JLabel(chap);

        switch (chap) {
            case "Chapitre 1":
                Chapitre1 c1 = new Chapitre1(chap, north, south);
                lessonsPane = c1.getLessonsPane();//panel lessons du chapitre ou module 1
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
    //gestion des Tps du module ou chapitre avec les évènements qui vont avec
    private JPanel eventsTps (String chap) {
        JPanel tpsPane = new JPanel(Utils.getInstance().fright);
        switch (chap) {
            case "Chapitre 1":
                Chapitre1 c1 = new Chapitre1(chap, north, south);
                tpsPane = c1.getTpsPane();//le Panel TP & Quiz de ce chapitre ou module
                this.north =  c1.getNorth();
                this.south = c1.getSouth();
            break;
            case "Chapitre 2":
                //TDO: Faire de meeme pour le chapitre ou module 2 : Classe Chapitre 
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
    //pour le chapitre chap concerné un JPanel contenant ses leçons et ses Tps et Quiz
    private JPanel ChapsPane (String chap,int etat) {
        JPanel lessons = new JPanel(new GridLayout(1,2));
        lessons.add(eventLessons(chap));
		lessons.add(eventsTps(chap));
        return lessons;
    }
    //
    public JPanel creatConteHome () {
        JPanel home = new JPanel(Utils.getInstance().fleft);
        String mgs = Intros.getInst().homeText();
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }
 
}

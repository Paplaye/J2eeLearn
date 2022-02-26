package j2eelearn.utils;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import j2eelearn.j2eelearn.J2eeLearn;

import javax.swing.SwingConstants; 
import java.awt.*;

/***
 * Cette classe est un singleton pour avoir une seule instance de la classe
 * les attributs et fonctions présentes dans cette classe peuvent être utilisées par plusieurs classes
 * Pour éviter à chaque fois de recharger les images on le fait qu'une fois dans cette classe
 **/
public class Utils {

    private static Utils instance = null;
    private static ImageIcon imgHome;
    private static ImageIcon imgCourse;
    private static ImageIcon imgFaq;
    private static ImageIcon imgGlossaire;
    private static ImageIcon imgSuccess;
    private static ImageIcon imgEchec;
    private static ImageIcon imgHelp;
    
    public static FlowLayout fleft   = new FlowLayout (FlowLayout.LEFT);
    public static FlowLayout fright  = new FlowLayout (FlowLayout.RIGHT);
    public static FlowLayout fcenter = new FlowLayout (FlowLayout.CENTER);
    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public static Border lineborder = BorderFactory.createLineBorder(new Color(0xB0AFAE));

    private JLabel [] chapitres = {
        new JLabel("Chapitre 1"),new JLabel("Chapitre 2"),new JLabel("Chapitre 3"),
        new JLabel("Chapitre 4"),new JLabel("Chapitre 5"),new JLabel("Chapitre 6"),
        new JLabel("Chapitre 7")};

    public String [] entete = {"Home","Faq","Glossaire","Help"};

    private Utils () {
        //Dans ce constructeur on charge toutes les images une seule fois
        imgCourse    = new ImageIcon (J2eeLearn.class.getResource("/icons/course.png"));
        imgHome      = new ImageIcon (J2eeLearn.class.getResource("/icons/home.png")); 
        imgGlossaire = new ImageIcon (J2eeLearn.class.getResource("/icons/glossaire.png"));
        imgFaq       = new ImageIcon (J2eeLearn.class.getResource("/icons/faq.jpg"));
        imgHelp      = new ImageIcon (J2eeLearn.class.getResource("/icons/help.png"));
        imgEchec     = new ImageIcon (J2eeLearn.class.getResource("/icons/echec.png"));
        imgSuccess   = new ImageIcon (J2eeLearn.class.getResource("/icons/success.png"));

    }

    public static Utils getInstance () {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    /*
        args : x pour le height , y pour le width et imgName le nom de l'image sans le path
        retour : 
               - l'imageIcon correspondante dimensionné avec x et y 
               - sinon renvoie une ImageICon vide
    */
    public  static ImageIcon getImageIcon (int x,int y,String imgName) {
        if ("/icons/course.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgCourse.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/home.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgHome.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/glossaire.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgGlossaire.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/faq.jpg".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgFaq.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/help.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgHelp.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/echec.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgEchec.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/success.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgHelp.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else
                return new ImageIcon();
    }
    /*Cette fonction crée un tableau de label contenant les différents modules ou chapitre qui seront affichés
    sur le bloc de Gauche
    */
    public JLabel [] createChapitre () {

        int i = 0;
        for (i = 0;i < chapitres.length; i ++ ) {
            chapitres[i].setBorder(lineborder);
            chapitres[i].setHorizontalAlignment(SwingConstants.LEFT);
            chapitres[i].setIcon(getImageIcon(25,25,"course.png"));
            chapitres[i].setIconTextGap(10);
            chapitres[i].setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            chapitres[i].setOpaque(true);
        }
        return chapitres;
    }
    public int size () {
        return this.chapitres.length;
    }
    //efface la couleur des jlabels passés en paramètre
    public void eraseBackground (JLabel []labs) {    
        for (int i = 0;  i < labs.length; i ++) {
            labs[i].setBackground(null);
            labs[i].setForeground(Color.BLACK);
         }
     }

    public final String eS (int i) {
        return entete [i];
    }
}

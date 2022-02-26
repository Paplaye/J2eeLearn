package j2eelearn.j2eelearn;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import j2eelearn.contents.EastPanel;
import j2eelearn.contents.EntetePane;
import j2eelearn.contents.WestPanel;
import j2eelearn.utils.Utils;

/*Cette classe est la classe principale
**Cette elle qui fait appel aux différentes fonctionnalités des autres classes
*/
public class J2eeLearn extends JFrame {
    private EntetePane northPane;
    private WestPanel westPane;
    private EastPanel eastPane;

	public J2eeLearn () {
        //On récupère les dimensions de l'écrant de la machine hote
		Dimension sc = Utils.getInstance().screen;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //les dimensions de notre fenêtre deviennent la moitié de la largeur de l'écran
        this.setSize(sc.width/2, sc.width/2);
        this.setTitle("J2eeLearn");
        //par défaut on positionne la fenêtre le plus à droite possible
        this.setLocation(sc.width, 0);
        
        //déclaration des trois blocs
        eastPane  = new EastPanel();
        westPane  = new WestPanel(eastPane);
        northPane = new EntetePane(eastPane,westPane);
        
        //Ajout des 3 panneaux sur le panel principal de notre JFrame
        this.getContentPane().add(northPane.getPane(),BorderLayout.NORTH);
        this.getContentPane().add(westPane.getPane(),BorderLayout.WEST);
        this.getContentPane().add(eastPane.getPane(),BorderLayout.CENTER);
        //Rendre la fenêtre visible
        this.setVisible(true);
	}
}
  
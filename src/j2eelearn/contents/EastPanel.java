package j2eelearn.contents;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;

/***
 * Cette classe compose un JPanel qui reprenste le bloc du milieu
 */
public class EastPanel {
    private JPanel pane;

    public EastPanel () {
        this.pane = new JPanel(new GridLayout(1,1));
        this.pane.add(bodyPane("Bienvenue Chez J2eeLearn",0));
    }
    //renvoie le JPanel pane
    public JPanel getPane () {
        return this.pane;
    }
    /**
     * 
     * @param titre : le titre du composant qui 
     * @param etat  : un entier état 1 : pour les modules ou chapitres les autres 0
     * @return un JPanel
     */
    public JPanel bodyPane (String titre,int etat) {
        BodyPane body = new BodyPane(titre,etat);
        return body.getPane();
    }

    /**
     * 
     * @param s : le titre de l'élément
     * cette fonction est celle qui est appélée par WestPanel et EntetePanel après chaque clic
     */
    public void setPane (String s) {
        System.out.println(s);
        this.pane.removeAll();
        switch (s) {
            case "Home":
                this.pane.add(bodyPane(s,0));
            break;
            case "Faq":
                this.pane.add(bodyPane(s,0));
            break;
            case "Glossaire":
                this.pane.add(bodyPane(s,0));
            break;
            case "Help":
                this.pane.add(bodyPane(s,0));
            break;
            default:
                //lorsqu'il s'agit des chapitres ou modules
                this.pane.add(bodyPane(s,1));
            break;
        }
        this.pane.revalidate();
        this.pane.repaint();
        
    }
}

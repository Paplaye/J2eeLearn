package j2eelearn.contents;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;

public class EastPanel {
    private JPanel pane;

    public EastPanel () {
        String [] content = new String [70];
        this.pane = new JPanel(new GridLayout(1,1));
        this.pane.add(bodyPane("Bienvenue Chez J2eeLearn", content,0));
    }
    public JPanel getPane () {
        return this.pane;
    }
    public JPanel bodyPane (String titre,String [] content,int etat) {
        BodyPane body = new BodyPane(titre, content,etat);
        return body.getPane();
    }
    public void setPane (String s) {
        String [] content = new String [70];
        System.out.println(s);
        this.pane.removeAll();
        switch (s) {
            case "Home":
                this.pane.add(bodyPane(s, content,0));
            break;
            case "Faq":
                this.pane.add(bodyPane(s, content,0));
            break;
            case "Glossaire":
                this.pane.add(bodyPane(s, content,0));
            break;
            case "Help":
                this.pane.add(bodyPane(s, content,0));
            break;
            default:
                this.pane.add(bodyPane(s, content,1));
            break;
        }
        this.pane.revalidate();
        this.pane.repaint();

        
    }
}

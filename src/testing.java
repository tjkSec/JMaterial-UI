import javax.swing.*;
import java.awt.*;

public class testing extends JFrame {
    public static void main(String[] args) {
        new testing();
    }

    private testing() {
        super("material ui testing panel");
        JPanel panel = new JPanel();

        /* RaisedButton demonstrations */
        /**/ RaisedButton muiButton1_raised = new RaisedButton("Hello world!", "secondary", true);
        /**/ RaisedButton muiButton2_raised = new RaisedButton("Hello universe!", "default", true);
        /**/ RaisedButton muiButton3_raised = new RaisedButton("Hello (censored)!", "disabled", false);
        /**/ RaisedButton muiButton4_raised = new RaisedButton("Hello Google!", "primary", false);


        /* FlatButton demonstrations */
        /**/ FlatButton muiButton1_flat = new FlatButton("Hello world!", "secondary", true);
        /**/ FlatButton muiButton2_flat = new FlatButton("Hello universe!", "default", true);
        /**/ FlatButton muiButton3_flat = new FlatButton("Hello (censored)!", "disabled", false);
        /**/ FlatButton muiButton4_flat = new FlatButton("Hello Google!", "primary", false);

        setSize(800, 500);
        setResizable(false);
        add(panel);
        panel.add(muiButton1_raised);
        panel.add(muiButton2_raised);
        panel.add(muiButton3_raised);
        panel.add(muiButton4_raised);

        panel.add(muiButton1_flat);
        panel.add(muiButton2_flat);
        panel.add(muiButton3_flat);
        panel.add(muiButton4_flat);
        panel.setBackground(Color.decode("#202331"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

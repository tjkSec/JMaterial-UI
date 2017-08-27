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
        /**/ RaisedButton muiButton4_raised = new RaisedButton("Tool tipped!", "primary", false);


        /* FlatButton demonstrations */
        /**/ FlatButton muiButton1_flat = new FlatButton("Hello world!", "secondary", true);
        /**/ FlatButton muiButton2_flat = new FlatButton("Hello universe!", "default", true);
        /**/ FlatButton muiButton3_flat = new FlatButton("Hello (censored)!", "disabled", false);
        /**/ FlatButton muiButton4_flat = new FlatButton("Tool tipped!", "primary", false);

        setSize(800, 500);
        setResizable(false);
        add(panel);

        /*
            Note: I have experience performance issues with embedded html tooltips, I am assuming it on swings side though because nothing
            I have done programmatically could possibly effect performance.
        */
        // Will default to dark if no theme is chosen.
        String myIcon = "http://www.emoji.co.uk/files/mozilla-emojis/symbols-mozilla/12152-large-red-circle.png";
        muiButton4_raised.setToolTipTheme("dark");
        muiButton4_raised.setToolTipText(
            "<html>" +
                "<img src='" + myIcon +"' width='10' height='10'/>" +
                "<b>&nbsp; Dark theme:</b> <br/> " +
                "This is a JMaterial-UI tooltip demonstration. These special tool tips only work on JM-UI components." +
            "</html>"
        );
        panel.add(muiButton1_raised);
        panel.add(muiButton2_raised);
        panel.add(muiButton3_raised);
        panel.add(muiButton4_raised);

        /*
            Note: I have experience performance issues with embedded html tooltips, I am assuming it on swings side though because nothing
            I have done programmatically could possibly effect performance.
        */
        // Will default to dark if no theme is chosen.
        muiButton4_flat.setToolTipTheme("light");
        muiButton4_flat.setToolTipText(
            "<html>" +
                "<img src='" + myIcon +"' width='10' height='10'/>" +
                "<b>&nbsp; Light theme:</b> <br/> " +
                "This is a JMaterial-UI tooltip demonstration. These special tool tips only work on JM-UI components." +
            "</html>"
        );
        panel.add(muiButton1_flat);
        panel.add(muiButton2_flat);
        panel.add(muiButton3_flat);
        panel.add(muiButton4_flat);

        panel.setBackground(Color.decode("#202331"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

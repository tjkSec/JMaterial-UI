import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class FlatButton extends JButton{
    private String      text               =     "";
    private String      type               =     "default";
    private boolean     animate_events     =     false;

    public FlatButton(String text, String type, boolean animate_events) {
        this.text = text;
        this.type = type;
        this.animate_events = animate_events;
        __init__();
    }

    private void foundations() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(!type.equals("disabled")) {
                    setContentAreaFilled(true);
                }
                switch(type.toLowerCase()) {
                    case "secondary":
                        setForeground(Color.decode("#FFFFFF"));
                        break;
                    case "default":
                        setForeground(Color.decode("#000000"));
                        break;
                    case "primary":
                        setForeground(Color.decode("#FFFFFF"));
                        break;
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(!type.equals("disabled")) {
                    setContentAreaFilled(false);
                }
                switch(type.toLowerCase()) {
                    case "secondary":
                        setForeground(Color.decode("#FF4081"));
                        break;
                    case "default":
                        setForeground(Color.decode("#FFFFFF"));
                        break;
                    case "primary":
                        setForeground(Color.decode("#00BCD4"));
                        break;
                }
            }
        });

        if(this.animate_events) {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    setMargin(new Insets(1,0,0,0));
                }
            });

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    setMargin(new Insets(0,0,0,0));
                }
            });
        }

        NotoFont noto = new NotoFont(true);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setText(this.text.toUpperCase());
        this.setRolloverEnabled(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setModel(new FixedStateJButton());
        this.setMargin(new Insets(0,0,0,0));
        this.setBorderPainted(false);
        this.setFont(noto.get());
        this.setPreferredSize(new Dimension(108 + this.text.length() * 4, 37));
    }

    private void default_type() {
        this.foundations();
        this.setBackground(Color.decode("#FFFFFF"));
        this.setForeground(Color.decode("#FFFFFF"));
    }

    private void primary_type() {
        this.foundations();
        this.setBackground(Color.decode("#00BCD4"));
        this.setForeground(Color.decode("#00BCD4"));
    }

    private void secondary_type() {
        this.foundations();
        this.setBackground(Color.decode("#FF4081"));
        this.setForeground(Color.decode("#FF4081"));
    }

    private void disabled_type() {
        this.foundations();
        this.setBackground(Color.decode("#E5E5E5"));
        this.setForeground(Color.decode("#B2A4A4"));
    }

    private String toolTipTheme = "dark";
    public void setToolTipTheme(String newTheme) {
        if(!(newTheme.toLowerCase().equals("dark") || newTheme.toLowerCase().equals("light"))) {
            // default theme
            this.toolTipTheme = "dark";
        } else {
            this.toolTipTheme = newTheme;
        }
    }

    @Override
    public JToolTip createToolTip() {
        return (new Tooltip(this, this.toolTipTheme));
    }

    private void __init__() {
        switch(this.type.toLowerCase()) {
            case "default":
                default_type();
                break;
            case "primary":
                primary_type();
                break;
            case "secondary":
                secondary_type();
                break;
            case "disabled":
                disabled_type();
                break;
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class RaisedButton extends JButton{
    private String      text               =     "";
    private String      type               =     "default";
    private boolean     animate_events     =     false;

    public RaisedButton(String text, String type, boolean animate_events) {
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
                setBackgroundSecondary();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackgroundPrimary();
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
        this.setModel(new FixedStateJButton());
        this.setMargin(new Insets(0,0,0,0));
        this.setBorderPainted(false);
        this.setFont(noto.get());
        this.setPreferredSize(new Dimension(108 + this.text.length() * 4, 37));
    }

    private HashMap<String, String> getColours() {
        HashMap<String, String> color_kv = new HashMap<>();
        switch(this.type.toLowerCase()) {
            case "default":
                color_kv.put("primary", "#FFFFFF");
                color_kv.put("secondary", "#e2e2e2");
                break;
            case "primary":
                color_kv.put("primary", "#00BCD4");
                color_kv.put("secondary", "#10d0e8");
                break;
            case "secondary":
                color_kv.put("primary", "#FF4081");
                color_kv.put("secondary", "#fc6f9e");
                break;
            case "disabled":
                color_kv.put("primary", "#E5E5E5");
                color_kv.put("secondary", "#E5E5E5");
                break;
        }
        return color_kv;
    }

    private void setBackgroundPrimary() {
        this.setBackground(Color.decode(getColours().get("primary")));
    }

    private void setBackgroundSecondary() {
        this.setBackground(Color.decode(getColours().get("secondary")));
    }

    private void default_type() {
        this.foundations();
        this.setBackground(Color.decode("#FFFFFF"));
        this.setForeground(Color.decode("#000000"));
    }

    private void primary_type() {
        this.foundations();
        this.setBackground(Color.decode("#00BCD4"));
        this.setForeground(Color.decode("#FFFFFF"));
    }

    private void secondary_type() {
        this.foundations();
        this.setBackground(Color.decode("#FF4081"));
        this.setForeground(Color.decode("#FFFFFF"));
    }

    private void disabled_type() {
        this.foundations();
        this.setBackground(Color.decode("#E5E5E5"));
        this.setForeground(Color.decode("#B2A4A4"));
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

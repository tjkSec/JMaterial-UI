import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.GeneralPath;

public class MUISlider extends JSlider {
    private String theme;
    private int span;

    public MUISlider (int width, String theme) {
        super();
        this.theme = theme;
        this.span = width;
        this.setPreferredSize(new Dimension(this.span, 30));
        this.stylus();
    }

    private void stylus() {
        switch(this.theme.toLowerCase()) {
            case "default":
                this.style_default();
                break;
            case "primary":
                this.style_primary();
                break;
            case "secondary":
                this.style_secondary();
                break;
            case "disabled":
                this.style_disabled();
                this.setEnabled(false);
                break;
        }
    }

    private void style_default() {
        this.setUI(new sliderBase(this, "#FFFFFF"));
        this.setOpaque(false);
    }

    private void style_primary() {
        this.setUI(new sliderBase(this, "#00BCD4"));
        this.setOpaque(false);
    }

    private void style_secondary() {
        this.setUI(new sliderBase(this, "#FF4081"));
        this.setOpaque(false);
    }

    private void style_disabled() {
        this.setUI(new sliderBase(this, "#E5E5E5"));
        this.setOpaque(false);
    }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public int getSpan() { return span; }

    public void setSpan(int span) { this.span = span; }

}

class sliderBase extends BasicSliderUI {
    private String theme;
    public sliderBase(JSlider jSlider, String theme) {
        super(jSlider);
        this.theme = theme;
    }

    protected Dimension getThumbSize() {
        return new Dimension(12, 12);
    }

    protected Color getShadowColor() {
        return Color.decode(this.theme);
    }

    protected Color getHighlightColor() {
        return Color.decode(this.theme);
    }

    protected Color getFocusColor() {
        return new Color(0,0,0,0);
    }

    public void paintTrack(Graphics g) {
        super.paintTrack(g);
    }

    public void paintThumb(Graphics g) {
        slider.setBackground(Color.white);
        slider.setBorder(BorderFactory.createEmptyBorder());
        super.paintThumb(g);
    }
}

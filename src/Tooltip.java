import javax.swing.*;
import java.awt.*;

public class Tooltip extends JToolTip{
    private String theme = "dark";
    public Tooltip(JComponent component, String theme) {
        NotoFont noto = new NotoFont(false);
        this.theme = theme;
        this.setComponent(component);
        switch(this.theme.toLowerCase()) {
            case "dark":
                this.setBackground(Color.decode("#212121"));
                this.setForeground(Color.decode("#FFFFFF"));
            case "light":
                this.setBackground(Color.decode("#FFFFFF"));
                this.setForeground(Color.decode("#212121"));
        }
        this.setFont(noto.get());
        this.setBorder(BorderFactory.createEmptyBorder(8,12,8,12));

        this.setSize(new Dimension(100, 100));
    }

}

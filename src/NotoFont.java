import java.awt.*;
import java.io.IOException;

public class NotoFont {
    private boolean bold = true;
    public NotoFont(boolean bold) {
        this.bold = bold;
    }
    public Font get() {
        try {
            Font noto;
            if(this.bold) {
                noto = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/NotoSans-Bold.ttf").openStream());
            } else {
                noto = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/NotoSans-Regular.ttf").openStream());
            }
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(noto);
            noto = noto.deriveFont(14f);
            return noto;
        } catch(FontFormatException | IOException err) {
            err.printStackTrace();
            return new Font("Arial", Font.BOLD, 5);
        }
    }
}

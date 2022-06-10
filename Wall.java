import java.awt.*;

public class Wall {
    private Rectangle r;
    private int xpos, ypos, height, width;
    public Wall(int x, int y, int h, int w) {
        xpos = x;
        ypos = y;
        height = h;
        width = w;
        r = new Rectangle(xpos, ypos, width, height);
    }

    public void paint(Graphics2D g2) {
        g2.fill(r);
    }
}

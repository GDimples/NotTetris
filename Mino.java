import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Mino {
    private int xpos;
    private int ypos;
    private BufferedImage image;
    public Mino(int x, int y) {
        xpos = x;
        ypos = y;
        try {
            image = ImageIO.read(new File("C:\\Users\\joshs\\Desktop\\NotTetris\\mino.png"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
    }
    
    public void changeX(int change) {
        xpos += change;
    }
    public void changeY(int change) {
        ypos += change;
    }

    public int getActualX() {
        return (xpos - 490) / 30;
    }
    public int getActualY() {
        return (600 - ypos) / 30;
    }

    public void paint(Graphics2D g2) {
        g2.drawImage(image, xpos, ypos, 30, 30, null);
    }
}

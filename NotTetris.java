import javax.swing.JFrame;

public class NotTetris extends JFrame {
    public NotTetris() {
        add(new Game());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new NotTetris();
    }
}
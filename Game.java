import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;
public class Game extends JPanel implements KeyListener {
    boolean gameover = false;
    int speed = 500;
    Timer t;
    Mino[][] board = new Mino[30][10];
    Tetrimino piece;
    Wall leftwall = new Wall(480, 30, 600, 10);
    Wall bottomwall = new Wall(480, 630, 10, 320);
    Wall rightwall = new Wall(790, 30, 600, 10);
    public Game() {
        generatePiece();
        repaint();
        addKeyListener(this);
        setFocusable(true);
        ActionListener s = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (!piece.checkYCollision(board)) {
                    piece.fall();
                }
                else {
                    board = piece.place(board);
                    clearLines(checkLineClears());
                    generatePiece();
                }
                repaint();
            }
        };
        t = new Timer(speed, s);
        t.start();
    }
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!piece.checkRightCollision(board)) {
                piece.shiftRight();
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!piece.checkLeftCollision(board)) {
                piece.shiftLeft();
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (speed == 500) {
                speed = 100;
                t.setDelay(speed);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            piece.rotateCW(board);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_QUOTE) {
            piece.rotateCCW(board);
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            speed = 500;
            t.setDelay(speed);
        }
    }

    public void generatePiece() {
        int randomint = (int) (Math.random() * 7);
        switch (randomint) {
            case 0:
                piece = new TPiece(4, 20);
                break;
            case 1:
                piece = new JPiece(4, 20);
                break;
            case 2:
                piece = new LPiece(4, 20);
                break;
            case 3:
                piece = new SPiece(4, 20);
                break;
            case 4:
                piece = new ZPiece(4, 20);
                break;
            case 5:
                piece = new IPiece(4, 20);
                break;
            case 6:
                piece = new OPiece(4, 20);
                break;
        }
    }

    public ArrayList<Integer> checkLineClears() {
        ArrayList<Integer> linestoclear = new ArrayList<Integer>();
        for (int y = 0; y < board.length; y++) {
            boolean fullline = true;
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == null) {
                    fullline = false;
                }
            }
            if (fullline == true) {
                linestoclear.add(y);
            }
        }
        System.out.println(linestoclear);
        return linestoclear;
    }

    public void clearLines(ArrayList<Integer> clearlist) {
        for (int i = 0; i < clearlist.size(); i++) {
            System.out.println(clearlist.get(i));
            for (int x = 0; x < board[0].length; x++) {
                for (int y = clearlist.get(i); y < board.length - 1; y++) {
                    board[y - i][x] = board[y + 1 - i][x];
                    if (board[y - i][x] != null) {
                        board[y - i][x].changeY(30);
                    }
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        piece.paint(g2);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] != null) {
                    board[y][x].paint(g2);
                }
            }
        }
        leftwall.paint(g2);
        bottomwall.paint(g2);
        rightwall.paint(g2);
    }
}

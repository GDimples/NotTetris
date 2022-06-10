import java.awt.*;

public class Tetrimino {
    protected int xpos;
    protected int ypos;
    protected int rotation = 1;
    protected Mino mino1;
    protected Mino mino2;
    protected Mino mino3;
    protected Mino mino4;
    public Tetrimino(int x, int y) {
        xpos = x;
        ypos = y;
    }

    public void fall() {
        ypos -= 1;
        mino1.changeY(30);
        mino2.changeY(30);
        mino3.changeY(30);
        mino4.changeY(30);
    }

    public boolean checkLeftCollision(Mino[][] board) {
        int mino1x = mino1.getActualX();
        int mino2x = mino2.getActualX();
        int mino3x = mino3.getActualX();
        int mino4x = mino4.getActualX();
        int mino1y = mino1.getActualY();
        int mino2y = mino2.getActualY();
        int mino3y = mino3.getActualY();
        int mino4y = mino4.getActualY();
        if (mino1x == 0) {
            return true;
        }
        if (mino2x == 0) {
            return true;
        }
        if (mino3x == 0) {
            return true;
        }
        if (mino4x == 0) {
            return true;
        }
        if (board[mino1y][mino1x - 1] != null) {
            return true;
        }
        if (board[mino2y][mino2x - 1] != null) {
            return true;
        }
        if (board[mino3y][mino3x - 1] != null) {
            return true;
        }
        if (board[mino4y][mino4x - 1] != null) {
            return true;
        }
        return false;
    }

    public boolean checkRightCollision(Mino[][] board) {
        int mino1x = mino1.getActualX();
        int mino2x = mino2.getActualX();
        int mino3x = mino3.getActualX();
        int mino4x = mino4.getActualX();
        int mino1y = mino1.getActualY();
        int mino2y = mino2.getActualY();
        int mino3y = mino3.getActualY();
        int mino4y = mino4.getActualY();
        if (mino1x == 9) {
            return true;
        }
        if (mino2x == 9) {
            return true;
        }
        if (mino3x == 9) {
            return true;
        }
        if (mino4x == 9) {
            return true;
        }
        if (board[mino1y][mino1x + 1] != null) {
            return true;
        }
        if (board[mino2y][mino2x + 1] != null) {
            return true;
        }
        if (board[mino3y][mino3x + 1] != null) {
            return true;
        }
        if (board[mino4y][mino4x + 1] != null) {
            return true;
        }
        return false;
    }

    public boolean checkYCollision(Mino[][] board) {
        int mino1x = mino1.getActualX();
        int mino2x = mino2.getActualX();
        int mino3x = mino3.getActualX();
        int mino4x = mino4.getActualX();
        int mino1y = mino1.getActualY();
        int mino2y = mino2.getActualY();
        int mino3y = mino3.getActualY();
        int mino4y = mino4.getActualY();
        if (mino1y == 0) {
            return true;
        }
        if (mino2y == 0) {
            return true;
        }
        if (mino3y == 0) {
            return true;
        }
        if (mino4y == 0) {
            return true;
        }
        if (board[mino1y - 1][mino1x] != null) {
            return true;
        }
        if (board[mino2y - 1][mino2x] != null) {
            return true;
        }
        if (board[mino3y - 1][mino3x] != null) {
            return true;
        }
        if (board[mino4y - 1][mino4x] != null) {
            return true;
        }
        return false;
    }

    public Mino[][] place(Mino[][] board) {
        Mino[][] newboard = board;
        newboard[mino1.getActualY()][mino1.getActualX()] = mino1;
        newboard[mino2.getActualY()][mino2.getActualX()] = mino2;
        newboard[mino3.getActualY()][mino3.getActualX()] = mino3;
        newboard[mino4.getActualY()][mino4.getActualX()] = mino4;
        return newboard;
    }

    public void shiftLeft() {

        xpos -= 1;
        mino1.changeX(-30);
        mino2.changeX(-30);
        mino3.changeX(-30);
        mino4.changeX(-30);
    }

    public void shiftRight() {
        xpos += 1;
        mino1.changeX(30);
        mino2.changeX(30);
        mino3.changeX(30);
        mino4.changeX(30);
    }

    public void rotateCW(Mino[][] board) {
        
    }
    public void rotateCCW(Mino[][] board) {
        
    }

    public int getX() {
        return xpos;
    }
    public int getY() {
        return ypos;
    }

    public void paint(Graphics2D g2) {
        mino1.paint(g2);
        mino2.paint(g2);
        mino3.paint(g2);
        mino4.paint(g2);
    }
}

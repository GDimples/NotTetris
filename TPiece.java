public class TPiece extends Tetrimino{
    public TPiece(int x, int y){
        super(x, y);
        int actualx = 490 + (30 * x);
        int actualy = 600 - (30 * y);
        mino1 = new Mino(actualx, actualy);
        mino2 = new Mino(actualx - 30, actualy);
        mino3 = new Mino(actualx, actualy - 30);
        mino4 = new Mino(actualx + 30, actualy);
    }

    public void rotateCW(Mino[][] board) {
        switch (rotation) {
            case 1:
                if (ypos != 0) {
                    if (board[ypos - 1][xpos] == null) {
                        mino2.changeX(30);
                        mino2.changeY(-30);
                        mino3.changeX(30);
                        mino3.changeY(30);
                        mino4.changeX(-30);
                        mino4.changeY(30);
                        rotation += 1;
                    }
                }
                break;
            case 2:
                if (xpos != 0) {
                    if (board[ypos][xpos - 1] == null) {
                        mino4.changeX(-30);
                        mino4.changeY(-30);
                        mino2.changeX(30);
                        mino2.changeY(30);
                        mino3.changeX(-30);
                        mino3.changeY(30);
                        rotation += 1;
                    }
                }
                break;
            case 3:
                if (ypos != 30) {
                    if (board[ypos + 1][xpos] == null) {
                        mino4.changeX(30);
                        mino4.changeY(-30);
                        mino3.changeX(-30);
                        mino3.changeY(-30);
                        mino2.changeX(-30);
                        mino2.changeY(30);
                        rotation += 1;
                    }
                }
                break;
            case 4:
            if (xpos != 9) {
                if (board[ypos][xpos + 1] == null) {
                    mino4.changeX(30);
                    mino4.changeY(30);
                    mino3.changeX(30);
                    mino3.changeY(-30);
                    mino2.changeX(-30);
                    mino2.changeY(-30);
                    rotation = 1;
                }
            }
                break;
        }
    }

    public void rotateCCW(Mino[][] board) {
        switch (rotation) {
            case 1:
                if (ypos != 0) {
                    if (board[ypos - 1][xpos] == null) {
                        mino2.changeX(30);
                        mino2.changeY(30);
                        mino3.changeX(-30);
                        mino3.changeY(30);
                        mino4.changeX(-30);
                        mino4.changeY(-30);
                        rotation = 4;
                    }
                }
                break;
            case 2:
                if (xpos != 0) {
                    if (board[ypos][xpos - 1] == null) {
                        mino4.changeX(30);
                        mino4.changeY(-30);
                        mino2.changeX(-30);
                        mino2.changeY(30);
                        mino3.changeX(-30);
                        mino3.changeY(-30);
                        rotation -= 1;
                    }
                }
                break;
            case 3:
                if (ypos != 30) {
                    if (board[ypos + 1][xpos] == null) {
                        mino4.changeX(30);
                        mino4.changeY(30);
                        mino3.changeX(30);
                        mino3.changeY(-30);
                        mino2.changeX(-30);
                        mino2.changeY(-30);
                        rotation -= 1;
                    }
                }
                break;
            case 4:
            if (xpos != 9) {
                if (board[ypos][xpos + 1] == null) {
                    mino4.changeX(-30);
                    mino4.changeY(30);
                    mino3.changeX(30);
                    mino3.changeY(30);
                    mino2.changeX(30);
                    mino2.changeY(-30);
                    rotation -= 1;
                }
            }
                break;
        }
    }
}
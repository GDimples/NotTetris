public class IPiece extends Tetrimino{
    public IPiece(int x, int y){
        super(x, y);
        int actualx = 490 + (30 * x);
        int actualy = 600 - (30 * y);
        mino1 = new Mino(actualx - 30, actualy);
        mino2 = new Mino(actualx, actualy);
        mino3 = new Mino(actualx + 30, actualy);
        mino4 = new Mino(actualx + 60, actualy);
    }

    public void rotateCW(Mino[][] board) {
        switch (rotation) {
            case 1:
                if (ypos > 1) {
                    if (board[ypos + 1][xpos + 1] == null && board[ypos - 1][xpos + 1] == null && board[ypos - 2][xpos + 1] == null) {
                        mino1.changeX(60);
                        mino1.changeY(-30);
                        mino2.changeX(30);
                        mino3.changeY(30);
                        mino4.changeX(-30);
                        mino4.changeY(60);
                        rotation += 1;
                        xpos += 1;
                    }
                }
                break;
            case 2:
                if (xpos > 1 && xpos < 9) {
                    if (board[ypos - 1][xpos - 2] == null && board[ypos - 1][xpos - 1] == null && board[ypos - 1][xpos + 1] == null) {
                        mino1.changeX(30);
                        mino1.changeY(60);
                        mino4.changeX(-60);
                        mino4.changeY(-30);
                        mino2.changeY(30);
                        mino3.changeX(-30);
                        rotation += 1;
                        ypos -= 1;
                    }
                }
                break;
            case 3:
                if (ypos < 29) {
                    if (board[ypos + 2][xpos - 1] == null && board[ypos + 1][xpos - 1] == null && board[ypos - 1][xpos - 1] == null) {
                        mino1.changeX(-60);
                        mino1.changeY(30);
                        mino4.changeX(30);
                        mino4.changeY(-60);
                        mino3.changeY(-30);
                        mino2.changeX(-30);
                        rotation += 1;
                        xpos -= 1;
                    }
                }
                break;
            case 4:
            if (xpos < 8 && xpos > 0) {
                if (board[ypos + 1][xpos + 2] == null && board[ypos + 1][xpos + 1] == null && board[ypos + 1][xpos - 1] == null) {
                    mino1.changeX(-30);
                    mino1.changeY(-60);
                    mino4.changeX(60);
                    mino4.changeY(30);
                    mino3.changeX(30);
                    mino2.changeY(-30);
                    rotation = 1;
                    ypos += 1;
                }
            }
                break;
        }
    }

    public void rotateCCW(Mino[][] board) {
        switch (rotation) {
            case 2:
                if (xpos > 1 && xpos < 9) {
                    if (board[ypos + 1][xpos + 2] == null && board[ypos + 1][xpos + 1] == null && board[ypos + 1][xpos - 1] == null) {
                        mino1.changeX(-60);
                        mino1.changeY(30);
                        mino2.changeX(-30);
                        mino3.changeY(-30);
                        mino4.changeX(30);
                        mino4.changeY(-60);
                        rotation -= 1;
                        xpos -= 1;
                    }
                }
                break;
            case 3:
                if (ypos < 29) {
                    if (board[ypos + 1][xpos + 1] == null && board[ypos - 1][xpos + 1] == null && board[ypos - 2][xpos + 1] == null) {
                        mino1.changeX(-30);
                        mino1.changeY(-60);
                        mino4.changeX(60);
                        mino4.changeY(30);
                        mino2.changeY(-30);
                        mino3.changeX(30);
                        rotation -= 1;
                        ypos += 1;
                    }
                }
                break;
            case 4:
                if (xpos < 8 && xpos > 0) {
                    if (board[ypos - 1][xpos - 2] == null && board[ypos - 1][xpos - 1] == null && board[ypos - 1][xpos + 1] == null) {
                        mino1.changeX(60);
                        mino1.changeY(-30);
                        mino4.changeX(-30);
                        mino4.changeY(60);
                        mino3.changeY(30);
                        mino2.changeX(30);
                        rotation -= 1;
                        xpos += 1;
                    }
                }
                break;
            case 1:
            if (ypos > 1) {
                if (board[ypos + 2][xpos - 1] == null && board[ypos + 1][xpos - 1] == null && board[ypos - 1][xpos - 1] == null) {
                    mino1.changeX(30);
                    mino1.changeY(60);
                    mino4.changeX(-60);
                    mino4.changeY(-30);
                    mino3.changeX(-30);
                    mino2.changeY(30);
                    rotation = 4;
                    ypos -= 1;
                }
            }
                break;
        }
    }
}
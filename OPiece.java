public class OPiece extends Tetrimino{
    public OPiece(int x, int y){
        super(x, y);
        int actualx = 490 + (30 * x);
        int actualy = 600 - (30 * y);
        mino1 = new Mino(actualx, actualy);
        mino2 = new Mino(actualx + 30, actualy);
        mino3 = new Mino(actualx + 30, actualy - 30);
        mino4 = new Mino(actualx, actualy - 30);
    }
}
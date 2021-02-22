import java.util.Random;
public class Board {
    private static int pieces = 0;
    public static void populate(){
        Random rand = new Random();
        pieces = rand.nextInt(41) + 10;
    }

    public static int getNumPieces(){
        return pieces;
    }

    public static int subtractPieces(int takeAway){
        pieces -= takeAway;
        return pieces;
    }
}

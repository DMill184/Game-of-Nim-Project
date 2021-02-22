import java.util.Scanner;
import java.util.Random;
public class Game {
    private static Player player1;
    private static Player player2;
    private static boolean playAgain;
    static String response = "";
    public Game(){
        player1 = new Player();
        player2 = new Player();
    }
    public static void play(){
        playAgain = true;
        while(playAgain){
            Board.populate();
            System.out.println("There are " + Board.getNumPieces() + " on the board");
            Random rand = new Random();
            Scanner sc = new Scanner(System.in);
            //determines which player goes first, 1 or 2
            int startingPlayer = rand.nextInt(2) + 1;
            while(Board.getNumPieces() > 1){
                int takeAway = 0;
                if(startingPlayer %2 == 1){
                    System.out.println("How Many pieces are you taking " + player1.getName() + " ?");
                    takeAway = sc.nextInt();
                    //Ensures that the user does not input an invalid move
                    while(Board.getNumPieces() / 2 < takeAway){
                    System.out.println("You cannot take more than half of the remaining pieces, Choose another amount:");
                    takeAway = sc.nextInt();
                    }
                    startingPlayer += 1;
                }else{
                    System.out.println("How Many pieces are you taking " + player2.getName() + " ?");
                        takeAway = sc.nextInt();
                        //Ensures that the user does not input an invalid move
                    while(Board.getNumPieces() / 2 < takeAway){
                        System.out.println("You cannot take more than half of the remaining pieces, Choose another amount:");
                        takeAway = sc.nextInt();
                    }
                    startingPlayer += 1;
                }
                Board.subtractPieces(takeAway);
                System.out.println(Board.getNumPieces() + " Pieces left!");
            }
                //Determines who wins the round
                if(startingPlayer%2 == 1){
                    System.out.println(player1.getName() + " has lost and " + player2.getName() + " has won this round!");
                    System.out.println(player2.getName() + " Gets a Point! Yay!");
                    player2.addScore();
                }else{
                    System.out.println(player2.getName() + " has lost and " + player1.getName() + " has won this round!");
                    System.out.println(player1.getName() + " Gets a Point! Yay!");
                    player1.addScore();
                }
                // asks user if they would like to play again
                System.out.println("Play Again?");
                response = sc.nextLine();
                if(response.equals("Yes") || response.equals("yes") || response.equals("Y") || response.equals("y")){
                    playAgain = true;
                }else{
                    playAgain = false;
                }
        }
            //End after all games
            System.out.println(player1.getName() + " has ended with " + player1.getScore() + " points");
            System.out.println(player2.getName() + " has ended with " + player2.getScore() + " points");

            if(player1.getScore() >player2.getScore()){
                System.out.println(player1.getName() + " Wins!!!");
            }else{
                System.out.println(player2.getName() + " Wins!!!");
            }
        }
} 
  
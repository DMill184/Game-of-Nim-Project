import java.util.Scanner;
public class Player {
    //Attributes
    private String name;
    private int score;

    //Constructor of player
    public Player(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is this player's name?");
        name = sc.nextLine();
        score = 0;
    }
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void addScore(){
        score += 1;
          
    }
}

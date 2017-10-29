import java.util.Random;
import java.util.Scanner;

public class Stones {

    private int computerStones;
    private int computerGuess;
    private int myStones;
    private int myGuess;
    private Random random;
    private Scanner scanner;

    private Stones() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String args[]) {
        Stones game = new Stones();
        game.play();
    }

    private void play() {
        readVariables();
        while ((computerGuess != (computerStones + myStones)) && (myGuess != (computerStones + myStones))) {
            readVariables();
        }
        if (computerGuess == computerStones + myStones) {
            System.out.println("Computer wins");
        } else {
            System.out.println("You win");
        }
        System.out.println("My stones: " + myStones);
        System.out.println("Computer stones: " + computerStones);
        System.out.println("My guess: " + myGuess);
        System.out.println("Computer guess: " + computerGuess);
    }

    private void readVariables() {
        System.out.println("Please enter 2 numbers");
        myStones = scanner.nextInt();
        myGuess = scanner.nextInt();
        computerStones = random.nextInt(3);
        computerGuess = random.nextInt(6);

        while (myGuess == computerGuess) {
            System.out.println("Guess again: ");
            myGuess = scanner.nextInt();
        }
    }
}
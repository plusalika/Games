import java.util.Random;
import java.util.Scanner;


public class BullsAndCows {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int[] t;
    private int[] myGuess;
    private int[] compGuess;
    private int[] counter ={1,2,3,4};
    private int cow = 0;
    private int bull = 0;



    public static void main(String args[]){

        BullsAndCows game = new BullsAndCows();
        game.play();

    }

    private void play() {
        myGuess = new int[4];
        computerGuess();
            //for (int y = 0; y < compGuess.length; y++){
            //    System.out.println(compGuess[y]);
            //}
        while (bull < 4) {
            for (int i = 0; i < myGuess.length; i++) {
                myGuess[i] = scanner.nextInt();
            }
            for (int a = 0; a < compGuess.length; a++) {
                for (int b = 0; b < myGuess.length; b++) {
                    if (myGuess[a] == compGuess[b]) {
                        cow = cow + 1;
                        if ((myGuess[a] == compGuess[a]) && (myGuess[b] == compGuess[b])) {
                            bull = bull + 1;
                            cow = cow - 1;
                        }
                    }
                }
            }
            System.out.println("Cows = " + cow + " and bulls = " + bull);
            if (bull == 4 ) {
                System.out.println("You win");
                break;
            }else {
                cow = 0;
                bull = 0;
            }
        }
    }

    private void computerGuess(){
        compGuess = new int[4];
        t = new int[10];
        int a;
        for (int i = 0; i <t.length; i++){
            t[i] = i;
        }
        for (int x = 0; x < compGuess.length; x++){
            a = (random.nextInt(10));
            do {
                if (t[a] == -1) {
                    a = random.nextInt(10);
                    compGuess[x] = a;
                }
            } while (t[a] == -1);
            compGuess[x]= a;
            t[a] = -1;
        }
    }
}
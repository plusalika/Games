import java.util.Scanner;

public class JosephusProblem {

    private Scanner scanner = new Scanner(System.in);
    private int m = scanner.nextInt();
    private int n = scanner.nextInt();
    boolean[] x =  new boolean[n];
    private int k;
    private int counter = n;
    private int current = m-1;
    private int a = 0;

    public static void main(String args[]){
        System.out.println("Enter the number of every killed person - m - first number");
        System.out.println("Enter the number of all people - n - second number");
        JosephusProblem game= new JosephusProblem();
        game.start();
        game.killing();
    }

    private void start(){
        for (int i=0; i<n; i++) {
            x[i]=true;
        }
    }

    private void killing(){
        while (counter > 1){
            for (int i = 0; i<x.length; i++){
                a = a+1;
                if (!x[i]) {
                    a = a - 1;
                    current = current + 1;
                    if (current > n - 1) current = current - n;
                } else {
                    if (i == current) {
                        if (a == m) {
                            if (counter > 1) {
                                a = 0;
                                x[i] = false;
                                counter = counter - 1;
                                current = current + m;
                            } else break;
                        }
                    }
                    if (current > n - 1) current = current - n;
                }
            }
        }

        for (int i = 0; i<x.length; i++) {
            if (x[i]) {
                k = i+1;
                System.out.println("The " + k +"th person will remain the last and survive");
            }
        }
    }
}
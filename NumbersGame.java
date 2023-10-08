import java.util.Random;

public class NumbersGame {
    public static void main(String[] args) {
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int answer = new Random().nextInt(10) + 1; // MODIF 3
                                                  // MODIF 2 
        int trygame = 0;

        while (true) {
            String guess = System.console().readLine();
            if (guess.equals("q")) {
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }
            try { // MODIF 1

                if (Integer.parseInt(guess) == answer) {
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                } else {
                    System.out.println("Swing and a miss! Keep trying...(you only have " +"0"+ (((trygame)-2)* -1) +" tries)");
                    trygame++;
                    //Ninja Bonus 1
                    if (trygame == 3) {
                        System.out.println("limit of 03 attempts reached ! Sorry you lost... ");
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(" NumberFormatException : " + e);
            }
        }
        
        System.out.println("\nWould you like to play again? (y/n)");
        String answer2 = System.console().readLine();
        if (answer2.equals("y")) {
            NumbersGame.replay();  
        } else {
            System.out.println("Game over. Shutting down...");
        }
    }


    //Ninja Bonus 2
    private static void replay() {
        // Call the main() method again
       NumbersGame.main(null); 
    }

}

import java.util.*;
class GuessNo{    
    public static void main(String args[]){
        int choice=1;

        while(choice == 1){
        Scanner sc = new Scanner(System.in);
        System.out.println("------WELCOME-----");
        System.out.println("1: Play Game");
        System.out.println("2: Quit Game");
        System.out.print("Enter choice : ");
        choice = sc.nextInt();
        if(choice==2){
            System.out.println();
            System.out.println("Gone too Soon");
            break;
        }
        if(choice!=1){
            System.out.println("\nWrong Choice\n");
            choice = 1;
            continue;
        }
        System.out.println("---------------------------------");
        System.out.println("You are Playing Now (10 Chances only !!) ");
        System.out.println("---------------------------------");
        int i=0;
        Random rand = new Random();
        int randvalue = rand.nextInt(100)+1;
        //System.out.println("Generated No : "+randvalue);

        while(i<11){
        if(i==10){
            System.out.println("---------------------------------");
            System.out.println("Your Chances are Over !!");
            break;
        }
        int guess;        
        System.out.print("Enter your Guess (1-100) : ");
        guess = sc.nextInt();
        if(guess==randvalue){
            System.out.println("---------------------------------");
             System.out.println("You Guessed it Correct !! ");
             System.out.println("Your Score : "+ (10-i)*10 );
             break;
        }
        else if(guess>randvalue){
            if(guess-randvalue>10) System.out.println("Guess is Too High !!");
            else System.out.println("Guess is Little High !!");
        }

        else if(randvalue-guess>10) System.out.println("Guess is Too Low !!");
        else System.out.println("Guess is Little Low !!");

        i++;
        }
        System.out.println("---------------------------------");
        }
    }
}

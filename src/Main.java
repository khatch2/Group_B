import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your name: ");
        //String name = scanner.nextLine();
        //System.out.println("Hello " + name + "!");
        while(true) {
            System.out.println("1. Addera en fund? \n2. ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Du har valt case 1");
            }
        }




    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("patrick");
        //System.out.println("Enter your name: ");
        //String name = scanner.nextLine();
        //System.out.println("Hello " + name + "!");
//        while(true) {
//            System.out.println("1. Addera en fund? \n2. ");
//
//            int choice = scanner.nextInt();
//
//            switch(choice) {
//
//                case 1:
//                    System.out.println("Du har valt case 1");
//            }
//        }


        // sek, eur, pund, usd, yen


        int userCapital = 5000; // sek

//        System.out.println("Vilken valuta vill du köpa?");
//        System.out.println("\n1: EUR\n2: Pound\n3: USD\n4: Yen");
//        System.out.println("Svar: ");

        System.out.println("Välj företag: \nFöretag 1\nFöretag 2\nFöretag 3");
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        switch (userChoice) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
        }

        // i förhållande till sek

        // kanske ska använda enum?
        //Currency eur = new Currency("EUR", );

    }
}
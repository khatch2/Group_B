import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Company> companyList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Company företag1 = new Company("JoelAB", 250);
        Company företag2 = new Company("SirakAB", 250);
        Company företag3 = new Company("RonjaAB", 250);
        Company företag4 = new Company("KhatchikAB", 250);
        Company företag5 = new Company("JacobAB", 250);
        Company företag6 = new Company("MajidAB", 250);
        Company företag7 = new Company("AlbinAB", 250);
        Company företag8 = new Company("PatrickAB", 250);

        companyList.add(företag1);
        companyList.add(företag2);
        companyList.add(företag3);
        companyList.add(företag4);
        companyList.add(företag5);
        companyList.add(företag6);
        companyList.add(företag7);
        companyList.add(företag8);

        while (true) {
            System.out.println("meny");
            System.out.println("1. Visa alla företag \n2. köp\n3. sälj\n4. visa portfolio\n0. avsluta");
            int val = scanner.nextInt();
            scanner.nextLine();

            switch (val) {
                case 1:
                    for (Company company : companyList) {
                        System.out.println(company);
                    }
                    break;
                case 2:
                    // TODO vad det kostar
                    // TODO att man har det värdet i aktier
                    break;
                case 3:
                    // TODO kolla antal aktier och gångra med priset
                    break;
                case 4:
                    // TODO skapa lista för portfolio som innehåller företag, antal aktier
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}

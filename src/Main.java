import javax.sound.sampled.Port;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Company> companyList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double userCapital = 5000; // 5000 SEK startpacket
        Portfolio userPortfolio;
        ArrayList<Portfolio> portfolioList = new ArrayList<>();

        Company företag1 = new Company("JoelAB", 200);
        Company företag2 = new Company("SirakAB", 200);
        Company företag3 = new Company("RonjaAB", 200);
        Company företag4 = new Company("KhatchikAB", 200);
        Company företag5 = new Company("JacobAB", 200);
        Company företag6 = new Company("MajidAB", 200);
        Company företag7 = new Company("AlbinAB", 200);
        Company företag8 = new Company("PatrickAB", 200);

        companyList.add(företag1);
        companyList.add(företag2);
        companyList.add(företag3);
        companyList.add(företag4);
        companyList.add(företag5);
        companyList.add(företag6);
        companyList.add(företag7);
        companyList.add(företag8);

        boolean run = true;
        while (run) {
            System.out.println("meny - Ditt kapital = " + userCapital);
            System.out.println( "1. Visa alla företag \n" +
                                "2. köp\n" +
                                "3. sälj\n" +
                                "4. visa portfolio\n" +
                                "0. avsluta");
            int val = scanner.nextInt();
            scanner.nextLine();

            switch (val) {
                case 1:
                    printAllCompanies(companyList);
                    break;

                case 2:
                    System.out.println("Enter the company name: ");
                    String companyName = scanner.nextLine();

                    System.out.println("Enter the desired amount of stocks you wish to purchase: ");
                    int numberOfStocks = scanner.nextInt();
                    scanner.nextLine();

                    Company companyToBuy = null;

                    for(Company company : companyList) {
                        if (company.getName().equalsIgnoreCase( companyName) ) {

                            companyToBuy = company;

                            company.setStockAmount(company.getStockAmount() - numberOfStocks );
                            break;
                        }
                    }

                    if (companyToBuy != null){
                        int totalCost = (int) (numberOfStocks * companyToBuy.getStockPrice()) ;
                        System.out.println(" total cost: " + totalCost + " SEK " );
                        userCapital -= totalCost;
                        userPortfolio = new Portfolio(companyToBuy.getName(), numberOfStocks);
                        portfolioList.add(userPortfolio);

                    }      else {
                        System.out.println(" Company is not available.");
                    }

                    for(Company company : companyList) {
                        company.randomizeStockPrice(company.getStockPrice());
                    }
                    break;

                case 3:
//                    for (Company company : companyList) {
//                        System.out.println("  Company's name " +
//                                company.getName() + " has the price of all its stock = " +
//                                company.getStockAmount() * company.getStockPrice() +
//                                " SEK " );
//                    }

                    printPortfolio(portfolioList);
                    System.out.println("Välj ett företag vars aktier du vill sälja");
                    int companyNumberOrder = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Antal aktier du vill sälja: ");
                    numberOfStocks = scanner.nextInt();
                    scanner.nextLine();



                    /*
                    Company companyToSell = null;

                    for(Company company : companyList) {
                        if (company.getName().equalsIgnoreCase( companyName) ) {

                            companyToSell = company;

                            company.setStockAmount(company.getStockAmount() + numberOfStocks );
                            break;
                        }
                    }

                    if (companyToSell != null){
                        int totalProfit = (int) (numberOfStocks * companyToSell.getStockPrice()) ;
                        System.out.println(" total profit: " + totalProfit + " SEK " );
                        userCapital += totalProfit;

                        portfolioList.remove(companyNumberOrder-1);

                    }      else {
                        System.out.println(" Company is not available.");
                    } */


                    /*
                    for (int i = 0; i < portfolioList.size(); i++) {
                        if (portfolioList.get(i).getCompanyName().equalsIgnoreCase(choice)) {

                        }
                    }*/

                    // räkna ut priset som man sålt för
                    // få pengarna på kontot
                    // de aktierna ska tas bort från portfolion
                    // aktierna ska komma tillbaka till företaget
                    break;
                case 4:
                    // TODO skapa lista för portfolio som innehåller företag, antal aktier
                    printPortfolio(portfolioList);
                    break;
                    // TODO visa transaktions historik
                case 0:
                    run = false;
                    scanner.close();
                    return;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    private static void printAllCompanies(ArrayList<Company> companyList) {
        for (int i = 0; i < companyList.size(); i++) {
            Company company = companyList.get(i);
            System.out.println((i+1) + ": " + company);
        }
    }

    private static void printPortfolio(ArrayList<Portfolio> portfolioList) {
        for (int i = 0; i < portfolioList.size(); i++) {
            Portfolio portfolio = portfolioList.get(i);
            System.out.println((i+1) + ": " + portfolio);
        }


//        for (Portfolio portfolio : portfolioList) {
//            System.out.println(portfolio);
//        }
    }
}

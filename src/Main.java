import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Company> companyList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double userCapital = 5000;
        Portfolio userPortfolio;
        ArrayList<Portfolio> userPortfolioList = new ArrayList<>();

        companyList.add(new Company("JoelAB", 200));
        companyList.add(new Company("SirakAB", 200));
        companyList.add(new Company("RonjaAB", 200));
        companyList.add(new Company("KhatchikAB", 200));
        companyList.add(new Company("JacobAB", 200));
        companyList.add(new Company("MajidAB", 200));
        companyList.add(new Company("AlbinAB", 200));
        companyList.add(new Company("PatrickAB", 200));

        boolean run = true;
        while (run) {
            System.out.println("meny - Ditt kapital = " + userCapital);
            System.out.println( "1. Visa alla company \n" +
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
                        userPortfolioList.add(userPortfolio);

                    }      else {
                        System.out.println(" Company is not available.");
                    }

                    for(Company company : companyList) {
                        company.randomizeStockPrice(company.getStockPrice());
                    }
                    break;

                case 3:
                    printPortfolio(userPortfolioList);
                    System.out.println("Välj ett company vars aktier du vill sälja");
                    int companyNumberOrder = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Antal aktier du vill sälja: ");
                    numberOfStocks = scanner.nextInt();
                    scanner.nextLine();


                    Company companyToSell = companyList.get(companyNumberOrder-1);
                    companyToSell.setStockAmount(companyToSell.getStockAmount() + numberOfStocks );

                    if (companyToSell != null){
                        int totalProfit = (int) (numberOfStocks * companyToSell.getStockPrice()) ;
                        System.out.println(" total profit: " + totalProfit + " SEK " );
                        userCapital += totalProfit;

                        userPortfolioList.get(companyNumberOrder-1).setStockAmount(
                                userPortfolioList.get(companyNumberOrder-1).getStockAmount() - numberOfStocks);
                        if (userPortfolioList.get(companyNumberOrder-1).getStockAmount() == 0) {
                            userPortfolioList.remove(companyNumberOrder-1);
                        }

                    }      else {
                        System.out.println(" Company is not available.");
                    }

                    break;
                case 4:
                    printPortfolio(userPortfolioList);
                    break;
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
    }
}

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
            System.out.println("Stockmarket");
            System.out.println("User capital: " + userCapital);
            System.out.println( "1. Show all companies\n" +
                                "2. Buy stocks\n" +
                                "3. Sell stocks\n" +
                                "4. Show portfolio\n" +
                                "0. Exit");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    printList(companyList);
                    break;
                case 2:
                    System.out.println("Enter the company name you want to buy stocks from: ");
                    String companyName = scanner.nextLine();

                    System.out.println("Enter the desired amount of stocks you wish to purchase: ");
                    int numberOfStocksToBuy = scanner.nextInt();
                    scanner.nextLine();

                    Company companyStocksToBuy = null;

                    for(Company company : companyList) {
                        if (company.getName().equalsIgnoreCase(companyName)) {

                            companyStocksToBuy = company;

                            company.setStockAmount(company.getStockAmount() - numberOfStocksToBuy);
                            break;
                        }
                    }

                    if (companyStocksToBuy != null){
                        int totalStockPrice = (int) (numberOfStocksToBuy * companyStocksToBuy.getStockPrice()) ;
                        System.out.println("Total cost: " + totalStockPrice + " SEK " );
                        userCapital -= totalStockPrice;
                        userPortfolio = new Portfolio(companyStocksToBuy.getName(), numberOfStocksToBuy);
                        userPortfolioList.add(userPortfolio);

                    }      else {
                        System.out.println("Company is not available.");
                    }

                    for(Company company : companyList) {
                        company.randomizeStockPrice(company.getStockPrice());
                    }
                    break;
                case 3:
                    printList(userPortfolioList);
                    System.out.println("\nChoose the company stock you want to sell");
                    int companyIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("Enter the amount of stocks you want to sell");
                    int numberOfStocksToSell = scanner.nextInt();
                    scanner.nextLine();

                    Company companyStocksToSell = companyList.get(companyIndex);
                    companyStocksToSell.setStockAmount(companyStocksToSell.getStockAmount() + numberOfStocksToSell);

                    if (companyStocksToSell != null){
                        int userProfit = (int) (numberOfStocksToSell * companyStocksToSell.getStockPrice()) ;
                        System.out.println("Profit: " + userProfit + " SEK " );
                        userCapital += userProfit;

                        userPortfolioList.get(companyIndex).setStockAmount(
                                userPortfolioList.get(companyIndex).getStockAmount() - numberOfStocksToSell);

                        if (userPortfolioList.get(companyIndex).getStockAmount() == 0) {
                            userPortfolioList.remove(companyIndex);
                        }
                    }      else {
                        System.out.println("\nCompany stocks not available.");
                    }
                    break;
                case 4:
                    printList(userPortfolioList);
                    break;
                case 0:
                    run = false;
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter one of the menu options.");
            }
            System.out.println();
        }
    }

    private static <T> void printList(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            System.out.println((i+1) + ": " + item);
        }
    }
}

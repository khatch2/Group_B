import java.util.ArrayList;
import java.util.InputMismatchException;
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
            System.out.println("1. Show all companies\n" +
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
                    // Kontrollera om användaren har tillräckligt med kapital för att köpa
                    double cheapestStockPrice = companyList.stream()
                            .mapToDouble(Company::getStockPrice)
                            .min()
                            .orElse(Double.MAX_VALUE);

                    if (userCapital < cheapestStockPrice) {
                        System.out.println("Your capital is insufficient to purchase even one stock.");
                        break;
                    }

                    // Leta efter företaget med matchande namn
                    System.out.println("Enter the company name you want to buy stocks from: ");
                    String companyName = scanner.nextLine().trim();

                    boolean companyFound = false;
                    Company companyStocksToBuy = null;

                    for (Company company : companyList) {
                        if (company.getName().equals(companyName)) {
                            companyFound = true;
                            companyStocksToBuy = company;
                            break;
                        }
                    }

                    if (!companyFound) {
                        System.out.println("Company does not exist.");
                    } else {
                        // Hantering av aktie-köp
                        int numberOfStocksToBuy;
                        while (true) {
                            numberOfStocksToBuy = getValidIntInput(scanner,
                                    "Enter the desired amount of stocks you wish to purchase: ");

                            // Validera inmatningen för antalet aktier
                            if (numberOfStocksToBuy <= 0) {
                                System.out.println("You must purchase a positive number of stocks.");
                            } else if (numberOfStocksToBuy * companyStocksToBuy.getStockPrice() > userCapital) {
                                System.out.println("You do not have enough capital to purchase this many stocks.");
                            } else if (numberOfStocksToBuy > companyStocksToBuy.getStockAmount()) {
                                System.out.println("Not enough stocks available.");
                            } else {
                                break;
                            }
                        }

                        int totalCostOfStocks = (int) (numberOfStocksToBuy * companyStocksToBuy.getStockPrice());
                        System.out.println("Total cost of purchased stocks: " + totalCostOfStocks + " SEK ");
                        userCapital -= totalCostOfStocks;
                        companyStocksToBuy.setStockAmount(companyStocksToBuy.getStockAmount() - numberOfStocksToBuy);

                        // Lägg till köpet i portföljen
                        userPortfolio = new Portfolio(companyStocksToBuy.getName(), numberOfStocksToBuy);
                        userPortfolioList.add(userPortfolio);
                    }

                    // Uppdatera aktiekurserna
                    for (Company company : companyList) {
                        company.randomizeStockPrice(company.getStockPrice());
                    }
                    break;
                case 3:
                    if (userPortfolioList.isEmpty()) {
                        System.out.println("The portfolio is empty. You have no stocks to sell.");
                        break;
                    }

                    printList(userPortfolioList);
                    int companyIndex;

                    // Kontrollera giltigt index för företaget som användaren vill sälja utifrån
                    while (true) {
                        companyIndex = getValidIntInput(scanner, "\nChoose the company stock you want to sell: ") - 1;

                        if (companyIndex >= 0 && companyIndex < userPortfolioList.size()) {
                            break;
                        } else {
                            System.out.println("Invalid selection. Please enter a number between 1 and "
                                    + userPortfolioList.size());
                        }
                    }

                    // Hämta det antal aktier som användaren har i det valda företaget
                    Portfolio selectedPortfolio = userPortfolioList.get(companyIndex);

                    int stocksAvailableToSell = selectedPortfolio.getStockAmount();

                    int amountOfStocksToSell;

                    // Kontrollera att antalet aktier att sälja är giltigt
                    while (true) {
                        amountOfStocksToSell = getValidIntInput(scanner, "Enter the amount of stocks you want to sell");

                        if (amountOfStocksToSell > 0 && amountOfStocksToSell <= stocksAvailableToSell) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid input. You can sell between 1 and " + stocksAvailableToSell + " stocks.");
                        }
                    }

                    // Genomför försäljningen
                    Company companyStocksToSell = companyList.get(companyIndex);
                    companyStocksToSell.setStockAmount(companyStocksToSell.getStockAmount() + amountOfStocksToSell);

                    int userProfit = (int) (amountOfStocksToSell * companyStocksToSell.getStockPrice());
                    System.out.println("Profit: " + userProfit + " SEK ");
                    userCapital += userProfit;

                    selectedPortfolio.setStockAmount(selectedPortfolio.getStockAmount() - amountOfStocksToSell);

                    if (selectedPortfolio.getStockAmount() == 0) {
                        userPortfolioList.remove(companyIndex);
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

    // Hjälpmetod för att hantera korrekt inmatning
    private static int getValidIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    // Skriv ut en lista baserat på företag eller portfölj
    private static <T> void printList(ArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("The portfolio is empty.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            System.out.println((i + 1) + ": " + item);
        }
    }

}

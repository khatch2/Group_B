public class Company {

    private String companyName;
    private double stockPrice;
    private int stockAmount;


    public String getName() {
        return companyName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Company(String name, double stockPrice) {
        this.companyName = name;
        this.stockPrice = stockPrice;
        this.stockAmount = 1000;
    }

    public void randomizeStockPrice(double stockPrice) {
        this.stockPrice = stockPrice * (Math.random()+0.5);
    }

    @Override
    public String toString() {
        return "Company: " + companyName +
                ", Stock price: " + stockPrice + ", Stock amount: " + stockAmount + "\n";
    }
}

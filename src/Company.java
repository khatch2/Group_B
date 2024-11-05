public class Company {

    // Feilds
    private String name;
    private double stockPrice;
    private int stockAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }



    // Constructer.
    public Company(String name, double stockPrice) {
        this.name = name;
        this.stockPrice = stockPrice;
        this.stockAmount = 1;
    }

    // Another Constructer.
    public Company(String name, double stockPrice, int stockAmount) {
        this.name = name;
        this.stockPrice = stockPrice;
        this.stockAmount = stockAmount;
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", stockPrice=" + stockPrice +
                ", stockAmount=" + stockAmount +
                '}';
    }
}

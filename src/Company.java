public class Company {
    private String name;
    private double stockPrice;

    public Company(String name, double stockPrice) {
        this.name = name;
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", stockPrice=" + stockPrice +
                '}';
    }
}

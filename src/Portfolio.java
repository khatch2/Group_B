public class Portfolio {
    private String companyName;
    private int stockAmount;

    public Portfolio(String companyName, int stockAmount) {
        this.companyName = companyName;
        this.stockAmount = stockAmount;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "companyName='" + companyName + '\'' +
                ", stockAmount=" + stockAmount +
                '}';
    }
}

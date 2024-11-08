public class Portfolio {
    private String companyName;
    private int stockAmount;

    public Portfolio(String companyName, int stockAmount) {
        this.companyName = companyName;
        this.stockAmount = stockAmount;
    }

    public String getCompanyName() {
        return companyName;
    }
    public int getStockAmount() {
        return stockAmount;
    }
//
//    public double sellStock(String companyName, int stockAmount) {
//
//    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "companyName='" + companyName + '\'' +
                ", stockAmount=" + stockAmount +
                '}';
    }
}

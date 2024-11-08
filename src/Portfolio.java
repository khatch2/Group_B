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
    public void setStockAmount(int newStockAmount) {
        this.stockAmount = newStockAmount;
    }

    @Override
    public String toString() {
        // TODO fixa så att utskriften blir lite tydligare
        return "Portfolio{" +
                "companyName='" + companyName + '\'' +
                ", stockAmount=" + stockAmount +
                '}';
    }
}

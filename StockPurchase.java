public class StockPurchase {
    private String symbol;
    private int shares;
    private double costPerShare;

    public StockPurchase(String symbol, int shares, double costPerShare) {
        this.symbol = symbol;
        this.shares = shares;
        this.costPerShare = costPerShare;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return shares;
    }

    public double getCostPerShare() {
        return costPerShare;
    }

    public void setNumberOfShares(int shares) {
        this.shares = shares;
    }
}
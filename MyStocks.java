public class MyStocks {
    private StockLedger ledger;

    public MyStocks() {
        this.ledger = new StockLedger();
    }

    public void buy(String symbol, int shares, double costPerShare) {
        ledger.buy(symbol, shares, costPerShare);
        System.out.println("Bought " + shares + " shares of " + symbol + " @ $" + costPerShare + " each.");
    }

    public double sell(String symbol, int shares, double salePricePerShare) {
        double gain = ledger.sell(symbol, shares, salePricePerShare);
        System.out.println("Sold " + shares + " shares of " + symbol + " @ $" + salePricePerShare + " each.");
        return gain;
    
    }
    
}

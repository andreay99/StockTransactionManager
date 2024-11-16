import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class StockLedger {
    private Map<String, Deque<StockPurchase>> ledger;

    public StockLedger() {
        ledger = new HashMap<>();
    }

    public void buy(String symbol, int shares, double costPerShare) {
        Deque<StockPurchase> transactions = ledger.computeIfAbsent(symbol, k -> new LinkedList<>());
        transactions.addLast(new StockPurchase(symbol, shares, costPerShare));
    }

    public double sell(String symbol, int shares, double salePricePerShare) {
        Deque<StockPurchase> transactions = ledger.get(symbol);
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions found for stock: " + symbol);
            return 0.0;
        }

        double capitalGain = 0.0;

        while (shares > 0 && !transactions.isEmpty()) {
            StockPurchase oldestPurchase = transactions.pollFirst();
            int availableShares = oldestPurchase.getNumberOfShares();
            double purchasePrice = oldestPurchase.getCostPerShare();

            if (shares >= availableShares) {
                capitalGain += (salePricePerShare - purchasePrice) * availableShares;
                shares -= availableShares;
            } else {
                capitalGain += (salePricePerShare - purchasePrice) * shares;
                int remainingShares = availableShares - shares;
                oldestPurchase.setNumberOfShares(remainingShares);
                transactions.addFirst(oldestPurchase);
                shares = 0;
            }
        }

        if (shares > 0) {
            System.out.println("Not enough shares to complete the sale for stock: " + symbol);
        }

        return capitalGain;
    }

    // Returns all the stock symbols
    public Set<String> getAllSymbols() {
        return ledger.keySet();
    }

    // Calculates the total number of shares for a given symbol
    public int getTotalShares(String symbol) {
        Deque<StockPurchase> transactions = ledger.get(symbol);
        if (transactions == null) {
            return 0;
        }

        int total = 0;
        for (StockPurchase purchase : transactions) {
            total += purchase.getNumberOfShares();
        }
        return total;
    }
}
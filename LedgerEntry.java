import java.util.Deque;
import java.util.LinkedList;

public class LedgerEntry {
    private String symbol;
    private Deque<StockPurchase> transactions;

    public LedgerEntry(String symbol) {
        this.symbol = symbol;
        this.transactions = new LinkedList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public Deque<StockPurchase> getTransactions() {
        return transactions;
    }
}
public class Driver1 {
    public static void main(String[] args) {
        StockLedger myStocks = new StockLedger();

        System.out.println("Buy 20 shares @ $45 each.");
        System.out.println("Buy 20 shares @ $75 each.");

        myStocks.buy("DIS", 20, 45); // Specify the symbol "DIS"
        myStocks.buy("DIS", 20, 75); // Specify the symbol "DIS"

        System.out.print("\nSell 30 shares @ $65 each at a gain (loss) of $");
        double capGain = myStocks.sell("DIS", 30, 65); // Specify the symbol "DIS"
        System.out.println(capGain);                   // $300

        System.out.print("\nSell 10 shares @ $65 each at a gain (loss) of $");
        capGain = myStocks.sell("DIS", 10, 65);        // Specify the symbol "DIS"
        System.out.println(capGain);                  // -$100

        System.out.println("\n\nBuy 100 shares @ $20 each.");
        System.out.println("Buy 20 shares @ $24 each.");
        System.out.println("Buy 200 shares @ $36 each.");

        myStocks.buy("DEFAULT", 100, 20); // Use "DEFAULT" as the symbol
        myStocks.buy("DEFAULT", 20, 24);  // Use "DEFAULT" as the symbol
        myStocks.buy("DEFAULT", 200, 36); // Use "DEFAULT" as the symbol

        System.out.print("\n\nSell 10 shares @ $65 each at a gain (loss) of $");
        capGain = myStocks.sell("DEFAULT", 10, 65);    // Use "DEFAULT" as the symbol
        System.out.println(capGain);                  // $450

        System.out.print("\nSell 150 shares @ $65 each at a gain (loss) of $");
        capGain = myStocks.sell("DEFAULT", 150, 30);   // Use "DEFAULT" as the symbol
        System.out.println(capGain);                  // $780

        System.out.println("\n\nDone.");
    }
}
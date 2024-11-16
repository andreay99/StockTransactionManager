/*
   A driver that demonstrates the class MyStocks.

 */
public class Driver2
{
	public static void main(String[] args)
	{
		MyStocks myStocks = new MyStocks();

		myStocks.buy("DIS", 20, 45);
		myStocks.buy("DIS", 20, 75);

		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("DIS", 30, 65) + "\n");  // $300

		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("DIS", 10, 65) + "\n");  // -$100

		myStocks.buy("DIS", 100, 20);
		myStocks.buy("DIS", 20, 24);
		myStocks.buy("DIS", 200, 36);

		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("DIS", 10, 65) + "\n");  //  $450

		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("DIS", 150, 30) + "\n"); //  $780

		myStocks.buy("NKE", 5, 60);
		myStocks.buy("NKE", 5, 70);
		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("NKE", 4, 30) + "\n"); //  -$120
		System.out.println("This sale has a gain (loss) of $" +
				myStocks.sell("NKE", 2, 30) + "\n"); //  -$70

		System.out.println("\n\nDone.");
	}  // end main
}  // end Driver

/*
Buy 20 shares of DIS @ $45.0 each.
Buy 20 shares of DIS @ $75.0 each.
Sell 30 shares of DIS @ $65.0 each.
This sale has a gain (loss) of $300.0

Sell 10 shares of DIS @ $65.0 each.
This sale has a gain (loss) of $-100.0

Buy 100 shares of DIS @ $20.0 each.
Buy 20 shares of DIS @ $24.0 each.
Buy 200 shares of DIS @ $36.0 each.
Sell 10 shares of DIS @ $65.0 each.
This sale has a gain (loss) of $450.0

Sell 150 shares of DIS @ $30.0 each.
This sale has a gain (loss) of $780.0

Buy 5 shares of NKE @ $60.0 each.
Buy 5 shares of NKE @ $70.0 each.
Sell 4 shares of NKE @ $30.0 each.
This sale has a gain (loss) of $-120.0

Sell 2 shares of NKE @ $30.0 each.
This sale has a gain (loss) of $-70.0



Done.
Press any key to continue . . .*/
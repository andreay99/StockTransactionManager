StockTransactionManager

A Java-based stock management application that allows users to track and manage stock transactions, calculate capital gains/losses, and view detailed portfolio insights through an interactive GUI.

Features

Core Features

	•	Buy and Sell Stocks:
	•	Add stock purchases with a specified symbol, number of shares, and cost per share.
	•	Process stock sales using FIFO (First-In, First-Out) logic to calculate capital gains or losses.
	•	View Portfolio:
	•	Displays all stock symbols with the total number of shares held.
	•	Transaction Log:
	•	Tracks and displays all buy/sell transactions for easy reference.
	•	Save and Load Portfolio:
	•	Save the current portfolio to a file for future use.
	•	Load a previously saved portfolio to restore transactions and stock holdings.
	•	Export Portfolio:
	•	Export the current portfolio to a .csv file for easy sharing or analysis.

 Enhancements

	•	Number Formatting:
	•	Large numbers (e.g., share prices, gains/losses) are formatted with commas and two decimal places for better readability.
	•	Example: $5,000,000.00 instead of 5000000.0.
	•	Input Validation:
	•	Prevents invalid inputs, such as non-numeric values for shares and price, and provides user-friendly error messages.
	•	Modern GUI Layout:
	•	Neatly organized GUI with:
	•	A labeled input panel for transaction details.
	•	Action buttons for various operations.
	•	A log area for transaction history and results.
	•	Styling:
	•	Custom fonts and colors for a professional and user-friendly interface.


 Technologies Used

	•	Language: Java
	•	Libraries:
	•	Swing: For the graphical user interface (GUI).
	•	Java I/O: For saving, loading, and exporting portfolio data.

 How to Use

	1.	Run the Application:
	•	Compile and run the program using:
 
 javac *.java
java StockTransactionGUI


	2.	Perform Transactions:
	•	Enter the stock symbol, number of shares, and price in the input fields.
	•	Click Buy to purchase shares or Sell to sell them.
	3.	View Portfolio:
	•	Click View Portfolio to see the total shares for each stock symbol.
	4.	Save/Load Portfolio:
	•	Use Save Portfolio to store your data in a file.
	•	Use Load Portfolio to restore your saved portfolio.
	5.	Export Portfolio:
	•	Click Export Portfolio to save your portfolio to a .csv file.

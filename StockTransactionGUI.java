import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockTransactionGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private StockLedger ledger; 
    private JTextField symbolField, sharesField, priceField;
    private JTextArea outputArea;
    private List<String> transactionLog;

    public StockTransactionGUI() {
        ledger = new StockLedger();
        transactionLog = new ArrayList<>();

        // Set up the frame
        setTitle("Stock Transaction Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns, spacing
        inputPanel.setBorder(BorderFactory.createTitledBorder("Transaction Details"));
        
        inputPanel.add(new JLabel("Stock Symbol:"));
        symbolField = new JTextField();
        inputPanel.add(symbolField);

        inputPanel.add(new JLabel("Number of Shares:"));
        sharesField = new JTextField();
        inputPanel.add(sharesField);

        inputPanel.add(new JLabel("Price per Share:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Flow layout for buttons
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        JButton buyButton = new JButton("Buy");
        JButton sellButton = new JButton("Sell");
        JButton portfolioButton = new JButton("View Portfolio");
        JButton historyButton = new JButton("View History");
        JButton saveButton = new JButton("Save Portfolio");
        JButton loadButton = new JButton("Load Portfolio");
        JButton exportButton = new JButton("Export Portfolio");

        buttonPanel.add(buyButton);
        buttonPanel.add(sellButton);
        buttonPanel.add(portfolioButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exportButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction Log"));

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Button listeners
        buyButton.addActionListener(e -> handleBuy());
        sellButton.addActionListener(e -> handleSell());
        portfolioButton.addActionListener(e -> handleViewPortfolio());
        historyButton.addActionListener(e -> handleViewHistory());
        saveButton.addActionListener(e -> savePortfolio());
        loadButton.addActionListener(e -> loadPortfolio());
        exportButton.addActionListener(e -> exportPortfolio());
    }

    private void handleBuy() {
        try {
            String symbol = symbolField.getText();
            int shares = Integer.parseInt(sharesField.getText());
            double costPerShare = Double.parseDouble(priceField.getText());

            // Format cost per share
            String formattedCost = String.format("%,.2f", costPerShare);

            ledger.buy(symbol, shares, costPerShare);

            String transaction = "Bought " + shares + " shares of " + symbol + " @ $" + formattedCost + " each.";
            transactionLog.add(transaction);
            outputArea.append(transaction + "\n");

            clearFields();
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input! Please enter numeric values for shares and price.\n");
        }
    }
    
    private void handleSell() {
        try {
            String symbol = symbolField.getText();
            int shares = Integer.parseInt(sharesField.getText());
            double salePrice = Double.parseDouble(priceField.getText());

            double gain = ledger.sell(symbol, shares, salePrice);

            // Format numbers for better readability
            String formattedSalePrice = String.format("%,.2f", salePrice);
            String formattedGain = String.format("%,.2f", gain);

            String transaction = "Sold " + shares + " shares of " + symbol + " @ $" + formattedSalePrice + " each. Gain (loss): $" + formattedGain;
            transactionLog.add(transaction);
            outputArea.append(transaction + "\n");

            clearFields();
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input! Please enter numeric values for shares and price.\n");
        }
    }
    
    private void handleViewPortfolio() {
        outputArea.append("Current Portfolio:\n");
        for (String symbol : ledger.getAllSymbols()) {
            int totalShares = ledger.getTotalShares(symbol);
            outputArea.append(symbol + ": " + totalShares + " shares\n");
        }
    }

    private void handleViewHistory() {
        outputArea.append("Transaction History:\n");
        for (String log : transactionLog) {
            outputArea.append(log + "\n");
        }
    }

    private void savePortfolio() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("portfolio.dat"))) {
            oos.writeObject(ledger);
            outputArea.append("Portfolio saved successfully.\n");
        } catch (Exception ex) {
            outputArea.append("Error saving portfolio: " + ex.getMessage() + "\n");
        }
    }

    private void loadPortfolio() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("portfolio.dat"))) {
            ledger = (StockLedger) ois.readObject();
            outputArea.append("Portfolio loaded successfully.\n");
        } catch (Exception ex) {
            outputArea.append("Error loading portfolio: " + ex.getMessage() + "\n");
        }
    }

    private void exportPortfolio() {
        try (PrintWriter writer = new PrintWriter(new File("portfolio.csv"))) {
            writer.println("Symbol,Shares");
            for (String symbol : ledger.getAllSymbols()) {
                int totalShares = ledger.getTotalShares(symbol);
                writer.println(symbol + "," + totalShares);
            }
            outputArea.append("Portfolio exported to portfolio.csv\n");
        } catch (Exception ex) {
            outputArea.append("Error exporting portfolio: " + ex.getMessage() + "\n");
        }
    }

    private void clearFields() {
        symbolField.setText("");
        sharesField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StockTransactionGUI gui = new StockTransactionGUI();
            gui.setVisible(true);
        });
    }
}
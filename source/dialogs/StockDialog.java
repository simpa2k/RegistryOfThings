package dialogs;

import valuables.Stock;

import javax.swing.*;

public class StockDialog extends ValuableDialog {

	private JTextField amountInput;
	private JTextField sharePriceInput;

	public StockDialog() {

		JLabel amount = new JLabel("Antal:");
		getMiddleRow().add(amount);

		amountInput = new JTextField(10);
		getMiddleRow().add(amountInput);

		JLabel sharePrice = new JLabel("Kurs:");
		getBottomRow().add(sharePrice);

		sharePriceInput = new JTextField(10);
		getBottomRow().add(sharePriceInput);


	}

	@Override
	public Stock getNewValuable() {
		//det här bör göras där dialogen skapas, behövs det här överhuvudtaget? Det propagerar väl till controllern?
		try {
			
			validateNameInput();

			int numericAmount = Integer.parseInt(amountInput.getText());
			double numericSharePrice = Double.parseDouble(sharePriceInput.getText());

			return new Stock(getNameInputText(), numericAmount, numericSharePrice);

		} catch(IllegalArgumentException e) {

			return null; //Throwa nytt exception här istället?

		}

	}

}
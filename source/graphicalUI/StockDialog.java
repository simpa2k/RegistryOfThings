package graphicalUI;

import valuables.Stock;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class StockDialog extends ValuableDialog {

	JTextField amountInput;
	JTextField sharePriceInput;

	public StockDialog() {

		setColumnAndRow(0, 1);
		JLabel amount = new JLabel("Antal:");
		add(amount, c);

		setColumnAndRow(1, 1);
		amountInput = new JTextField(10);
		add(amountInput, c);

		setColumnAndRow(0, 2);
		JLabel sharePrice = new JLabel("Kurs:");
		add(sharePrice, c);

		setColumnAndRow(1, 2);
		sharePriceInput = new JTextField(10);
		add(sharePriceInput, c);


	}

	@Override
	public Stock getNewValuable() {

		try {
			
			validateNameInput();

			int numericAmount = Integer.parseInt(amountInput.getText());
			double numericSharePrice = Double.parseDouble(sharePriceInput.getText());

			return new Stock(nameInput.getText(), numericAmount, numericSharePrice);

		} catch(IllegalArgumentException e) {

			return null; //Throwa nytt exception här istället?

		}

	}

}
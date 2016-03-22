package graphicalUI;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class StockDialog extends JPanel {

	GridBagConstraints c = new GridBagConstraints();

	public StockDialog() {

		setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		JTextField nameInput = new JTextField(10);
		add(nameInput, c);

		setColumnAndRow(0, 1);
		JLabel amount = new JLabel("Antal:");
		add(amount, c);

		setColumnAndRow(1, 1);
		JTextField amountInput = new JTextField(10);
		add(amountInput, c);

		setColumnAndRow(0, 2);
		JLabel sharePrice = new JLabel("Kurs:");
		add(sharePrice, c);

		setColumnAndRow(1, 2);
		JTextField sharePriceInput = new JTextField(10);
		add(sharePriceInput, c);


	}

	private void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

}
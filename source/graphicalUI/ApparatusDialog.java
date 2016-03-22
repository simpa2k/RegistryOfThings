package graphicalUI;

import valuables.Apparatus;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ApparatusDialog extends ValuableDialog {

	JTextField nameInput;
	JTextField purchasePriceInput;
	JTextField wearInput;

	public ApparatusDialog() {

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		nameInput = new JTextField(10);
		add(nameInput, c);

		setColumnAndRow(0, 1);
		JLabel price = new JLabel("Pris:");
		add(price, c);

		setColumnAndRow(1, 1);
		purchasePriceInput = new JTextField(10);
		add(purchasePriceInput, c);

		setColumnAndRow(0, 2);
		JLabel wear = new JLabel("Slitage:");
		add(wear, c);

		setColumnAndRow(1, 2);
		wearInput = new JTextField(10);
		add(wearInput, c);

	}

	@Override
	public Apparatus getNewValuable() {

		try {
		
			double numericPurchasePrice = Double.parseDouble(purchasePriceInput.getText());
			int numericWear = Integer.parseInt(wearInput.getText());

			return new Apparatus(nameInput.getText(), numericPurchasePrice, numericWear);

		} catch(IllegalArgumentException e) {

			return null;

		}

	}

}
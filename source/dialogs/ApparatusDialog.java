package dialogs;

import valuables.Apparatus;

import javax.swing.*;

public class ApparatusDialog extends ValuableDialog {
	
	private JTextField purchasePriceInput;
	private JTextField wearInput;

	public ApparatusDialog() {

		JLabel price = new JLabel("Price:");
		getMiddleRow().add(price);

		purchasePriceInput = new JTextField(10);
		getMiddleRow().add(purchasePriceInput);

		JLabel wear = new JLabel("Wear:");
		getBottomRow().add(wear);

		wearInput = new JTextField(10);
		getBottomRow().add(wearInput);

	}

	@Override
	public Apparatus getNewValuable() {
		
		validateNameInput();

		double numericPurchasePrice = Double.parseDouble(purchasePriceInput.getText());
		int numericWear = Integer.parseInt(wearInput.getText());

		return new Apparatus(getNameInputText(), numericPurchasePrice, numericWear);

	}

}
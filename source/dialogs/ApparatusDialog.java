package dialogs;

import valuables.Apparatus;

import javax.swing.*;

public class ApparatusDialog extends ValuableDialog {
	
	private JTextField purchasePriceInput;
	private JTextField wearInput;

	public ApparatusDialog() {

		JLabel price = new JLabel("Pris:");
		getMiddleRow().add(price);

		purchasePriceInput = new JTextField(10);
		getMiddleRow().add(purchasePriceInput);

		JLabel wear = new JLabel("Slitage:");
		getBottomRow().add(wear);

		wearInput = new JTextField(10);
		getBottomRow().add(wearInput);

	}

	@Override
	public Apparatus getNewValuable() {
		//det här bör göras där dialogen skapas, behövs det här överhuvudtaget? Det propagerar väl till controllern?
		try {
		
			validateNameInput();

			double numericPurchasePrice = Double.parseDouble(purchasePriceInput.getText());
			int numericWear = Integer.parseInt(wearInput.getText());

			return new Apparatus(getNameInputText(), numericPurchasePrice, numericWear);

		} catch(IllegalArgumentException e) {

			return null; //Throwa nytt exception här istället?

		}

	}

}
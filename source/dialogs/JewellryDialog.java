package dialogs;

import valuables.Jewellry;

import javax.swing.*;
import java.awt.event.*;

public class JewellryDialog extends ValuableDialog implements ItemListener {
	
	private JTextField numberOfGems;
	private boolean goldBoxChecked = false;

	public JewellryDialog() {

		JLabel gems = new JLabel("Gems:");
		getMiddleRow().add(gems);

		numberOfGems = new JTextField(10);
		getMiddleRow().add(numberOfGems);

		JLabel gold = new JLabel("Gold:");
		getBottomRow().add(gold);

		JCheckBox isGold = new JCheckBox();
		isGold.addItemListener(this);
		getBottomRow().add(isGold);

	}

	@Override
	public Jewellry getNewValuable() {
		
		validateNameInput();

		int numericNumberOfGems = Integer.parseInt(numberOfGems.getText());
		return new Jewellry(getNameInputText(), numericNumberOfGems, goldBoxChecked);

	}

	@Override 
	public void itemStateChanged(ItemEvent e) {

		goldBoxChecked = !goldBoxChecked;

	}

}
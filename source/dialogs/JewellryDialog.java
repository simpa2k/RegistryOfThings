package dialogs;

import valuables.Jewellry;

import javax.swing.*;
import java.awt.event.*;

public class JewellryDialog extends ValuableDialog implements ItemListener {
	
	JTextField numberOfGems;
	boolean goldBoxChecked = false;

	public JewellryDialog() {

		JLabel gems = new JLabel("Stenar:");
		getMiddleRow().add(gems);

		numberOfGems = new JTextField(10);
		getMiddleRow().add(numberOfGems);

		JLabel gold = new JLabel("Av guld:");
		getBottomRow().add(gold);

		JCheckBox isGold = new JCheckBox();
		isGold.addItemListener(this);
		getBottomRow().add(isGold);

	}

	@Override
	public Jewellry getNewValuable() {
		//det här bör göras där dialogen skapas, behövs det här överhuvudtaget? Det propagerar väl till controllern?
		try {
		
			validateNameInput();

			int numericNumberOfGems = Integer.parseInt(numberOfGems.getText());
			return new Jewellry(getNameInputText(), numericNumberOfGems, goldBoxChecked);

		} catch(IllegalArgumentException e) {

			return null; //Throwa nytt exception här istället?

		}

	}

	@Override 
	public void itemStateChanged(ItemEvent e) {

		goldBoxChecked = !goldBoxChecked;

	}

}
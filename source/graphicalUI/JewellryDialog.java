package graphicalUI;

import valuables.Jewellry;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
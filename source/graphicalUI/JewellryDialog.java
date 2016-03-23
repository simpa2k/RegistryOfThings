package graphicalUI;

import valuables.Jewellry;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JewellryDialog extends ValuableDialog implements ItemListener {

	JTextField nameInput;
	JTextField numberOfGems;
	boolean goldBoxChecked = false;

	public JewellryDialog() {

		setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		nameInput = new JTextField(10);
		add(nameInput, c);

		setColumnAndRow(0, 1);
		JLabel gems = new JLabel("Stenar:");
		add(gems, c);

		setColumnAndRow(1, 1);
		numberOfGems = new JTextField(10);
		add(numberOfGems, c);

		setColumnAndRow(0, 2);
		JLabel gold = new JLabel("Av guld:");
		add(gold, c);

		setColumnAndRow(1, 2);
		JCheckBox isGold = new JCheckBox();
		isGold.addItemListener(this);
		add(isGold, c);

	}

	@Override
	public Jewellry getNewValuable() {

		try {
		
			int numericNumberOfGems = Integer.parseInt(numberOfGems.getText());
			return new Jewellry(nameInput.getText(), numericNumberOfGems, goldBoxChecked);

		} catch(IllegalArgumentException e) {

			return null; //Throwa nytt exception här istället?

		}

	}

	@Override 
	public void itemStateChanged(ItemEvent e) {

		goldBoxChecked = !goldBoxChecked;

	}

}
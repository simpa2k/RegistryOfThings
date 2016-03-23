package graphicalUI;

import valuables.Valuable;

import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public abstract class ValuableDialog extends JPanel {

	GridBagConstraints c; 
	JTextField nameInput;

	public ValuableDialog() {

		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		nameInput = new JTextField(10);
		add(nameInput, c);

	}

	protected void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

	protected void validateNameInput() {

		if(nameInput.getText().matches("\\d+")) {

			throw new IllegalArgumentException();

		}

	}

	public abstract Valuable getNewValuable();

}
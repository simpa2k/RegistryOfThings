package graphicalUI;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class JewellryDialog extends JPanel {

	GridBagConstraints c = new GridBagConstraints();

	public JewellryDialog() {

		setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		JTextField nameInput = new JTextField(10);
		add(nameInput, c);

		setColumnAndRow(0, 1);
		JLabel gems = new JLabel("Stenar:");
		add(gems, c);

		setColumnAndRow(1, 1);
		JTextField numberOfGems = new JTextField(10);
		add(numberOfGems, c);

		setColumnAndRow(0, 2);
		JLabel gold = new JLabel("Guld:");
		add(gold, c);

		setColumnAndRow(1, 2);
		JCheckBox isGold = new JCheckBox();
		add(isGold, c);


	}

	private void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

}
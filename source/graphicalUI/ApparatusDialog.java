package graphicalUI;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ApparatusDialog extends JPanel {

	GridBagConstraints c = new GridBagConstraints();

	public ApparatusDialog() {

		setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		JLabel name = new JLabel("Namn:");
		add(name, c);

		setColumnAndRow(1, 0);
		JTextField nameInput = new JTextField(10);
		add(nameInput, c);

		setColumnAndRow(0, 1);
		JLabel price = new JLabel("Pris:");
		add(price, c);

		setColumnAndRow(1, 1);
		JTextField priceInput = new JTextField(10);
		add(priceInput, c);

		setColumnAndRow(0, 2);
		JLabel wear = new JLabel("Slitage:");
		add(wear, c);

		setColumnAndRow(1, 2);
		JTextField wearInput = new JTextField(10);
		add(wearInput, c);


	}

	private void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

}
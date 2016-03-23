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

	public ValuableDialog() {

		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

	}

	protected void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

	public abstract Valuable getNewValuable();

}
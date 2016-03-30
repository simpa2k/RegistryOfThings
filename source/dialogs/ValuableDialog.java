package dialogs;

import valuables.Valuable;

import java.util.HashMap;
import javax.swing.*;

public abstract class ValuableDialog extends JPanel {

	private JTextField nameInput;

	private JPanel topRow;
	private JPanel middleRow;
	private JPanel bottomRow;

	public ValuableDialog() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		topRow = new JPanel();
		middleRow = new JPanel();
		bottomRow = new JPanel();

		add(topRow);
		add(middleRow);
		add(bottomRow);

		JLabel name = new JLabel("Namn:");
		topRow.add(name);

		nameInput = new JTextField(10);
		topRow.add(nameInput);

	}

	protected JPanel getMiddleRow() {

		return middleRow;

	}

	protected JPanel getBottomRow() {

		return bottomRow;

	}

	protected void validateNameInput() {

		if(nameInput.getText().matches("\\d+")) {

			throw new IllegalArgumentException();

		}

	}

	protected String getNameInputText() {

		return nameInput.getText();

	}

	public abstract Valuable getNewValuable();

}
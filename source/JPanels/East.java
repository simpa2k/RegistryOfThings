package JPanels;

import mvc.RegistryView;

import javax.swing.*;
import java.awt.*;

public class East extends JPanel {

	private RegistryView parentFrame;

	public East(RegistryView parentFrame) {

		this.parentFrame = parentFrame;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel sorting = new JLabel("Sortering");
		add(sorting);

		JRadioButton sortByName = new JRadioButton("Namn");
		add(sortByName);
		sortByName.addActionListener(event -> parentFrame.getController().sortValuablesByName());
		sortByName.setSelected(true);

		JRadioButton sortByValue = new JRadioButton("Värde");
		add(sortByValue);
		sortByValue.addActionListener(event -> parentFrame.getController().sortValuablesByValue());

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(sortByName);
		buttonGroup.add(sortByValue);

	}
}
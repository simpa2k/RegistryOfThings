package JPanels;

import mvc.RegistryView;
import compare.*;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

public class East extends JPanel {

	private RegistryView parentFrame;

	JRadioButton sortByName;

	public East(RegistryView parentFrame) {

		this.parentFrame = parentFrame;
		
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel sorting = new JLabel("Sortering");
		panel.add(sorting);

		sortByName = new JRadioButton("Namn");
		panel.add(sortByName);
		sortByName.addActionListener(event -> parentFrame.getController().showValuables());
		sortByName.setSelected(true);

		JRadioButton sortByValue = new JRadioButton("Värde");
		panel.add(sortByValue);
		sortByValue.addActionListener(event -> parentFrame.getController().showValuables());

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(sortByName);
		buttonGroup.add(sortByValue);

		add(panel, BorderLayout.SOUTH);

	}

	public Comparator getSelectedComparator() {

		return sortByName.isSelected() ? new NameComparator() : new ValueComparator();

	}
}
package mvc;

import compare.*;
import valuables.Valuable;

import java.util.Comparator;
import javax.swing.*;
import java.awt.*;

public class SortingPanel extends JPanel {

	private JRadioButton sortByName;

	public SortingPanel(RegistryView parentFrame) {

		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel sorting = new JLabel("Sorting");
		panel.add(sorting);

		sortByName = new JRadioButton("Name");
		panel.add(sortByName);
		sortByName.addActionListener(event -> parentFrame.showValuables(getSelectedComparator()));
		sortByName.setSelected(true);

		JRadioButton sortByValue = new JRadioButton("Value");
		panel.add(sortByValue);
		sortByValue.addActionListener(event -> parentFrame.showValuables(getSelectedComparator()));

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(sortByName);
		buttonGroup.add(sortByValue);

		add(panel, BorderLayout.SOUTH);

	}

	protected Comparator<Valuable> getSelectedComparator() {

		return sortByName.isSelected() ? new NameComparator() : new ValueComparator();

	}

}
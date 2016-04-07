package mvc;

import valuables.*;
import compare.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.Comparator;

public class RegistryView extends JFrame {

	private JTextArea textArea;
	private SortingPanel sortingPanel;

	private RegistryController controller;

	public RegistryView() {

		controller = new RegistryController(this);
		this.controller = controller;

		sortingPanel = new SortingPanel();
		ControlPanel controlPanel = new ControlPanel();

		JLabel heading = new JLabel("Valuables");
		heading.setHorizontalAlignment(JLabel.CENTER);
		add(heading, BorderLayout. NORTH);

		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane, BorderLayout.CENTER);

		add(sortingPanel, BorderLayout.EAST);
		add(controlPanel, BorderLayout.SOUTH);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	protected void setText(String text) {

		textArea.setText(text);

	}

	private Comparator getSelectedComparator() {

			return sortingPanel.sortByName.isSelected() ? new NameComparator() : new ValueComparator();

		}

	private void showValuables() {

		controller.showValuables(getSelectedComparator());		

	}

	private class SortingPanel extends JPanel {

		private JRadioButton sortByName;

		public SortingPanel() {
			
			setLayout(new BorderLayout());

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JLabel sorting = new JLabel("Sorting");
			panel.add(sorting);

			sortByName = new JRadioButton("Name");
			panel.add(sortByName);
			sortByName.addActionListener(event -> showValuables());
			sortByName.setSelected(true);

			JRadioButton sortByValue = new JRadioButton("Value");
			panel.add(sortByValue);
			sortByValue.addActionListener(event -> showValuables());

			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(sortByName);
			buttonGroup.add(sortByValue);

			add(panel, BorderLayout.SOUTH);

		}

	}

	private class ControlPanel extends JPanel {

		public ControlPanel() {

			JLabel newValuable = new JLabel("New:");
			add(newValuable);

			String[] valuableCategories = {"Jewellry", "Stock", "Apparatus"};
			JComboBox comboBox = new JComboBox(valuableCategories);
			comboBox.addActionListener( event -> controller.displayValuableDialog(this, (String) comboBox.getSelectedItem()) );
			add(comboBox);

			JButton show = new JButton("Show");
			show.addActionListener(event -> showValuables());
			add(show);

			JButton crash = new JButton("Stock market crash");
			crash.addActionListener( event -> controller.setSharePricesToZero(getSelectedComparator()) );
			add(crash);

		}

	}

}
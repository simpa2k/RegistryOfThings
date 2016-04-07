package mvc;

import valuables.*;
import compare.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.Comparator;

public class RegistryView extends JFrame {

	private JTextArea textArea;

	private RegistryModel model;
	private RegistryController controller;

	private SortingPanel sortingPanel;

	public RegistryView() {

		model = new RegistryModel();
		this.model = model;

		controller = new RegistryController(model, this);
		this.controller = controller;

		sortingPanel = new SortingPanel();
		ControlPanel controlPanel = new ControlPanel();

		JLabel heading = new JLabel("Värdesaker");
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

	public void setText(String text) {

		textArea.setText(text);

	}

	class SortingPanel extends JPanel {

		private JRadioButton sortByName;

		public SortingPanel() {
			
			setLayout(new BorderLayout());

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JLabel sorting = new JLabel("Sorting");
			panel.add(sorting);

			sortByName = new JRadioButton("Name");
			panel.add(sortByName);
			sortByName.addActionListener(new ShowValuablesListener());
			sortByName.setSelected(true);

			JRadioButton sortByValue = new JRadioButton("Value");
			panel.add(sortByValue);
			sortByValue.addActionListener(new ShowValuablesListener());

			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(sortByName);
			buttonGroup.add(sortByValue);

			add(panel, BorderLayout.SOUTH);

		}

		protected Comparator getSelectedComparator() {

			return sortByName.isSelected() ? new NameComparator() : new ValueComparator();

		}

	}

	class ControlPanel extends JPanel {

		public ControlPanel() {

			JLabel newValuable = new JLabel("New:");
			add(newValuable);

			String[] valuableCategories = {"Jewellry", "Stock", "Apparatus"};
			JComboBox comboBox = new JComboBox(valuableCategories);
			comboBox.addActionListener( event -> controller.displayValuableDialog(this, (String) comboBox.getSelectedItem()));
			add(comboBox);

			JButton show = new JButton("Show");
			show.addActionListener(new ShowValuablesListener());
			add(show);

			JButton crash = new JButton("Stock market crash");
			crash.addActionListener(event -> controller.setSharePricesToZero(sortingPanel.getSelectedComparator()));
			add(crash);

		}

	}

	class ShowValuablesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			controller.showValuables(sortingPanel.getSelectedComparator());

		}

	}

}
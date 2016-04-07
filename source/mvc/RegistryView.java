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

		sortingPanel = new SortingPanel(this);
		ControlPanel controlPanel = new ControlPanel(this);

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

	protected void showValuables(Comparator comparator) {

		controller.showValuables(comparator);		

	}

	protected void showValuables() {

		controller.showValuables(sortingPanel.getSelectedComparator());		

	}

	protected void displayValuableDialog(JPanel eventFiringPanel, String selectedItem) {

		controller.displayValuableDialog(eventFiringPanel, selectedItem);

	}

	protected void setSharePricesToZero() {

		controller.setSharePricesToZero(sortingPanel.getSelectedComparator());

	}

}
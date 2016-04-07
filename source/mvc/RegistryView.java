package mvc;

import valuables.*;
import jPanels.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.Comparator;

public class RegistryView extends JFrame {

	private JTextArea textArea;

	private RegistryModel model;
	private RegistryController controller;

	private East eastPanel;

	public RegistryView() {

		model = new RegistryModel();
		this.model = model;
		model.setView(this);

		controller = new RegistryController(model);
		this.controller = controller;

		eastPanel = new East(this);
		South southPanel = new South(this);

		JLabel heading = new JLabel("Värdesaker");
		heading.setHorizontalAlignment(JLabel.CENTER);
		add(heading, BorderLayout. NORTH);

		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane, BorderLayout.CENTER);

		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public RegistryController getController() {

		return controller;

	}

	public void update() {

		Comparator valuableComparator = eastPanel.getSelectedComparator();
		String valuables = model.getValuables(valuableComparator);

		textArea.setText(valuables);

	}

}
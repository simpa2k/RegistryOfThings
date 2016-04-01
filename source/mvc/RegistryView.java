package mvc;

import valuables.*;
import JPanels.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.Comparator;

public class RegistryView extends JFrame {

	JTextArea textArea;

	RegistryModel model;
	RegistryController controller;

	East eastPanel;

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

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				RegistryView view = new RegistryView();

				view.setVisible(true);

			}

		});

	}

}
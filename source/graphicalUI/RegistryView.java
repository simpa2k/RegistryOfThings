package graphicalUI;

import registry.*;
import valuables.*;
import JPanels.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.*;

public class RegistryView extends JFrame {

	Center centerPanel;

	RegistryModel model;
	RegistryController controller;

	public RegistryView() {

		model = new RegistryModel();
		this.model = model;
		model.setView(this);

		controller = new RegistryController(model);
		this.controller = controller;

		North northPanel = new North();
		centerPanel = new Center();
		East eastPanel = new East(this);
		South southPanel = new South(this);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();

	}

	public RegistryController getController() {

		return controller;

	}

	public void update() {

		centerPanel.updateTextArea(model.getValuables());

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
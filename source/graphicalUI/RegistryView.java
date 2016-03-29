package graphicalUI;

import registry.*;
import valuables.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class RegistryView extends JFrame {

	MainContentPane mainContentPane;

	RegistryModel model;
	RegistryController controller;

	public RegistryView() {

		model = new RegistryModel();
		this.model = model;
		model.setView(this);

		controller = new RegistryController(model);
		this.controller = controller;

		mainContentPane = new MainContentPane(this);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setContentPane(mainContentPane);

		pack();

	}

	public RegistryController getController() {

		return controller;

	}

	public void update() {

		mainContentPane.updateTextArea(model.getValuables());

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
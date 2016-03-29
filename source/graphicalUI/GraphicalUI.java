package graphicalUI;

import registry.*;
import mvc.*;
import valuables.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class GraphicalUI extends JFrame implements Observer {

	MainContentPane mainContentPane;

	RegistryModel model;
	RegistryController controller;

	public GraphicalUI() {

		model = new RegistryModel();
		this.model = model;
		model.registerObserver(this);

		controller = new RegistryController(model);
		this.controller = controller;

		mainContentPane = new MainContentPane(this);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(mainContentPane);

		pack();

	}

	public RegistryController getController() {

		return controller;

	}

	@Override
	public void update() {

		mainContentPane.updateTextArea(model.getValuables());

	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				GraphicalUI gUI = new GraphicalUI();

				gUI.setVisible(true);

			}

		});

	}

}
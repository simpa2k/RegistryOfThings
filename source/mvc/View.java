package mvc;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class View {

	private Model model;
	private Controller controller;

	public View(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;

		model.registerView(this);

	}

	protected Model getModel() {

		return model;

	}

	public abstract void update();

	public void handleEvent(ActionEvent event, JPanel eventFiringPanel) {

		controller.handleEvent(event, eventFiringPanel);

	}

}
package mvc;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class Controller {

	private Model model;

	public Controller(Model model) {

		this.model = model;

	}

	protected Model getModel() {

		return model;

	}

	public abstract void handleEvent(ActionEvent event, JPanel eventFiringPanel);

}
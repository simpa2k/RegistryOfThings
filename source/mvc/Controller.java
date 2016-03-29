package mvc;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class Controller {

	private Subject model;

	public Controller(Subject model) {

		this.model = model;

	}

	protected Subject getModel() {

		return model;

	}

	public abstract void handleEvent(ActionEvent event, JPanel eventFiringPanel);

}
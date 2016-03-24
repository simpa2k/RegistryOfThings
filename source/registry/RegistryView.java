package registry;

import mvc.*;
import graphicalUI.GraphicalUI;

public class RegistryView extends View {

	GraphicalUI graphicalUI = new GraphicalUI(this);

	public RegistryView(RegistryModel model, RegistryController controller) {

		super(model, controller);
		model.registerView(this);

	}

	private GraphicalUI getGraphicalUI() {

		return graphicalUI;

	}

	@Override
	public void update() {

		RegistryModel castedModel = (RegistryModel) getModel();

		graphicalUI.updateTextArea(castedModel.getValuables());

	}

	public static void main(String[] args) {

		RegistryModel model = new RegistryModel();
		RegistryController controller = new RegistryController(model);
		RegistryView view = new RegistryView(model, controller);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				view.getGraphicalUI().setVisible(true);

			}

		});

	}

}
package registry;

import mvc.*;
import graphicalUI.GraphicalUI;
import graphicalUI.MainContentPane;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class RegistryView extends View {

	private GraphicalUI graphicalUI;

	public RegistryView(RegistryModel model, RegistryController controller) {

		super(model, controller);
		graphicalUI = new GraphicalUI(this);

	}

	private GraphicalUI getGraphicalUI() {

		return graphicalUI;

	}

	@Override
	public void update() {

		RegistryModel castedModel = (RegistryModel) getModel();
		
		graphicalUI.updateTextArea(castedModel.getValuables());

	}

	/*public static void main(String[] args) {

		RegistryModel model = new RegistryModel();
		RegistryController controller = new RegistryController(model);
		RegistryView view = new RegistryView(model, controller);

		model.sortValuablesByNameWithoutUpdate();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				view.getGraphicalUI().setVisible(true);

			}

		});

	}*/

}
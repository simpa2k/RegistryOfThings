package registry;

import graphicalUI.*;
import valuables.*;
import mvc.*;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class RegistryController extends Controller {

	public RegistryController(RegistryModel model) {

		super(model);

	}

	private RegistryModel getTypeCastedModel() {

		//Type casting safe since constructor demands RegistryController
		return (RegistryModel) getModel();

	}

	private void getNewValuable(ValuableDialog valuableDialog) {

		Valuable newValuable = valuableDialog.getNewValuable();

		try {

			getTypeCastedModel().add(newValuable);

		} catch(IllegalArgumentException e) {

			JOptionPane.showMessageDialog(valuableDialog,
										  "Fel inmatning!",
										  "Fel!",
										  JOptionPane.ERROR_MESSAGE);

		}

	}

	private void displayValuableDialog(JPanel eventFiringPanel, ValuableDialog valuableDialog, String typOfValuable) {

		int okOrCancel = JOptionPane.showOptionDialog(eventFiringPanel,
									 				  valuableDialog, 
									 				  "Add " + typOfValuable, 
									 				  JOptionPane.OK_CANCEL_OPTION, 
							 		 				  JOptionPane.QUESTION_MESSAGE, 
									 				  null, null, null);

		if(okOrCancel == 0) {

			getNewValuable(valuableDialog);

		}

	}

	@Override
	public void handleEvent(ActionEvent event, JPanel eventFiringPanel) {

		if(event.getSource() instanceof JComboBox) {

			JComboBox valuableCategories = (JComboBox) event.getSource();
			String selectedItem = (String) valuableCategories.getSelectedItem();

			switch(selectedItem) {

				case "Jewellry":
					displayValuableDialog(eventFiringPanel, new JewellryDialog(), selectedItem);
					break;
				case "Stock":
					displayValuableDialog(eventFiringPanel, new StockDialog(), selectedItem);
					break;
				case "Apparatus":
					displayValuableDialog(eventFiringPanel, new ApparatusDialog(), selectedItem);
					break;

			}

		} else if(event.getSource() instanceof JButton) {

			switch(event.getActionCommand()) {

				case("Visa"):
					getModel().updateView();
					break;
				case("Börskrasch"):
					getTypeCastedModel().setSharePricesToZero();
					break;

			}

		} else if(event.getSource() instanceof JRadioButton) {

			switch(event.getActionCommand()) {

				case("Namn"):
					getTypeCastedModel().sortValuablesByName();
					break;
				case("Värde"):
					getTypeCastedModel().sortValuablesByValue();

			}

		}

	}

}
package registry;

import graphicalUI.*;
import valuables.*;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class RegistryController {

	RegistryModel model;

	public RegistryController(RegistryModel model) {

		this.model = model;

	}

	private void getNewValuable(ValuableDialog valuableDialog) {

		Valuable newValuable = valuableDialog.getNewValuable();

		try {

			model.add(newValuable);

		} catch(IllegalArgumentException e) {

			JOptionPane.showMessageDialog(valuableDialog,
										  "Fel inmatning!",
										  "Fel!",
										  JOptionPane.ERROR_MESSAGE);

		}

	}

	public ValuableDialog determineDialogToBeOpened(String typeOfValuable) {

		switch(typeOfValuable) {

			case "Jewellry":
				return new JewellryDialog();
			case "Stock":
				return new StockDialog();
			case "Apparatus":
				return new ApparatusDialog();
			default:
				return null;

		}
	}

	public void displayValuableDialog(JPanel eventFiringPanel, String typeOfValuable) {

		ValuableDialog valuableDialog = determineDialogToBeOpened(typeOfValuable);

		int okOrCancel = JOptionPane.showOptionDialog(eventFiringPanel,
									 				  valuableDialog, 
									 				  "Add " + typeOfValuable, 
									 				  JOptionPane.OK_CANCEL_OPTION, 
							 		 				  JOptionPane.QUESTION_MESSAGE, 
									 				  null, null, null);

		if(okOrCancel == 0) {

			getNewValuable(valuableDialog);

		}

	}

	public void sortValuablesByName() {

		model.sortValuablesByName();

	}

	public void sortValuablesByValue() {

		model.sortValuablesByValue();

	}

	public void showValuables() {

		model.updateView();

	}

	public void setSharePricesToZero() {

		model.setSharePricesToZero();

	}

}
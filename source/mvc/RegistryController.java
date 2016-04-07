package mvc;

import dialogs.*;
import valuables.*;
import compare.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.*;

import javax.swing.*;

public class RegistryController {

	private RegistryModel model;
	private RegistryView view;

	public RegistryController(RegistryView view) {

		this.model = new RegistryModel();
		this.view = view;

	}

	private void getNewValuable(ValuableDialog valuableDialog) {

		try {

			Valuable newValuable = valuableDialog.getNewValuable();
			model.add(newValuable);

		} catch(IllegalArgumentException e) {

			JOptionPane.showMessageDialog(valuableDialog,
										  "Invalid input!",
										  "Error",
										  JOptionPane.ERROR_MESSAGE);

		}

	}

	private ValuableDialog determineDialogToBeOpened(String typeOfValuable) {

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

		if(okOrCancel == JOptionPane.OK_OPTION) {

			getNewValuable(valuableDialog);

		}

	}
	
	public void showValuables(Comparator selectedComparator) {

		String valuables = model.getValuables(selectedComparator);

		view.setText(valuables);

	}

	public void setSharePricesToZero(Comparator selectedComparator) {

		model.setSharePricesToZero();
		showValuables(selectedComparator);

	}

}
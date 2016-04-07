package mvc;

import dialogs.*;
import valuables.*;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;

public class RegistryController {

	private RegistryModel model;

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
	
	public void showValuables() {

		model.updateView();

	}

	public void setSharePricesToZero() {

		model.setSharePricesToZero();

	}

}
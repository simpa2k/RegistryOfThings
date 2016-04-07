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

	public RegistryController(RegistryModel model, RegistryView view) {

		this.model = model;
		this.view = view;

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

	private String getValuables() {

		Comparator valuableComparator = view.getSelectedComparator();
		String valuables = model.getValuables(valuableComparator);

		return valuables;

	}
	
	public void showValuables(Comparator selectedComparator) {

		String valuables = model.getValuables(selectedComparator);

		view.setText(valuables);

	}

	public void setSharePricesToZero() {

		model.setSharePricesToZero();
		view.setText(getValuables());

	}

}
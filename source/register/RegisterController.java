package register;

import graphicalUI.*;
import valuables.*;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegisterController implements ActionListener {

	private ParentContentPane view;
	private RegisterModel model;

	public RegisterController(ParentContentPane view, RegisterModel model) {

		this.view = view;
		this.model = model;

	}

	private void getNewValuable(ValuableDialog valuableDialog) {

		Valuable newValuable = valuableDialog.getNewValuable();

		if(newValuable == null) {

			JOptionPane.showMessageDialog(valuableDialog,
										  "Fel inmatning!",
										  "Fel!",
										  JOptionPane.ERROR_MESSAGE);

		} else {

			model.update(newValuable);

		}

	}

	private void displayValuableDialog(ValuableDialog valuableDialog, String typOfValuable) {

		int okOrCancel = JOptionPane.showOptionDialog(view, 
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
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() instanceof JComboBox) {

			JComboBox valuableCategories = (JComboBox) event.getSource();
			String selectedItem = (String) valuableCategories.getSelectedItem();

			switch(selectedItem) {

				case "Jewellry":
					displayValuableDialog(new JewellryDialog(), selectedItem);
					break;
				case "Stock":
					displayValuableDialog(new StockDialog(), selectedItem);
					break;
				case "Apparatus":
					displayValuableDialog(new ApparatusDialog(), selectedItem);
					break;

			}

		} else if(event.getSource() instanceof JButton) {

			ArrayList<Valuable> valuables = model.getValuables();

			String valuableList = "";

			for(Valuable valuable : valuables) {

				valuableList += valuable + "\n";

			}

			view.update(valuableList);

		}

	}

}
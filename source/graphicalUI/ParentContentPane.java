package graphicalUI;

import register.*;
import valuables.*;

import java.util.ArrayList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ParentContentPane extends JPanel implements ActionListener {

	GridBagConstraints c = new GridBagConstraints();
	JFrame parentFrame;
	private RegisterModel registerModel = new RegisterModel();

	JTextArea textArea;

	public ParentContentPane(JFrame parentFrame) {

		setLayout(new GridBagLayout());
		this.parentFrame = parentFrame; 

		populateUpperRow();
		populateMiddleRow();
		populateBottomRow();

		setPreferredSize(new Dimension(500, 500));

	}

	private void setColumnAndRow(int x, int y) {

		c.gridx = x;
		c.gridy = y;

	}

	private void populateUpperRow() {

		setColumnAndRow(0, 0);
		JLabel heading = new JLabel("Värdesaker");
		add(heading, c);

	}


	private void addRadioButtons() {

		JPanel radioButtonContentPane = new JPanel();
		radioButtonContentPane.setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		JLabel sorting = new JLabel("Sortering");
		radioButtonContentPane.add(sorting);

		setColumnAndRow(0, 1);
		JRadioButton sortByName = new JRadioButton("Namn");
		radioButtonContentPane.add(sortByName, c);

		setColumnAndRow(0, 2);
		JRadioButton sortByValue = new JRadioButton("Värde");
		radioButtonContentPane.add(sortByValue, c);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(sortByName);
		buttonGroup.add(sortByValue);

		setColumnAndRow(1, 1);
		add(radioButtonContentPane, c);

	}

	private void populateMiddleRow() {

		setColumnAndRow(0, 1);
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		add(scrollPane, c);

		addRadioButtons();

	}

	private void populateBottomRow() {

		JPanel bottomRow = new JPanel();
		bottomRow.setLayout(new GridBagLayout());

		setColumnAndRow(0, 0);
		String[] valuableCategories = {"Jewellry", "Stock", "Apparatus"};
		JComboBox comboBox = new JComboBox(valuableCategories);
		comboBox.addActionListener(this);
		bottomRow.add(comboBox, c);

		setColumnAndRow(1, 0);
		JButton show = new JButton("Visa");
		show.addActionListener(this);
		bottomRow.add(show, c);

		setColumnAndRow(2, 0);
		JButton crash = new JButton("Börskrasch");
		bottomRow.add(crash, c);

		setColumnAndRow(0, 2);
		add(bottomRow, c);

	}

	private void getNewValuable(ValuableDialog valuableDialog) {

		Valuable newValuable = valuableDialog.getNewValuable();

		if(newValuable == null) {

			JOptionPane.showMessageDialog(valuableDialog,
										  "Fel inmatning!",
										  "Fel!",
										  JOptionPane.ERROR_MESSAGE);

		} else {

			System.out.println(newValuable);

		}

	}

	private void displayValuableDialog(ValuableDialog valuableDialog, String typOfValuable) {

		int okOrCancel = JOptionPane.showOptionDialog(this, 
									 valuableDialog, 
									 "Add " + typOfValuable, 
									 JOptionPane.OK_CANCEL_OPTION, 
									 JOptionPane.QUESTION_MESSAGE, 
									 null, null, null);

		if(okOrCancel == 0) {

			getNewValuable(valuableDialog);

		}

		/*JOptionPane newValuableOptionPane = new JOptionPane(valuableDialog, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);

		JDialog dialog = newValuableOptionPane.createDialog(this, "Add " + typOfValuable);
		dialog.show();

		if(newValuableOptionPane.getValue() == null) {

			return;

		} else {

			getNewValuable(valuableDialog);

		}*/
		

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

			ArrayList<Valuable> valuables = registerModel.getValuables();

			String valuableList = "";

			for(Valuable valuable : valuables) {

				valuableList += valuable + "\n";

			}

			textArea.setText(valuableList);

		}

	}

}
package graphicalUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ParentContentPane extends JPanel implements ActionListener {

	GridBagConstraints c = new GridBagConstraints();
	JFrame frame;

	public ParentContentPane(JFrame frame) {

		setLayout(new GridBagLayout());
		this.frame = frame; 

		populateUpperRow();
		populateMiddleRow();
		populateBottomRow();

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

		setColumnAndRow(1, 1);
		add(radioButtonContentPane, c);

	}

	private void populateMiddleRow() {

		setColumnAndRow(0, 1);
		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
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
		bottomRow.add(show, c);

		setColumnAndRow(2, 0);
		JButton crash = new JButton("Börskrasch");
		bottomRow.add(crash, c);

		setColumnAndRow(0, 2);
		add(bottomRow, c);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() instanceof JComboBox) {

			JComboBox valuableCategories = (JComboBox) event.getSource();
			String selectedItem = (String) valuableCategories.getSelectedItem();

			String str = (String)JOptionPane.showInputDialog(frame,
															 "test",
															  "Test Dialog",
															  JOptionPane.QUESTION_MESSAGE,
															  null,
															  null,
															  "");
		}

	}

}
package graphicalUI;

import registry.*;
import valuables.*;
import observer.*;

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

public class MainContentPane extends JPanel implements ActionListener {

	GridBagConstraints c = new GridBagConstraints();
	GraphicalUI parentFrame;

	JTextArea textArea;
	JRadioButton sortByName;
	JRadioButton sortByValue;

	public MainContentPane(GraphicalUI parentFrame) {

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
		sortByName = new JRadioButton("Namn");
		radioButtonContentPane.add(sortByName, c);
		sortByName.addActionListener(this);
		sortByName.setSelected(true);

		setColumnAndRow(0, 2);
		sortByValue = new JRadioButton("Värde");
		radioButtonContentPane.add(sortByValue, c);
		sortByValue.addActionListener(this);

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
		crash.addActionListener(this);
		bottomRow.add(crash, c);

		setColumnAndRow(0, 2);
		add(bottomRow, c);

	}

	public void updateTextArea(String text) {

		textArea.setText(text);

	}

	public JRadioButton getSelectedRadioButton() {

		return sortByName.isSelected() ? sortByName : sortByValue;

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		parentFrame.handleEvent(event, this);

	}

}
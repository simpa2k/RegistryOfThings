package mvc;

import javax.swing.*;

public class ControlPanel extends JPanel {

	public ControlPanel(RegistryView parentFrame) {

		JLabel newValuable = new JLabel("New:");
		add(newValuable);

		String[] valuableCategories = {"Jewellry", "Stock", "Apparatus"};
		JComboBox<String> comboBox = new JComboBox<>(valuableCategories);
		comboBox.addActionListener( event -> parentFrame.displayValuableDialog(this, (String) comboBox.getSelectedItem()) );
		add(comboBox);

		JButton show = new JButton("Show");
		show.addActionListener(event -> parentFrame.showValuables());
		add(show);

		JButton crash = new JButton("Stock market crash");
		crash.addActionListener(event -> parentFrame.setSharePricesToZero());
		add(crash);

	}

}
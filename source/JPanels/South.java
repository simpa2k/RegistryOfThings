package JPanels;

import mvc.RegistryView;
import javax.swing.*;

public class South extends JPanel {

	private RegistryView parentFrame;

	public South(RegistryView parentFrame) {

		this.parentFrame = parentFrame;

		String[] valuableCategories = {"Jewellry", "Stock", "Apparatus"};
		JComboBox comboBox = new JComboBox(valuableCategories);
		comboBox.addActionListener( event -> 
									parentFrame.getController().displayValuableDialog(this, (String) comboBox.getSelectedItem()));
		add(comboBox);

		JButton show = new JButton("Visa");
		show.addActionListener(event -> parentFrame.getController().showValuables());
		add(show);

		JButton crash = new JButton("Börskrasch");
		crash.addActionListener(event -> parentFrame.getController().setSharePricesToZero());
		add(crash);

	}

}
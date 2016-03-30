package JPanels;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

	private JTextArea textArea;

	public Center() {
	
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		add(scrollPane);

	}

	public void updateTextArea(String text) {

		textArea.setText(text);

	}

}
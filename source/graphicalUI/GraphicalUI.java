package graphicalUI;

import registry.*;
import valuables.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class GraphicalUI extends JFrame {

	MainContentPane mainContentPane;
	RegistryView view;

	public GraphicalUI(RegistryView view) {

		this.view = view;

		mainContentPane = new MainContentPane(this);

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(mainContentPane);

		pack();

	}

	public void updateTextArea(String text) {

		mainContentPane.updateTextArea(text);

	}

	public void handleEvent(ActionEvent event, MainContentPane mainContentPane) {
		
		view.handleEvent(event, mainContentPane);

	}

}
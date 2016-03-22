package graphicalUI;

import register.*;
import valuables.*;
import javax.swing.JFrame;

public class GraphicalUI extends JFrame {

	private RegisterController registerController = new RegisterController();

	public GraphicalUI() {

		setName("Sakregister");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ParentContentPane parentContentPane = new ParentContentPane(this);
		setContentPane(parentContentPane);

		//pack();

	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				GraphicalUI gUI = new GraphicalUI();
				gUI.setVisible(true);

			}

		});

	}

}
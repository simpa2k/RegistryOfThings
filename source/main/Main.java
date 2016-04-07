package main;

import mvc.RegistryView;

public class Main {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				RegistryView view = new RegistryView();

				view.setVisible(true);

			}

		});

	}

}
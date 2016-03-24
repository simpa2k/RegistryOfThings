package textUI;

import register.*;
import valuables.Valuable;
import java.util.ArrayList;

public class TextUI {

	RegistryModel registryModel = new RegistryModel();

	private void initialize() {


	}

	private void run() {

		RegisterController registerController = new RegisterController();

		ArrayList<Valuable> valuables = registryModel.getValuables();

		for(Valuable valuable : valuables) {

			System.out.println(valuable);

		}
		
	}

	public static void main(String[] args) {

		TextUI tUI = new TextUI();

		tUI.initialize();
		tUI.run();

	}

}
package mvc;

import valuables.*;
import compare.*;

import java.util.ArrayList;
import java.util.Collections;

public class RegistryModel {

	private ArrayList<Valuable> valuables = new ArrayList<>();
	private RegistryView view;

	public RegistryModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Stock("Ericsson", 100, 1300.0));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

	public void setView(RegistryView view) {

		this.view = view;

	}

	//behövs den här metoden?
	public void updateView() {

		view.update();

	}

	public void add(Valuable valuable) {

		if(valuable == null) {
			
			throw new IllegalArgumentException();

		} else {

			valuables.add(valuable);

		}

	}

	public String getValuables() {
		//använd append i viewen istället för att skapa en sammanhängande sträng här
		String valuableList = "";

		for(Valuable valuable : valuables) {

			valuableList += valuable + "\n";

		}

		return valuableList;

	}

	public void setSharePricesToZero() {

		for(Valuable valuable : valuables) {

			if(valuable instanceof Stock) {

				((Stock)valuable).setSharePrice(0.0);

			}

		}

		updateView();

	}

	//ska sorteringsfunktioner verkligen vara separerade från getValuables?
	//är det inte bättre att bara kolla vilken radiobutton som är vald när
	//visa-knappen trycks ned? Viewen skulle kunna skicka med en Comparator
	//som argument till getValuables baserat på vilken radiobutton som är vald.
	//Skulle lösa problemet med vilken sortering som ska gälla i början.
	public void sortValuablesByName() {

		Collections.sort(valuables, new NameComparator());

		updateView();

	}

	public void sortValuablesByNameWithoutUpdate() {

		Collections.sort(valuables, new NameComparator());

	}

	public void sortValuablesByValue() {

		Collections.sort(valuables, new ValueComparator());

		updateView();

	}

}
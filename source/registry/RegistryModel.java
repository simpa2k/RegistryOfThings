package registry;

import valuables.*;
import compare.*;
import mvc.*;

import java.util.ArrayList;
import java.util.Collections;

public class RegistryModel implements Subject {

	private ArrayList<Valuable> valuables = new ArrayList<>();
	private Observer observer;

	public RegistryModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Stock("Ericsson", 100, 1300.0));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

	@Override
	public void registerObserver(Observer observer) {

		this.observer = observer;

	}

	@Override
	public void updateObserver() {

		observer.update();

	}

	public void add(Valuable valuable) {

		if(valuable == null) {
			
			throw new IllegalArgumentException();

		} else {

			valuables.add(valuable);

		}

	}

	public String getValuables() {

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

		updateObserver();

	}

	public void sortValuablesByName() {

		Collections.sort(valuables, new NameComparator());

		updateObserver();

	}

	public void sortValuablesByNameWithoutUpdate() {

		Collections.sort(valuables, new NameComparator());

	}

	public void sortValuablesByValue() {

		Collections.sort(valuables, new ValueComparator());

		updateObserver();

	}

}
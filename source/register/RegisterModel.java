package register;

import valuables.*;
import compare.*;
import observer.*;

import java.util.ArrayList;
import java.util.Collections;

public class RegisterModel implements Subject {

	private ArrayList<Valuable> valuables = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();

	public RegisterModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

	@Override
	public void addObserver(Observer observer) {

		observers.add(observer);

	}


	@Override
	public void updateObservers() {

		for(Observer observer : observers) {

			observer.update();

		}

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

		updateObservers();

	}

	public void sortValuablesByName() {

		Collections.sort(valuables, new NameComparator());

		updateObservers();

	}

	public void sortValuablesByValue() {

		Collections.sort(valuables, new ValueComparator());

		updateObservers();

	}

}
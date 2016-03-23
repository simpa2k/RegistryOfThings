package valuables;

public abstract class Valuable implements Comparable<Valuable> {

	private String name;

	public Valuable(String name) {

		this.name = name;

	}

	public String getName() {

		return name;

	}

	protected abstract double calculateValue();

	//Ska inte den här heta calculateValue och vara public? Behöver den någonsin accessas utifrån? Tror inte det,
	//men det kanske är best practice att göra den public ändå, ur bibliotekssynpunkt? Man kan ju inte förutsäga
	//alla möjliga implementationer.
	protected double calculateValueWithTax() {

		double valueWithTax = calculateValue() * 1.25;

		return valueWithTax;

	}

	public int compareTo(Valuable anotherValuable) {

		return name.compareTo(anotherValuable.name);

	}
	
}
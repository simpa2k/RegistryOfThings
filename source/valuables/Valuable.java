package valuables;

public abstract class Valuable {

	protected String name;

	public Valuable(String name) {

		this.name = name;

	}

	protected abstract double calculateValue();

	protected double calculateValueWithTax() {

		double valueWithTax = calculateValue() * 1.25;

		return valueWithTax;

	}

	public abstract String toString();
}
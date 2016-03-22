package valuables;

public abstract class Valuable {

	private String name;

	public Valuable(String name) {

		this.name = name;

	}

	public String getName() {

		return name;

	}

	protected abstract double calculateValue();

	protected double calculateValueWithTax() {

		double valueWithTax = calculateValue() * 1.25;

		return valueWithTax;

	}
	
}
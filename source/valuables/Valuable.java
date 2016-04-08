package valuables;

public abstract class Valuable {

	private String name;

	public Valuable(String name) {

		if(name.matches("\\d+") || name.isEmpty()) {

			throw new IllegalArgumentException();

		} else {
			
			this.name = name;

		}

	}

	public String getName() {

		return name;

	}

	protected abstract double calculateValue();

	public double calculateValueWithTax() {

		double valueWithTax = calculateValue() * 1.25;

		return valueWithTax;

	}

	protected abstract String getProperties();

	public String toString() {

		return String.format("%s: %s Value: %s %s",
							 getClass().getSimpleName(), 
							 name, 
							 calculateValueWithTax(),
							 getProperties());

	}
	
}
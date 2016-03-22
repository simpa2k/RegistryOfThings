package valuables;

public class Jewellry extends Valuable {

	private int numberOfGems;
	private boolean isGold;

	public Jewellry(String name, int numberOfGems, boolean isGold) {

		super(name);
		this.numberOfGems = numberOfGems;
		this.isGold = isGold;

	}

	@Override
	protected double calculateValue() {

		int value = isGold ? 2000 : 700;
		
		value += numberOfGems * 500;

		return value;

	}

	@Override
	public String toString() {

		String metal = isGold ? "guld" : "silver";

		return String.format("%s: %s Värde: %s Stenar: %s Material: %s",
							 this.getClass().getSimpleName(),
							 name,
							 calculateValueWithTax(),
							 numberOfGems,
							 metal);

	}

}
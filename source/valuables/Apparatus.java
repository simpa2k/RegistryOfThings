package valuables;

public class Apparatus extends Valuable {

	private double purchasePrice;
	private int wear;

	public Apparatus(String name, double purchasePrice, int wear) {

		super(name);
		this.purchasePrice = purchasePrice;
		
		setWear(wear);

	}

	private void setWear(int wear) {

		if(wear < 1 || wear > 10) {

			throw new IllegalArgumentException();

		} else {

			this.wear = wear;

		}

	}

	@Override
	protected double calculateValue() {

		double wearPercentage = (double) wear / 10;

		return purchasePrice * wearPercentage;

	}

	@Override
	protected String getProperties() {

		return String.format("Price: %s Wear: %s",
							 purchasePrice,
							 wear);

	}

}
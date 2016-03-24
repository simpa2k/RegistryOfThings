package mvc;

public abstract class Model {

	private View view;

	public Model(View view) {

		this.view = view;

	}

	public abstract void updateView() {

		view.update();

	}

}
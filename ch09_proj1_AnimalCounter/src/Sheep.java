
public class Sheep extends Animal implements Cloneable {
	// Fields
	String name;

	// Constructors
	public Sheep() {
		name = "";
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Overrides
	@Override
	public String getCountString() {
		return getCount() + " " + name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

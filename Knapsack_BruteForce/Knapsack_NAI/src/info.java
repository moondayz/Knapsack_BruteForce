

public class info {

	private int value;
	private int weight;
	
	public info (int value, int weight) {
		this.setValue(value);
		this.setWeight(weight);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return  "value : " + value + "weight : " + weight ;
	}
	
}

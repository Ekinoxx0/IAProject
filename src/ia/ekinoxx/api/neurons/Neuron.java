package ia.ekinoxx.api.neurons;

public abstract class Neuron {
	
	protected float activation;

	public Neuron() {
		this(0);
	}
	
	public Neuron(float activation) throws IllegalArgumentException {
		if(activation < 0 || activation > 1) throw new IllegalArgumentException();
		this.activation = activation;
	}

	public float getActivation() {
		return this.activation;
	}
	
}

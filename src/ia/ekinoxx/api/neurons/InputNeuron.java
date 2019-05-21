package ia.ekinoxx.api.neurons;

public class InputNeuron extends Neuron {

	public InputNeuron() {
		super();
	}
	
	public void setActivation(float activation) {
		if(activation < 0 || activation > 1) throw new IllegalArgumentException();
		this.activation = activation;
	}
	
}

package ia.ekinoxx.api.layers;

import ia.ekinoxx.api.neurons.Neuron;

public abstract class Layer<T extends Neuron> {
	
	protected T[] neurons;
	
	public Layer(int size) throws IllegalArgumentException {
		if(size < 1) throw new IllegalArgumentException();
	}

	public T[] getNeurons() {
		return neurons;
	}
	
	public int size() {
		return this.neurons.length;
	}
	
}

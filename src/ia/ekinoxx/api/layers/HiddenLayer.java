package ia.ekinoxx.api.layers;

import ia.ekinoxx.api.neurons.HiddenNeuron;

public class HiddenLayer extends Layer<HiddenNeuron> {
	
	public HiddenLayer(int size, Layer<?> previousLayer) throws IllegalArgumentException {
		super(size);
		System.out.print("|");
		if(previousLayer == null) throw new IllegalArgumentException("previousLayer");
		this.neurons = new HiddenNeuron[size];
		for (int i = 0; i < this.neurons.length; i++) {
			this.neurons[i] = new HiddenNeuron(previousLayer);
		}
	}
	
	public void calculateLayer() {
		for(HiddenNeuron n : this.getNeurons()) {
			System.out.print("*");
			n.calculateActivation();
		}
	}
	
}

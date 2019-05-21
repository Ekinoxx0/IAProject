package ia.ekinoxx.api.layers;

import ia.ekinoxx.api.neurons.InputNeuron;

public class InputLayer extends Layer<InputNeuron> {

	public InputLayer(int size) throws IllegalArgumentException {
		super(size);
		this.neurons = new InputNeuron[size];
		for (int i = 0; i < neurons.length; i++) {
			this.neurons[i] = new InputNeuron();
		}
	}

	public void inputData(float[] fs) throws IllegalArgumentException {
		if(fs.length != this.getNeurons().length) throw new IllegalArgumentException("Size of input data doesn't correspond to inputNeurons size.. (" + fs.length + "!=" + this.size() + ")");
		for (int i = 0; i < fs.length; i++) {
			if(fs[i] > 1 || fs[i] < 0) throw new IllegalArgumentException("Input data " + i + " is not in 0<I<1 : " + fs[i]);	
			this.getNeurons()[i].setActivation(fs[i]);
		}
	}

}

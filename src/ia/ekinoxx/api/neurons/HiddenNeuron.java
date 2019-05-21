package ia.ekinoxx.api.neurons;

import java.util.Random;

import ia.ekinoxx.api.layers.Layer;

public class HiddenNeuron extends Neuron {
	
	private static Random r = new Random();

	protected float[] weights;
	protected float bias;
	protected final Layer<?> previousLayer;

	public HiddenNeuron(Layer<?> previousLayer) throws IllegalArgumentException {
		if (previousLayer == null)
			throw new IllegalArgumentException();
		System.out.print("*");
		this.previousLayer = previousLayer;
		this.weights = new float[this.previousLayer.size()];
		this.bias = r.nextFloat() * 10;
		
		for (int i = 0; i < weights.length; i++) {
			this.weights[i] = r.nextFloat();
		}
	}

	public HiddenNeuron(Layer<?> previousLayer, float[] weights, float bias) throws IllegalArgumentException {
		this(previousLayer);
		this.weights = weights;
		this.bias = bias;
	}

	public void calculateActivation() {
		this.activation = 0;
		for (int i = 0; i < this.previousLayer.size(); i++) {
			this.activation += this.previousLayer.getNeurons()[i].activation * this.weights[i];
		}
		this.activation = sigmoid(this.activation - this.bias);
	}

	private static float sigmoid(float x) {
		return (float) (1 / (1 + Math.pow(Math.E, (-1 * x))));
	}

}

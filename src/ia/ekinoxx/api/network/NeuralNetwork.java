package ia.ekinoxx.api.network;

import ia.ekinoxx.api.layers.HiddenLayer;
import ia.ekinoxx.api.layers.InputLayer;
import ia.ekinoxx.api.layers.Layer;
import ia.ekinoxx.api.layers.OutputLayer;

public class NeuralNetwork {

	private int numberOfTraining = 0;
	private int numberOfTry = 0;
	private int numberOfErrors = 0;
	
	private final InputLayer input;
	private final OutputLayer output;
	private final Layer<?>[] layers;
	
	public NeuralNetwork(int[] neuronsNumber) {
		//Layers initialization
		this.layers = new Layer[neuronsNumber.length];

		this.layers[0] = new InputLayer(neuronsNumber[0]);

		for(int i = 1; i < neuronsNumber.length-1; i++) {
			this.layers[i] = new HiddenLayer(neuronsNumber[i], this.layers[i-1]);
		}

		this.layers[neuronsNumber.length-1] = new OutputLayer(neuronsNumber[neuronsNumber.length-1], this.layers[neuronsNumber.length-2]);
		this.input = (InputLayer) this.layers[0];
		this.output = (OutputLayer) this.layers[neuronsNumber.length-1];
		System.out.println("");
	}

	public float[] getResultFor(float[] fs) {
		input.inputData(fs);
		for(Layer<?> l : this.layers) {
			if(l instanceof HiddenLayer) {
				System.out.print("|");
				((HiddenLayer) l).calculateLayer();
			}
		}
		System.out.println("");
		return output.getOutputData();
	}
	
	public float[] cost(float[] trainingData, float[] waitingFor) throws IllegalArgumentException {
		if(waitingFor.length != this.output.size()) throw new IllegalArgumentException();
		float[] results = getResultFor(trainingData);
		
		float[] costs = new float[this.output.size()];
		
		for (int i = 0; i < results.length; i++) {
			costs[i] = (float) Math.pow(results[i] - waitingFor[i], 2);
		}
		
		return costs;
	}
	
}

package ia.ekinoxx.api.layers;

public class OutputLayer extends HiddenLayer {

	public OutputLayer(int size, Layer<?> previousLayer) throws IllegalArgumentException {
		super(size, previousLayer);
	}
	
	public float[] getOutputData() {
		float[] fs = new float[this.getNeurons().length];
		
		for (int i = 0; i < this.getNeurons().length; i++) {
			fs[i] = this.getNeurons()[i].getActivation();
		}
		
		return fs;
	}
	
}

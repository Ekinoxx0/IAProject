package ia.ekinoxx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import ia.ekinoxx.api.network.NeuralNetwork;

public class Main {
	
	private static HashMap<Integer, Integer[]> images = new HashMap<Integer, Integer[]>();
	
	public static void main(String[] args) {
		loadAllImages();
		System.out.println("Now creating the N.N.");
		
		NeuralNetwork nn = new NeuralNetwork(new int[] {28*28, 28*2, 28, 10});
		System.out.println("N.N. created !");
		
		DisplayTab.displayResponse(nn.getResultFor(convertImage(images.get(0))));
	}
	
	
	
	public static float[] convertImage(Integer[] ints) {
		float[] fs = new float[ints.length];
		
		for (int i = 0; i < ints.length; i++) {
			fs[i] = ints[0] / 255;
		}
		
		return fs;
	}
	
	public static void loadAllImages() {
		System.out.println("Starting the load of images..");
		File train = new File("D:\\Downloads\\mnist_train.csv");
		loadFile(train);
	}
	
	public static void loadFile(File f) {
		System.out.println("Now loading file " + f.getName());
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			int n = 0;
			String s;
			while((s = br.readLine()) != null) {
				System.out.println("Loading image...");
				Integer[] ints = new Integer[28*28];
				
				String[] values = s.split(",");
				int numberIs = Integer.parseInt(values[0]);
				values = Arrays.copyOfRange(values, 1, values.length);;
				
				for (int i = 0; i < values.length; i++) {
					ints[i] = Integer.parseInt(values[i]);
				}
				
				images.put(numberIs, ints);
				if(n > 50) {
					System.out.println("Stopped the load after 50 imgs");
					break;
				}
				n++;
			}
			System.out.println("" + images.size() + " imgs loaded");
			if(n != images.size()) {
				System.out.println("A problem probably occured because number of lines is dif from images nbr : " + n + " != " + images.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

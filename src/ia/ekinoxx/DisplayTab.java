package ia.ekinoxx;

public class DisplayTab {
	
	public static void displayImg(Integer[] ints) {
		int n = 0;
		for (int i = 0; i < ints.length; i++) {
			i++;
			System.out.print(ints[i] > 128 ? "*" : "");
			if(n == 28) {
				n = 0;
				System.out.println();
			}
		}
	}
	
	public static void displayResponse(float[] fs) {
		System.out.println("#######################################################################");
		System.out.print("# ");
		for(float f : fs) {
			System.out.printf("%.2f", f);
			System.out.print(" # ");
		}
		System.out.println();
		System.out.println("#######################################################################");
	}
	
}

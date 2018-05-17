
public abstract class BubbleSort {
	
	public void sort(int[] docs) {
		int count = l.length;
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < (count - 1); j++) {
				if (compare(docs[j], docs[j+1]) > 0) {
					int tmp = docs[j];
					int docs[j] = docs[j+1];
					int docs[j+1] = tmp;
				}
			}
		}
	}
	
	public abstract int compare(int i1, int i2);
	
}

public class AscendingBubbleSort extends BubbleSort {
	
	public int compare(int i1, int i2) {
		return i1 - i2;
	}
}

public class DescendingBubbleSort extends BubbleSort {
	
	public int compare(int i1, int i2) {
		return i2 - i1;
	}
}


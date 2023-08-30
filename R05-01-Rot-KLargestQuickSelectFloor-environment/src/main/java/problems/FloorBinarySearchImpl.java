package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		Integer menor = null;
		while (leftIndex <= rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio] <= x) {
				menor = array[meio];
				leftIndex = meio + 1;
			} else {
				rightIndex = meio - 1;
			}
		} 
		return menor;		
		// TODO implement your code here
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	

	public static void main(String[] args) {
		FloorBinarySearchImpl floor = new FloorBinarySearchImpl();
		Integer[] array = {4,6,8,10};
		Integer[] array2 = {4,6,8,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(floor.floor(array2, 2));
		System.out.println(floor.floor(array2, 8));
	}
}

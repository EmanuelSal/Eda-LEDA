package problems;


public class BinarySearchRotatedArrayImpl implements BinarySearchRotatedArray{
   
    public int findRotations(int[] array){
                return binarySearchRotation(array, 0, array.length-1);
        }
        
        
        //TODO implement your code here
       // throw new UnsupportedOperationException("Not implemented yet!");
    

    public int binarySearchRotation(int[] array, int left, int right) {
        int rotation = 0;
        int indiceControle = 0;
        if (left < right) {
            int meio = (left + right) /2;
            if (array[left] > array[left +1]) {
                indiceControle = left;
                binarySearchRotation(array, indiceControle + 1, right);
                binarySearchRotation(array, 0, indiceControle);
                rotation +=1;
            }
        }
        return rotation;
    } 

}

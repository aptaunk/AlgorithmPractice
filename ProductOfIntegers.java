public class ProductOfIntegers
{
    public static int[] productOfAllIntegersExceptItself(int[] input) {
        int product = 1;
        int indexOfZeros = -1;
        for (int i=0; i<input.length; i++) {
            if (input[i] == 0) {
                if (indexOfZeros == -1) {
                    indexOfZeros = i;
                } else {
                    indexOfZeros = -2;
                }
            } else {
                product *= input[i];
            }
        }
        
        if (indexOfZeros == -1) {
            int[] returnThis = new int[input.length];
            for (int i=0; i<input.length; i++) {
                returnThis[i] = product/input[i];
            }
            return returnThis;
        } else if (indexOfZeros == -2) {
            return new int[input.length];
        } else {
            int[] returnThis = new int[input.length];
            returnThis[indexOfZeros] = product;
            return returnThis;
        }
    }
}


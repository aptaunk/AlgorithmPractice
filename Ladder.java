public class Ladder
{
    public static void printCombinatiosnUpALadder(int n) {
        for (int doubles=0; doubles<=n/2; doubles++) {
            printPermutations(n-2*doubles,doubles,new int[n-2*doubles],0);
        }
    }
    
    public static void printPermutations(int singles, int doubles, int[] singleLocations, int position) {
        if (position == singles) {
            int[] outputArray = new int[singles+doubles];
            for (int i=0; i<singles; i++) {
                outputArray[singleLocations[i]] = 1;
            }
            for (int i=0; i<singles+doubles; i++) {
                if (outputArray[i] == 1) {
                    System.out.print(1);
                } else {
                    System.out.print(2);
                }
            }
            System.out.print("\n");
        } else {
            comebackhere:
            for (int i=0; i<singles+doubles; i++) {
                for (int j=0; j<position; j++) {
                    if (singleLocations[j]>=i) {
                        continue comebackhere;
                    }
                }
                singleLocations[position] = i;
                printPermutations(singles,doubles,singleLocations,position+1);
            }
        }
    }
}

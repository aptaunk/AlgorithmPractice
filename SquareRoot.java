public class SquareRoot
{
    public static double getSquareRoot(double n, int precision) {
        return getSquareRoot(n,0,n,precision);
    }
    
    private static double getSquareRoot(double n, double lower, double upper, int maxPrecision) {
        double mid = (upper+lower)/2;
        if (maxPrecision==0) {
            return mid;
        }
        
        if (mid*mid<n) {
            return getSquareRoot(n,mid,upper,maxPrecision-1);
        } else if (mid*mid>n) {
            return getSquareRoot(n,lower,mid,maxPrecision-1);
        } else {
            return mid;
        }
    }
}

public class DoubleCheckedSingleton
{
    private static DoubleCheckedSingleton instance = null;
    
    private DoubleCheckedSingleton() {}
    
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

//Advantage: Same as InitializationOnDemandSingleton
//Disadvantage: Most people clain that this method doesnt work before java 5 and some claim that it doesnt work even now

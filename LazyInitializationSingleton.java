public class LazyInitializationSingleton
{
    private static LazyInitializationSingleton instance = null;
    
    private LazyInitializationSingleton() {}
    
    public synchronized static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}

//Advantage: No instance created unless needed
//Disadvantage: Getting a lock for the getInstance method can be expensive

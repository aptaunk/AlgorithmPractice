public class StaticInstanceSingleton
{
    private static final StaticInstanceSingleton instance = new StaticInstanceSingleton();
    
    private StaticInstanceSingleton() {}
    
    public static StaticInstanceSingleton getInstance() {
        return instance;
    }
}

//Advantage: No need for expensive synchronized getInstance method
//Disadvantage: One instance will be created even if it is never used

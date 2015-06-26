
public class InitializationOnDemandSingleton
{
    private InitializationOnDemandSingleton() {}
  
    public static InitializationOnDemandSingleton getInstance() {
        return SingletonHolder.instance;
    }
  
    private static class SingletonHolder {
        private static final InitializationOnDemandSingleton instance = new InitializationOnDemandSingleton();
    }
}

//Advantage: No need for synchronization and no unnecessary instances created
//Disadvantage: None

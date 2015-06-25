import java.util.*;

public class WebMonitor
{
    private HashMap<String,Integer> monitor;
    private String[] topFive;
    
    public WebMonitor() {
        monitor = new HashMap<String,Integer>();
        monitor.put(null,0);
        topFive = new String[5];
    }
    
    private void updateTopFive() {
        for (int i=4; i>0; i--) {
            if (monitor.get(topFive[i])>monitor.get(topFive[i-1])) {
                String temp = topFive[i-1];
                topFive[i-1] = topFive[i];
                topFive[i] = temp;
            }
        }
    }
    
    private boolean topFiveContains(String website) {
        for (int i=0; i<5; i++) {
            if (website.equals(topFive[i])) {
                return true;
            }
        }
        return false;
    }
    
    public void visitPage(String website) {
        if (monitor.containsKey(website)) {
            monitor.put(website,monitor.get(website)+1);
        } else {
            monitor.put(website,1);
        }
        
        if (!topFiveContains(website) && monitor.get(website)>monitor.get(topFive[4])) {
            topFive[4] = website;
        }
        
        updateTopFive();
    }
    
    public String[] getTopFivePages() {
        return topFive;
    }
}

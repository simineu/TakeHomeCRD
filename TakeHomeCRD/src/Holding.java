import java.util.*;

public class Holding {
    Map<String, Double> hld = new HashMap<String, Double>();

    private Map<String, Double> getHld() {
        return hld;
    }

    private void setHld(Map<String, Double> hld) {
        this.hld = hld;
    }
}

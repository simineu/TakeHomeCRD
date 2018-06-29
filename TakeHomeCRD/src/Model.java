import java.util.*;

public class Model {
    Map<String, Double> mdl = new HashMap<String, Double>();

    private Map<String, Double> getMdl() {
        return mdl;
    }

    private void setMdl(Map<String, Double> mdl) {
        this.mdl = mdl;
    }
}

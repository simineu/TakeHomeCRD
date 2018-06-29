public class Order {
    String sec;
    char trans;
    double amt;

    public Order(String sec,char trans, double amt){
        this.sec = sec;
        this.trans = trans;
        this.amt = amt;
    }

    private String getSec() {
        return sec;
    }

    private void setSec(String sec) {
        this.sec = sec;
    }

    private char getTrans() {
        return trans;
    }

    private void setTrans(char trans) {
        this.trans = trans;
    }

    private double getAmt() {
        return amt;
    }

    private void setAmt(double amt) {
        this.amt = amt;
    }
}

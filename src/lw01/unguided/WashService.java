package lw01.unguided;

public abstract class WashService implements Billable {
    private final String id;
    private final int days;

    protected WashService(String id, int days) {
        this.id = id ;
        this.days = days ;
    }

    public String getId() {
        return id ;
    }

    public int getDays() {
        return days ;
    }

    @Override 
    public abstract int calculateCharge() ;

    public int calculateCharge(int copies) {
        return copies * calculateCharge() ;
    }

    public String label() {
        return "Print" ;
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge() ;
    }
}

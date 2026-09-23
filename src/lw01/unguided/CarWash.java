package lw01.unguided;

import lw01.unguided.WashService;

public class CarWash extends WashService{
    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge () {
        int days = getDays();
        int charge;

        if (getDays () <= 3) {
            return (35000 * getDays() + 15000);
        } 
        else{
            return (35000 * 3 + (getDays() - 3) * 25000 + 15000);
        }
    }

    @Override 
    public String label() {
        return "CarWash" ;
    }
}



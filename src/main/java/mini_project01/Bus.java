package mini_project01;

import java.util.ArrayList;
import java.util.List;

public class Bus {
   //Number of seats, busNo

    public String busNO;

   public List<String> seats = new ArrayList();

    public Bus(String busNO){ // creating parameterised constructor
        this.busNO = busNO;
        for (int i = 1; i < 33; i++){
            this.seats.add(i + "");
        }


    }
}

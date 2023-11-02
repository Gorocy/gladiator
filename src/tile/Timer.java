package tile;
import java.util.ArrayList;

public class Timer {

    public int time;
    public int timeMax;
    public int type;
    //ArrayList<Integer, Integer> dynamicznaTablica = new ArrayList<>();


    public  Timer(int type){
        this.type = type;
        if(type ==9){
            time =180;
            timeMax = 180;
        }

    }


}

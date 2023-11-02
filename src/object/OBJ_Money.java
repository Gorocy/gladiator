package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Money extends SuperObject{

    public OBJ_Money(){
        name = "Money";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/images/objects/money.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

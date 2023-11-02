package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        name = "Door";
        try{

            //diferente door sgould be readen
            image = ImageIO.read(getClass().getResourceAsStream("/images/objects/closeddoor.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;

    }




}

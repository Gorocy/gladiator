package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends SuperObject{

    public OBJ_Boots(){
        name = "Boots";
        try{

            //diferente door sgould be readen
            image = ImageIO.read(getClass().getResourceAsStream("/images/objects/boot.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;

    }

}

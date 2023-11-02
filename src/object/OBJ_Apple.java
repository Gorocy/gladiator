package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Apple extends SuperObject{

    public OBJ_Apple(){
        name = "Apple";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/images/objects/apple.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

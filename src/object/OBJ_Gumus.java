package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Gumus extends SuperObject{
    public OBJ_Gumus(){

        name = "Gumus";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/gumus.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Zumrut extends SuperObject{

    public OBJ_Zumrut(){

        name = "zumrut";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/zumrut.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

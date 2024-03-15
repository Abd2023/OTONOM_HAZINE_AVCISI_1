package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Gold extends SuperObject{

    public OBJ_Gold(){

        name = "gold";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/gold.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

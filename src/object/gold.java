package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class gold extends SuperObject{

    public void OBJ_gold(){

        name = "AltinSandigi";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/gold.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

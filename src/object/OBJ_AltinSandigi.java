package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_AltinSandigi extends SuperObject{

    public void OBJ_AltinSandigi(){

        name = "altinSandigi";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/gold.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
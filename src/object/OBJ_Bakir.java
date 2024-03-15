package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Bakir extends SuperObject{

    public OBJ_Bakir(){

        name = "Bakir";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/copper.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

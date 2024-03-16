package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Zumrut22 extends SuperObject{

    public OBJ_Zumrut22(){

        name = "Zumrut22";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/zumrut.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package spacely.fireit.Helpers;

import com.badlogic.gdx.Gdx;

/**
 * Created by Workspace on 23.04.2017.
 */

public class MyRatio  {
    public static float getWidth(float i){
        float width = Gdx.graphics.getWidth()*i/100;
        return width;
    }
    public static float getHeight(float i){
        float height = Gdx.graphics.getHeight()*i/100;
        return height;
    }
    public static float getAspectRatio(int size){

        float ratio = getAspectRatioDefault();
        return ratio * size;
    }
    public static float getAspectRatioDefault(){
        float height = Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();
        System.out.println("Height: "+Gdx.graphics.getHeight());
        System.out.println("Width: "+Gdx.graphics.getWidth());
        return height/width;
    }
}

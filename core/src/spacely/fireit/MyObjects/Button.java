package spacely.fireit.MyObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import spacely.fireit.Asset;
import spacely.fireit.Helpers.MyRatio;


/**
 * Created by Workspace on 22.04.2017.
 */

public class Button {
    private Sprite sprite;
    private Sprite sprite_miss;
    private Texture texture;
    private Texture texture_miss;
    private static float faded = 0;
    private float faded_play =0;
    private static float moving = 0;
    private float moving_play =0;
    private Sound click_sound;
    private static  boolean enabled = true;
    private float x_pos_1,x_pos_2,y_pos;


    public Button(){
        sprite = new Sprite();
        sprite_miss = new Sprite();
        texture = Asset.manager.get(Asset.play_button_txtr,Texture.class);
        texture_miss = Asset.manager.get(Asset.miss_txtr,Texture.class);

        x_pos_1 = (Gdx.graphics.getWidth()/2)-((texture.getWidth()*MyRatio.getHeight(0.11f)/2));
        x_pos_2 = (Gdx.graphics.getWidth()/2)-((texture_miss.getWidth()*MyRatio.getHeight(0.11f)/2));
        sprite.setOriginCenter();
        sprite_miss.setOriginCenter();
        sprite.setSize((texture.getWidth()*MyRatio.getHeight(0.11f)),texture.getHeight()*MyRatio.getHeight(0.11f));
        sprite_miss.setSize(texture_miss.getWidth()*MyRatio.getHeight(0.11f),texture_miss.getHeight()*MyRatio.getHeight(0.11f));

        sprite.setPosition(x_pos_1,Gdx.graphics.getHeight()/2);
        sprite_miss.setPosition(x_pos_2,sprite.getY()+sprite.getHeight()+sprite_miss.getHeight());
        sprite.setAlpha(0.0f);
        sprite_miss.setAlpha(0.0f);

        click_sound = Asset.manager.get(Asset.click_sound,Sound.class);


    }

    public void draw(SpriteBatch batch,int type){

        switch (type){
            case 1:
                fade();
                sprite.setRegion(texture);
                sprite.draw(batch);
                sprite_miss.setRegion(texture_miss);
                sprite_miss.draw(batch);
                break;
            case 2:
                fadeout();
                sprite.setRegion(texture);
                sprite.draw(batch);
                sprite_miss.setRegion(texture_miss);
                sprite_miss.draw(batch);
                break;
        }

    }

    public void fade(){
        if (faded <= 1) {
            faded = faded + 0.1f;
            moving = moving +3;

            sprite_miss.setPosition(x_pos_2,Gdx.graphics.getHeight()/2+sprite.getHeight()+sprite_miss.getHeight()+moving);
            sprite_miss.setAlpha(faded);
        }
        if (faded >=1 ){
            if (faded_play <= 1) {
                faded_play = faded_play + 0.1f;
                moving_play = moving_play + 3;

                sprite.setPosition(x_pos_1, Gdx.graphics.getHeight() / 2 + moving_play);
                sprite.setAlpha(faded_play);
            }
        }


    }
    public void fadeout(){
        if (faded >= 0) {
            faded = faded - 0.1f;
            moving = moving - 3;
            sprite.setPosition(x_pos_1,Gdx.graphics.getHeight()/2+moving);
            sprite_miss.setPosition(x_pos_2,Gdx.graphics.getHeight()/2+sprite.getHeight()+sprite_miss.getHeight()+moving);
        }
        if (faded <= 0) {
            faded = 0;
            moving = 0;
            faded_play =0;
            moving_play =0;
        }
        sprite.setAlpha(faded);
        sprite_miss.setAlpha(faded);
    }

    public void reset(){
        faded = 0;
        moving = 0;
        sprite.setPosition((Gdx.graphics.getWidth()/2)-((texture.getWidth())),Gdx.graphics.getHeight()/2);
    }

    public static void setEnabled(boolean enabledd){
       enabled = enabledd;
    }



    public boolean isClicked(float x,float y){
        if (enabled) {
            if (sprite.getBoundingRectangle().contains(x, y)) {
                click_sound.play();
                return true;
            } else {
                return false;
            }

        }return false;
    }
}

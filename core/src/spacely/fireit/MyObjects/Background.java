package spacely.fireit.MyObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import spacely.fireit.Asset;

/**
 * Created by Workspace on 25.04.2017.
 */

public class Background {
    private Sprite sprite_1;
    private Texture texture_1,texture_2;

    public Background(){
        sprite_1 = new Sprite();


        texture_1 = Asset.manager.get(Asset.game_bg_txtr_2,Texture.class);
        texture_2 = Asset.manager.get(Asset.game_bg_txtr_3,Texture.class);

        sprite_1.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sprite_1.setOriginCenter();
        sprite_1.setPosition(0,0);


    }


    public void draw(SpriteBatch spriteBatch,int random){
        if (random == 0)
            sprite_1.setRegion(texture_1);
        else sprite_1.setRegion(texture_2);
        sprite_1.draw(spriteBatch);
    }
}

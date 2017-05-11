package spacely.fireit.MyObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import spacely.fireit.Asset;
import spacely.fireit.Helpers.MyAnimation;
import spacely.fireit.Helpers.MyRatio;


public class Man {

    private Sprite sprite;

    private MyAnimation myAnimation;
    private Texture texture;
private float height_pos;
    private float pos_x,pos_y;

    public Man(){
        height_pos = MyRatio.getHeight(2.6f);
        sprite = new Sprite();
        texture = Asset.manager.get(Asset.animate_kick,Texture.class);
        pos_x = (texture.getWidth()/9)*MyRatio.getHeight(0.13f);
        pos_y = texture.getHeight()*MyRatio.getHeight(0.13f);
        sprite.setOriginCenter();
        sprite.setSize(pos_x,pos_y);
        sprite.setPosition((Gdx.graphics.getWidth()/2)-pos_x/2,height_pos);
        myAnimation = new MyAnimation(new TextureRegion(texture),9,0.2f);

        System.out.println("Aspect Ratio: " + MyRatio.getAspectRatioDefault());
    }

    public void draw(SpriteBatch batch){
        sprite.setRegion(myAnimation.getFrame());
        sprite.draw(batch);
    }

    public void kick(){
        MyAnimation.animate = true;
    }

    public void animate(float dt,Ball ball){
        myAnimation.update(dt,ball);
    }

    public boolean isClicked(float x,float y){
        return sprite.getBoundingRectangle().contains(x, y);
    }
}

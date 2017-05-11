package spacely.fireit.MyObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import spacely.fireit.Helpers.MyRatio;

/**
 * Created by Workspace on 22.04.2017.
 */

public class Label {
    private FreeTypeFontGenerator freeTypeFontGenerator;
    private FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter;
    private BitmapFont font;
    private GlyphLayout glyphLayout;

    public Label(){
        freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Pixellari.ttf"));
        freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.size = (int)MyRatio.getHeight(6.5f);
        freeTypeFontParameter.color = Color.WHITE;
        font = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        glyphLayout = new GlyphLayout();

    }

    public void setText(String text){
        glyphLayout.setText(font, "" + text);
    }
    public void setTextSize(int size){
        freeTypeFontParameter.size = size;
    }
    public void draw(SpriteBatch spriteBatch,float x,float y){
        font.draw(spriteBatch, glyphLayout, x,y);
    }
    public float getWidth(){
        return glyphLayout.width;
    }
public float getHeight(){
    return glyphLayout.height;
}
}

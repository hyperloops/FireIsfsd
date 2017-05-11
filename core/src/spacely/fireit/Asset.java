package spacely.fireit;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;




/**
 * Created by Workspace on 11/02/2017.
 */

public class Asset  {

    public static final String game_bg_txtr_1 = "bg.png";
    public static final String man_txtr = "man_s.PNG";
    public static final String animate_kick = "animation_kick.PNG";
    public static final String ball_txtr = "ball.PNG";
    public static final String ball_sound = "ball_sound.wav";
    public static final String gameover_sound = "go_sound.wav";
    public static final String play_button_txtr = "play_button.PNG";
    public static final String click_sound = "click.wav";
    public static final String miss_txtr = "miss_text.png";
    public static final String game_bg_txtr_2 = "bg_2.png";
    public static final String game_bg_txtr_3 = "bg_3.png";

    public static AssetManager manager;

    public Asset(){
        load();
    }
    public static void load(){
        manager = new AssetManager();
       // TextureLoader.TextureParameter param = new TextureLoader.TextureParameter();

        //param.minFilter = Texture.TextureFilter.Linear;
       // param.magFilter = Texture.TextureFilter.Linear;
        manager.load(game_bg_txtr_1, Texture.class);
        manager.load(man_txtr,Texture.class);
        manager.load(animate_kick,Texture.class);
        manager.load(ball_txtr,Texture.class);
        manager.load(ball_sound,Sound.class);
        manager.load(gameover_sound,Sound.class);
        manager.load(play_button_txtr,Texture.class);
        manager.load(click_sound,Sound.class);
        manager.load(miss_txtr,Texture.class);
        manager.load(game_bg_txtr_2,Texture.class);
        manager.load(game_bg_txtr_3,Texture.class);



    }

    public static void dispose(){
        manager.dispose();
    }

}

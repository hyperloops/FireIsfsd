package spacely.fireit.MyObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import spacely.fireit.Asset;

import spacely.fireit.GameStates.MenuState;
import spacely.fireit.Helpers.MyRatio;

/**
 * Created by Workspace on 21.04.2017.
 */

public class Ball {
    private Sprite sprite;
    private Texture texture;
    private Vector3 position,velocity;
    private static int GRAVITY = ((int)MyRatio.getHeight(1.7f))*(-1);
    private boolean earth = false;
    private Random random;
   private int rotate = 10;
    private Sound ball_sound;
    public static int soundtrue = 0;
    public static int gameover_sound_true = 0;
    public static boolean gameover = false;
    private Sound gameover_sound;
    public static int point = 0;
    private float height_pos = 0;
    private float pos_y;
    private  float pos_x;
    private Preferences preferences;
    public static int high_score = 0;
    public static String HIGHSCORE = "HighScore";
    public static String SCORE = "Score";
    public Ball(){

        height_pos = MyRatio.getHeight(2.6f);

        texture = Asset.manager.get(Asset.ball_txtr,Texture.class);
        pos_x = texture.getWidth() * MyRatio.getHeight(0.13f);
        pos_y = texture.getHeight() * MyRatio.getHeight(0.13f);
        sprite = new Sprite();
        sprite.setSize(pos_x, pos_y);
        sprite.setPosition(Gdx.graphics.getWidth()/2+(pos_x /2),height_pos);
        sprite.setOriginCenter();
        velocity = new Vector3(0,0,0);
        position = new Vector3((int)(Gdx.graphics.getWidth()/2+(pos_x /2)),height_pos,0);
        random = new Random();
        ball_sound = Asset.manager.get(Asset.ball_sound,Sound.class);
        gameover_sound = Asset.manager.get(Asset.gameover_sound,Sound.class);





    }

    public void draw(SpriteBatch batch){
        sprite.setRegion(texture);
        sprite.draw(batch);
    }

    public void falling(float dt){
        if (!earth) {
            velocity.add(0, GRAVITY, 0);
            velocity.scl(dt);
            position.add(velocity.x, velocity.y, 0);
            velocity.scl(1 / dt);
            sprite.setPosition(position.x, position.y);
            sprite.rotate(dt*rotate);
        }
        if (position.y<=height_pos){
            earth = true;
            position.y = height_pos;

            sprite.setPosition(position.x,position.y);
            gameover = true;
            //point = 0;
            gameover_sound_true++;
            Button.setEnabled(true);
            if (gameover_sound_true == 1) {
                gameover_sound.play();

            }
        }
    }
    public void kick(){
            if (!gameover) {
                if (position.y < MyRatio.getHeight(8.6f) && position.y > MyRatio.getHeight(5.6f) && position.x < Gdx.graphics.getWidth()/2+(pos_x /2)) {

                    velocity.y = MyRatio.getHeight(31.25f) + random.nextInt((int)MyRatio.getHeight(26.042f));
                    //velocity.x =  MyRatio.getHeight(31.25f) + random.nextInt((int)MyRatio.getHeight(26.042f));
                    rotate = random.nextInt(200) - 100;
                    soundtrue++;
                    if (soundtrue == 1) {
                        ball_sound.play();
                        point++;
                        soundtrue++;
                    }

                }else if (position.y < MyRatio.getHeight(4.8f) && position.y > height_pos&& position.x < Gdx.graphics.getWidth()/2+(pos_x /2)){
                    velocity.y = MyRatio.getHeight(31.25f) + random.nextInt((int)MyRatio.getHeight(26.042f));
                    velocity.x =  MyRatio.getHeight(5.25f) + random.nextInt((int)MyRatio.getHeight(8.042f));
                    rotate = random.nextInt(220) - 120;
                    soundtrue++;
                    if (soundtrue == 1) {
                        ball_sound.play();
                        point++;
                        soundtrue++;
                    }
                }

            }else {

            }


    }
    public void respawn(){
        gameover_sound_true = 0;
        //gameover = false;
        earth = false;
        position.x = (int)(Gdx.graphics.getWidth()/2+(pos_x /2));
        velocity.x = 0;
        velocity.y = MyRatio.getHeight(62.5f) + random.nextInt((int)MyRatio.getHeight(10.42f));
        soundtrue++;
        if (soundtrue == 1) {
            ball_sound.play();

        }
    }

}

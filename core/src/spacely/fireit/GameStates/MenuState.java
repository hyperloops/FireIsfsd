package spacely.fireit.GameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.badlogic.gdx.utils.viewport.Viewport;


import java.util.Random;

import spacely.fireit.Asset;


import spacely.fireit.Helpers.MyRatio;
import spacely.fireit.MyObjects.Background;
import spacely.fireit.MyObjects.Ball;
import spacely.fireit.MyObjects.Button;
import spacely.fireit.MyObjects.Label;
import spacely.fireit.MyObjects.Man;
import spacely.fireit.State;
import spacely.fireit.StateManager;


/**
 * Created by Workspace on 12.04.2017.
 */

public class MenuState extends State {
   // private Texture background_3;
   // private Texture background_2;
    private Background background;
    private OrthographicCamera camera;
    private Man man;
    private Ball ball;
    private Button play_btn;
    private Vector3 tmp;
    private Label label_score;
    private Viewport gameViewport;
    private int random_bg = 0;
    private Random random;
    private Label high_score;
    private Preferences preferences;
    private int high_sc;





    public MenuState(StateManager stateManager) {
        super(stateManager);

        //background_3 = Asset.manager.get(Asset.game_bg_txtr_3, Texture.class);
        //background_2 = Asset.manager.get(Asset.game_bg_txtr_2, Texture.class);

        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gameViewport = new ScreenViewport(camera);

        background = new Background();
        man = new Man();
        ball = new Ball();
        play_btn = new Button();
        tmp = new Vector3();
        label_score = new Label();
        high_score = new Label();

        preferences = Gdx.app.getPreferences(Ball.HIGHSCORE);
        high_sc =preferences.getInteger(Ball.SCORE,0);

        random = new Random();


    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {

            if (!Ball.gameover) {
                man.kick();


            }
            Gdx.input.setInputProcessor(new InputProcessor() {
                @Override
                public boolean keyDown(int keycode) {
                    return false;
                }

                @Override
                public boolean keyUp(int keycode) {
                    return false;
                }

                @Override
                public boolean keyTyped(char character) {
                    return false;
                }

                @Override
                public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                    return false;
                }

                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                    tmp.set(screenX, screenY, 0);
                    camera.unproject(tmp);
                    if (play_btn.isClicked(tmp.x, tmp.y)) {
                        System.out.println("Clicked!!!!");
                        ball.kick();
                        if (Ball.gameover) ball.respawn();
                        Ball.gameover = false;
                        Ball.soundtrue = 0;
                        //play_btn.reset();
                        Button.setEnabled(false);
                        Ball.point = 0;
                        random_bg = random.nextInt(2);
                    }
                    return false;
                }

                @Override
                public boolean touchDragged(int screenX, int screenY, int pointer) {
                    return false;
                }

                @Override
                public boolean mouseMoved(int screenX, int screenY) {
                    return false;
                }

                @Override
                public boolean scrolled(int amount) {
                    return false;
                }
            });


        }
        // System.out.println("GET Y"+Gdx.input.getY());
    }

    @Override
    public void update(float dt) {
        man.animate(dt, ball);
        ball.falling(dt);

        handleInput();
        camera.update();
        label_score.setText(""+Ball.point);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();
        //if (random_bg == 0)
        //    spriteBatch.draw(background_2, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //else spriteBatch.draw(background_3, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.draw(spriteBatch,random_bg);

        man.draw(spriteBatch);
        spriteBatch.setProjectionMatrix(camera.combined);
        ball.draw(spriteBatch);
        if (Ball.gameover) {
            play_btn.draw(spriteBatch, 1);
            high_score.draw(spriteBatch,(Gdx.graphics.getWidth() - high_score.getWidth()) / 2, Gdx.graphics.getHeight()/2.2f);
            high_sc = preferences.getInteger(Ball.SCORE,0);
            high_score.setText("HI "+high_sc);
            label_score.setText("MY "+Ball.point);
            if (Ball.point > high_sc){

                    preferences.putInteger(Ball.SCORE,Ball.point);
                    preferences.flush();

            }
        } else play_btn.draw(spriteBatch, 2);
        label_score.draw(spriteBatch,(Gdx.graphics.getWidth() - label_score.getWidth()) / 2, Gdx.graphics.getHeight()/2.5f);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        Asset.dispose();
    }

    @Override
    public void resize(int w, int h) {
        gameViewport.update(w,h);
    }

    @Override
    public void resume() {

    }


}

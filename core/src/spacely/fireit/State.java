package spacely.fireit;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Workspace on 28/01/2017.
 */
public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 vector;
    protected StateManager stateManager;

    public State(StateManager stateManager){
        this.stateManager = stateManager;
        camera = new OrthographicCamera();
        vector = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
    public  abstract void resize(int w,int h);
    public abstract void resume();
}

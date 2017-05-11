package spacely.fireit;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;


public class StateManager {
    private Stack<State> states;

    public StateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public void resume() {
        states.peek().resume();
    }
    public void resize(int w,int h){
        states.peek().resize(w,h);
    }
}

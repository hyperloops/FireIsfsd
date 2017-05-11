package spacely.fireit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import spacely.fireit.GameStates.MenuState;


public class MainScreen extends ApplicationAdapter {
	SpriteBatch spriteBatch;
StateManager stateManager;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		stateManager = new StateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Asset.load();
		Asset.manager.finishLoading();
		stateManager.push(new MenuState(stateManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(spriteBatch);
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		Asset.dispose();
	}
	@Override
	public void resume() {
		super.resume();

		stateManager.resume();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stateManager.resize(width,height);

	}
}

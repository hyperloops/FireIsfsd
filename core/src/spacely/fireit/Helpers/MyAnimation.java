package spacely.fireit.Helpers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import spacely.fireit.MyObjects.Ball;

/**
 * Created by Workspace on 03/02/2017.
 */

public class MyAnimation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;
    public static boolean animate = false;
    public static boolean kickball = false;
    private TextureRegion textureRegion;

    public MyAnimation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;


        for (int i = 0; i < frameCount; i++) {
            textureRegion = new TextureRegion();
            textureRegion.setRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight());
            frames.add(textureRegion);
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt, Ball ball) {
        if (animate) {
            currentFrameTime += dt;
            if (currentFrameTime > maxFrameTime) {
                frame++;
                currentFrameTime = 0;
            }
            if (frame >= frameCount) {
                frame = 0;
                animate = false;
                Ball.soundtrue = 0;
            }
            if (frame ==5) ball.kick();

        }

    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }

}

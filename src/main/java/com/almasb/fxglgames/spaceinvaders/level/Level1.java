package com.almasb.fxglgames.spaceinvaders.level;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.control.RandomMoveControl;
import com.almasb.fxglgames.spaceinvaders.Config;
import javafx.geometry.Rectangle2D;

import static com.almasb.fxgl.app.DSLKt.geti;
import static com.almasb.fxglgames.spaceinvaders.Config.*;

/**
 * @author Almas Baimagambetov
 * modified by Mateusz Klekocki
 */
public class Level1 extends SpaceLevel {

    @Override
    public void init() {
        for (int x = 0; x < ENEMIES_PER_LEVEL; x++) {
            spawnEnemy(x * (WIDTH / ENEMIES_PER_LEVEL), HEIGHT / 2);
        }
    }

    @Override
    public void destroy() {

    }
}

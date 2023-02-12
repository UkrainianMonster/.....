package ru.myitschool.sungdx;

import static ru.myitschool.sungdx.MyGdx.SCR_HEIGHT;
import static ru.myitschool.sungdx.MyGdx.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;

public class ScreenIntro implements Screen {
    MyGdx c;

    Texture imgBG;

    TextButton btnPlay, btnSettings, btnAbout, btnExit;

    public ScreenIntro(MyGdx context){
        c = context;
        // создание изображений
        imgBG = new Texture("winter1.jpg");
        btnPlay = new TextButton(c.fontLarge, "PLAY", 650);
        btnSettings = new TextButton(c.fontLarge, "SETTINGS", 550);
        btnAbout = new TextButton(c.fontLarge, "ABOUT", 450);
        btnExit = new TextButton(c.fontLarge, "EXIT", 350);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            c.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            c.camera.unproject(c.touch);
            if(btnPlay.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenGame);
            }
            if(btnSettings.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenSettings);
            }
            if(btnExit.hit(c.touch.x, c.touch.y)) {
                Gdx.app.exit();
            }
        }
        // отрисовка всей графики
        c.camera.update();
        c.batch.setProjectionMatrix(c.camera.combined);
        c.batch.begin();
        c.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(c.batch, c.text.get(btnPlay.text)[c.lang], btnPlay.x, btnPlay.y);
        btnSettings.font.draw(c.batch, c.text.get(btnSettings.text)[c.lang], btnSettings.x, btnSettings.y);
        btnAbout.font.draw(c.batch, c.text.get(btnAbout.text)[c.lang], btnAbout.x, btnAbout.y);
        btnExit.font.draw(c.batch, c.text.get(btnExit.text)[c.lang], btnExit.x, btnExit.y);
        c.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

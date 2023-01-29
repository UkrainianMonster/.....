package ru.myitschool.sungdx;

import static ru.myitschool.sungdx.MyGdx.SCR_HEIGHT;
import static ru.myitschool.sungdx.MyGdx.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;

public class ScreenSettings implements Screen {
    MyGdx c;

    Texture imgBG;

    TextButton btnPlay, btnSettings, btnAbout, btnExit;

    public ScreenSettings(MyGdx context){
        c = context;
        // создание изображений
        imgBG = new Texture("winter2.jpg");
        btnPlay = new TextButton(c.fontLarge, "ЗВУК", 600, 650);
        btnSettings = new TextButton(c.fontLarge, "МУЗЫКА", 600, 550);
        btnAbout = new TextButton(c.fontLarge, "ЧТО-ТО", 600, 450);
        btnExit = new TextButton(c.fontLarge, "ВЫХОД", 600, 350);
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
            if(btnExit.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenIntro);
            }
        }
        // отрисовка всей графики
        c.camera.update();
        c.batch.setProjectionMatrix(c.camera.combined);
        c.batch.begin();
        c.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(c.batch, btnPlay.text, 0, btnPlay.y, SCR_WIDTH, Align.center, true);
        btnSettings.font.draw(c.batch, btnSettings.text, 0, btnSettings.y, SCR_WIDTH, Align.center, true);
        btnAbout.font.draw(c.batch, btnAbout.text, 0, btnAbout.y, SCR_WIDTH, Align.center, true);
        btnExit.font.draw(c.batch, btnExit.text, 0, btnExit.y, SCR_WIDTH, Align.center, true);
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

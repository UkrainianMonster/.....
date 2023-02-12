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

    TextButton btnSound, btnMusic, btnLanguage, btnExit;

    public ScreenSettings(MyGdx context){
        c = context;
        // создание изображений
        imgBG = new Texture("winter2.jpg");
        btnSound = new TextButton(c.fontLarge, "SOUND ON", 600, 650);
        btnMusic = new TextButton(c.fontLarge, "MUSIC OFF", 600, 550);
        btnLanguage = new TextButton(c.fontLarge, "LANGUAGE", 600, 450);
        btnExit = new TextButton(c.fontLarge, "EXIT", 600, 350);
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
            if(btnSound.hit(c.touch.x, c.touch.y)) {
                c.screenGame.soundOn = !c.screenGame.soundOn;
                if(c.screenGame.soundOn) btnSound.text = "SOUND ON";
                else btnSound.text = "SOUND OFF";
            }
            if(btnMusic.hit(c.touch.x, c.touch.y)) {
                c.screenGame.musicOn = !c.screenGame.musicOn;
                if(c.screenGame.musicOn) btnMusic.text = "MUSIC ON";
                else btnMusic.text = "MUSIC OFF";
            }
            if(btnLanguage.hit(c.touch.x, c.touch.y)) {
                c.lang = c.lang==0 ? 1 : 0;
            }
            if(btnExit.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenIntro);
            }
        }
        // отрисовка всей графики
        c.camera.update();
        c.batch.setProjectionMatrix(c.camera.combined);
        c.batch.begin();
        c.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnSound.font.draw(c.batch, c.text.get(btnSound.text)[c.lang], btnSound.x, btnSound.y);
        btnMusic.font.draw(c.batch, c.text.get(btnMusic.text)[c.lang], btnMusic.x, btnMusic.y);
        btnLanguage.font.draw(c.batch, c.text.get(btnLanguage.text)[c.lang], btnLanguage.x, btnLanguage.y);
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

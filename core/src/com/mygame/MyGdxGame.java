package com.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygame.game.characters.Class.BaseHero;
import com.mygame.game.characters.Init;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, magician, prist, peasant, robber, sniper, spearMan;
	Music music;

	public static ArrayList<BaseHero> teamWhite;
	public static ArrayList<BaseHero> teamBlack;
	public static int step = 0;
	private static float dx, dy;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/"+String.valueOf(new Random().nextInt(5))+".png");
		music = Gdx.audio.newMusic(
				Gdx.files.internal(
						"music/paul-romero-rob-king-combat-theme-0"+String.valueOf(new Random().nextInt(4)+1)+".mp3"));
		music.setVolume(.125f);
		music.setLooping(true);
		music.play();
		Init.createTeams();

		int my = 0;
		crossBowMan = new Texture("units/CrossBowMan.png");
		my = crossBowMan.getHeight();
		magician =  new Texture("units/Mage.png");
		if (my < magician.getHeight()) my = magician.getHeight();
		peasant = new Texture("units/Peasant.png");
		if (my < peasant.getHeight()) my = peasant.getHeight();
		prist = new Texture("units/Monk.png");
		if (my < prist.getHeight()) my = prist.getHeight();
		robber = new Texture("units/Rouge.png");
		if (my < robber.getHeight()) my = robber.getHeight();
		sniper = new Texture("units/Sniper.png");
		if (my < sniper.getHeight()) my = sniper.getHeight();
		spearMan = new Texture("units/SpearMan.png");
		if (my < spearMan.getHeight()) my = spearMan.getHeight();
		dx = dy = Gdx.graphics.getHeight() / 10;

	}

	@Override
	public void render () {
		if (step == 0) Gdx.graphics.setTitle("Первый ход."); else Gdx.graphics.setTitle("Ход №"+step);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		teamBlack.forEach(n -> {
			switch (n.getTYPE()){
				case "Robber":
					if (n.isAlive())batch.draw(robber, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
				case "Peasant":
					if (n.isAlive())batch.draw(peasant, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
				case "Sniper":
					if (n.isAlive())batch.draw(sniper, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
				case "Prist":
					if (n.isAlive())batch.draw(prist, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy); break;
			}
		});

		teamWhite.forEach(n -> {
			switch (n.getTYPE()) {
				case "Magician":
					if (n.isAlive())batch.draw(magician, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
				case "Peasant":
					if (n.isAlive())batch.draw(peasant, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
				case "Spearman":
					if (n.isAlive())batch.draw(spearMan, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
				case "Crossbowman":
					if (n.isAlive())batch.draw(crossBowMan, n.getPosition().getX()*dx, (n.getPosition().getY()-1)*dy);break;
			}
		});


		batch.end();


		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			step++;
			Init.makeStep();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}

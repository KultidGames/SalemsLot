package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.Game;
import Game.gfx.ImageManager;

public class Player{

	private int x, y, xo, yo, xs,ys;
	private ImageManager im;
	public boolean up = false, dn = false, lt = false, rt = false;
	public BufferedImage player1, player2, player3, player4;
	private final int SPEED = 8, SIZE = 16; //Collision Size
	public int health=10;
	
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		xo=0;
		yo=0;
		xs=0;
		ys=0;
		this.im = im;
	}
	public void tick(){
		xs=0;
		ys=0;
		if (up){
			ys-= SPEED;
		}else if (dn){
			ys += SPEED;
		}else if (lt){
			xs -= SPEED;
		}else if (rt){
			xs += SPEED;
		}
		move(xs, ys);
	}
	
	public void move(int xs, int ys){
		if (!collision(xs, 0)){
		xo += xs;
		}
		if (!collision(0, ys)){
			yo += ys;
			}
	}
	private boolean collision(int xs, int ys){
		if(Game.getLevel().getTile((xo + xs + x) / (16 * Game.SCALE), (yo + ys + y) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x + SIZE * Game.SCALE - 1) / (16 * Game.SCALE), (yo + ys + y) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x) / (16 * Game.SCALE), (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE)).isSolid())
			return true;
		if(Game.getLevel().getTile((xo + xs + x + SIZE * Game.SCALE) / (16 * Game.SCALE), (yo + ys + y + SIZE * Game.SCALE) / (16 * Game.SCALE)).isSolid())
			return true;
		
		return false;
	}
	public void render(Graphics g){
		g.drawImage(im.player, x,y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
	public int getXo(){
		return xo;
	}
	public int getYo(){
		return yo;
	}
}

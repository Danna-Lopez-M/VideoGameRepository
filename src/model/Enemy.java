package model;

import java.util.Random;

public class Enemy{

    private String name;
    private Type type;
    private int subtrScr;
    private int sumScr;
    private int posX;
    private int posY;
    private int level;


    public Enemy(String name, int type, int subtrScr, int sumScr, int level){
        this.name = name;
        this.type = Type.values()[type];
        this.subtrScr = subtrScr;
        this.sumScr = sumScr;
        
        Random newRandom = new Random();
        
        this.posX = newRandom.nextInt(1280);
        this.posY = newRandom.nextInt(720);
        
        this.level = level;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSubtrScr(){
        return subtrScr;
    }

    public void setSubtrScr(int subtrScr){
        this.subtrScr = subtrScr;
    }

    public int getSumScr(){
        return sumScr;
    }

    public void setSumScr(int sumScr){
        this.sumScr = sumScr;
    }

    public int getPosX() {
		return posX;
	}

    public void setPosX(int posX) {
		this.posX = posX;
	}

    public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
    public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String toString() {
        return "\nEnemy information:"
        + "\n Name: " + this.name
        + "\n Type: " + this.type
        + "\n Score that removes: " + this.subtrScr
        + "\n Score that adds: " + this.sumScr
        + "\n Position X: " + this.posX
        + "\n Position Y: " + this.posY;
    }
}
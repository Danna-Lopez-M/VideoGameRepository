package model;

import java.util.Random;

public class Treasure{

    private String name;
    private String uRL;
    private int givSc;
    private int posX;
    private int posY;
    private int level;

    public Treasure(String name, String uRL, int givSc, int level){
        this.name = name;
        this.uRL = uRL;
        this.givSc = givSc;
        
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

    public String getURL() {
		return uRL;
	}

	public void setURL(String uRL) {
		this.uRL = uRL;
	}

    public int getGivSc() {
		return givSc;
	}

	public void setGivSc(int givSc) {
		this.givSc = givSc;
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
        return "\nLevel information:"
        + "\n Name: " + this.name
        + "\n Image of treasure: " + this.uRL
        + "\n Score that gives: " + this.givSc
        + "\n Position X: " + this.posX
        + "\n Position Y: " + this.posY 
        + "\n";
    }
}
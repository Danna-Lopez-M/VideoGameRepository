package model;

public class Level{

    private int num;
    private int necScore;
    private Enemy[] enemyList;
    private Treasure[] treasureList;
    
    public Level(int num, int necScore){
        this.num = num;
        this.necScore = necScore;
        this.enemyList = new Enemy[25];
        this.treasureList = new Treasure[50];
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNecScore() {
        return this.necScore;
    }

    public void setNecScore(int necScore) {
        this.necScore = necScore;
    }

    public void addEnemy(Enemy eny) {

		for (int i = 0; i < enemyList.length; i++) {
			if (enemyList[i] == null) {
				enemyList[i] = eny;
			}
		}
	}

    public void addTreasure(Treasure trsr) {

		for (int i = 0; i < treasureList.length; i++) {
			if (treasureList[i] == null) {
				treasureList[i] = trsr;
				
			}
		}
		
	}

    public String TreasuresEnemies(){
        String msg = "";

        return msg;
    }
    
    public String toString() {
        return "\nLevel information:"
        + "\n Name: " + this.num
        + "\n Necessary score: " + this.necScore;
    }
}
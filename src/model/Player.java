package model;

public class Player{

    private String nickname;
    private String name;
    private int score;
    private int lives;
    private Level level;

	public Player(String nickname, String name, Level level){
        this.nickname = nickname;
        this.name = name;
        this.score = 10;
        this.lives = 5;
        this.level = level;
    }

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
    public String toString() {
        return "\nPlayer information:"
        + "\n Nickname: " + this.nickname
        + "\n Name: " + this.name
        + "\n Score: " + this.score
        + "\n Lives: " + this.lives
        + "\n ";
    }
}
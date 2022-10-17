package model;

public class VideoGameController{

    private Player[] players;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private Level[] levels;

    public VideoGameController() {
        this.players = new Player[20];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
        this.levels = new Level[10];
    }

	/**Description: This method register the players
	 * @param nickname String
	 * @param name String
	 * @return boolean. A boolean that shows if the player was created or not.
	 */
    public boolean registerPlayer(String nickname, String name){
        Player newPlayer = new Player(nickname, name, levels[0]);

        for (int i=0; i<players.length; i++){
            if(players[i]==null){
                players[i] = newPlayer;
                return true;
            }
        }

        return false;
    }

	/**Description: This method show the players that have been registered
	 * @return playe String. Shows the list of players that have been created or 
	 * if none player have been created yet.
	 */
    public String showPlayer() {
		String playe = "";

		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				playe += (i+1) + ". " + players[i].toString();
			}
		}

		if (playe.equals("")) {
			playe = "No Player registered yet\n ";
		}

		return playe;
	}
    
    /**Description: This method search the player
	 * @param nickname String
	 * @return Player. An object that shows if the player was found or not.
	 */
    public Player searchPlayer(String nickName){
        Player player = null;
        boolean find= false;
        for (int i = 0; i < players.length && !find; i++) {
            if (players[i] != null && players[i].getNickname().equals(nickName)) {
                player = players[i];
                find=true;
            }
        }

        return player;
    }
    
    /**Description: This method modify the score of one player
	 * @param nickname String
	 * @param score int
	 * @return msg. A String that shows if the score was modify or not.
	 */
    public String modifyScore(String nickname, int newScore) {
		String msg = "";
        Player player = searchPlayer(nickname);
        
        if (player!=null) {
        	player.setScore(newScore);
        	
        	if (newScore<0) {
        		msg = "It is not possible to modify the player's score by a negative number";
        	}
        }
        else {
        	msg = "You misspelled the nickname of the player";
        }
		return msg;
	}
    
    /**Description: This method change the level of one player
	 * @param nickname String
	 * @return msg. A String that shows if the level was modify or not. if not, 
	 * it shows how many points the player needs to advance to the next level
	 */
    public String changePlayerLevel(String nickName){
        String msg = "Level changed succesfully";
        Player player = searchPlayer(nickName);
        if (player!=null){
            Level level = player.getLevel();
            int scoreplayer = player.getScore();
            
            if(level.getNecScore()<scoreplayer) {
            	int newLevel = level.getNum()+1;
            	
            	if (newLevel<(levels.length-1)) {
            		player.setLevel(levels[newLevel]);
            		msg += " to " + player.getLevel().getNum();
            	}
            }
            else {
                if (level.getNum()==10) {
                    msg = "The player is in the last level";
                }
                else {
                	msg = "The player doesn't have enough score.";
                    msg +=" Missing "+(level.getNecScore()-scoreplayer)+" points to reach the next level";
                }
            }
        }
        else {
            msg = "The player doesn't exist";
        }
        
        return msg;
    }
    
    public int[] getTop(int[] array) {

		int mayor[] = new int[2];

		for (int x = 0; x < array.length; x++) {

			if (array[x] > mayor[0]) {
				mayor[0] = array[x];
				mayor[1] = x;
			}

		}

		return mayor;

	}

	public int[] getAllScores(){
		int[] scores = new int[20];

		for (int i=0; i<players.length; i++) {
			int playerSc = players[i].getScore();
			scores[i] = playerSc;
		}
		
		return scores;
	}

	public int[] getOrderedScores(int[] scores) {

		int[] puntajeActual = scores;

		int[] puntajeOrdenado = new int[20];

		for (int y = 0; y < puntajeActual.length; y++) {

			int[] result = getTop(puntajeActual);
			puntajeOrdenado[y] = result[0];
			puntajeActual[result[1]] = -1;

		}

		showTop5(puntajeOrdenado);

		return puntajeOrdenado;

	}

	public void showTop5(int[] orderedArray) {

		for (int i = 0; i < orderedArray.length; i++) {

			System.out.println("Top " + (i + 1) + " . " + orderedArray[i]);

		}

	}

	/**Description: This method created the levels
	 * @param num int
	 * @param score int
	 * @return boolean. A boolean that shows if the levels was created or not.
	 */
    public boolean createdLvl(int num, int score){
        Level level = new Level(num, score);

        for (int i=0; i<levels.length; i++ ){
            if (levels[i]==null){
                levels[i]=level;
                return true;
            }
        }

        return false;
    }

	/**Description: This method show the levels that were created automatically
	 * @return lev String. Shows the list of levels that have been created 
	 * or if none level have been created yet.
	 */
    public String showLevel() {
		String lev = "";

		for (int i = 0; i < levels.length; i++) {
			if (levels[i] != null) {
				lev += levels[i].toString();
			}
		}

		if (lev.equals("")) {
			lev = "No Player registered yet\n ";
		}

		return lev;
	}

	/**Description: This method show the possible types of the enemies
	 * @return msg String. Shows the list of the possible types that have a enemie
	 */
    public String showTEnm() {
        String msg = "";
        for (int i=0; i<Type.values().length; i++){
           msg += "\n" + (i+1) + ". " + Type.values()[i];
        }

        return msg;
    }

	/**Description: This method register the enemies
	 * @param name String
	 * @param type int
	 * @param subtrScr int
	 * @param sumScr int
	 * @return boolean. A boolean that shows if the enemy was created or not.
	 */
    public boolean registerEnemy(String name, int type, int subtrScr, int sumScr, int numLvL){
        Enemy newEnemy = new Enemy(name, type, subtrScr, sumScr, numLvL);

        for (int i=0; i<enemies.length; i++){
            if (enemies[i]==null){
                enemies[i] = newEnemy;
                return true;
            }
        }

        return false;
    }

	/**Description: This method show the enemies that have been registered
	 * @return enem String. Shows the list of the enemies that have been created
	 */
    public String showEnemy() {
		String enem = "";

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				enem += enemies[i].toString();
			}
		}

		if (enem.equals("")) {
			enem = "No Enemies registered yet\n ";
		}

		return enem;
	}

	/*Description: This method add one enemy to a level selected for the user
	 * @param EnmName String
	 * @param numLvL int
	 * @return addEL String. Shows if the enemy was added to the level or not
	 */
    /*public String addEnemyToLevel(String EnmName, int numLvL) {
		Enemy nmy = null;
		Level lv = null;
		boolean found = false;
		String addEL = "";
		for (int i = 0; i < enemies.length && !found; i++) {
			if (enemies[i] != null && enemies[i].getName().equals(EnmName)) {
				nmy = enemies[i];
				found = true;
			}
		}
		found = false;
		for (int i = 0; i < levels.length && !found; i++) {
			if (levels[i] != null && levels[i].getNum()==numLvL) {
				lv = levels[i];
				found = true;
			}
		}
		if (nmy != null && lv != null) {
			lv.addEnemy(nmy);
			addEL = "Enemy added to level successfully";
		} else if (nmy == null || lv == null) {
			addEL = "Enemy wasn't add to a level";
		}

		return addEL;
	}*/
    
    /**Description: This method count the enemies that have the same type in all the levels
     * @param type int The type of enemies search
	 * @return msg String. Shows the amount of consonants each name
	 */
    public String enemiesAllLevels(int type) {
		String msgte = "";
		String msg = "";
		
		int count = 0;
		
		for (int i=0; i < enemies.length; i++) {
			if (enemies[i]!=null) {
				if(type==1) {
					msgte = "" + Type.values()[0];
					count++;
				}
				else if (type==2) {
					msgte = "" + Type.values()[1];
					count++;
				}
				else if (type==3) {
					msgte = "" + Type.values()[2];
					count++;
				}
				else if (type==4) {
					msgte = "" + Type.values()[3];
					count++;
				}
			}	
		}	
		
		msg = "The amount of enemies " + msgte + " in the game is " + count;

		return msg;
	}
    
    /**Description: This method count the consonants in the name of each enemy
	 * @return msg String. Shows the amount of consonants each name
	 */
	public String countCnsEnmName(){
		String msg = "";
		int count = 0;

		for(int i=0; i<enemies.length; i++){
			if(enemies[i]!=null){
				String nameEnemy = enemies[i].getName().toLowerCase();
				for (int j=0; j<nameEnemy.length(); j++){
					if (nameEnemy.charAt(j)!='a' && nameEnemy.charAt(j)!='e' && nameEnemy.charAt(j)!='i' &&
					nameEnemy.charAt(j)!='o' && nameEnemy.charAt(j)!='u'){
						count++;
					}
				}
				msg += "The mount of consonants in the name of the enemy " 
						+ nameEnemy + " is " + count + "\n";
			}
		}
		return msg;
	}
	
	/**Description: This method show the enemy that gives more score to the player
	 * @return msg String. Shows the name and level of that enemy
	 */
	public String mostScoreEnm() {
		String msg = "";
		String nameEnCom = "";
		String nameEnMost = "";
		int levelCom = 0;
		int levelMost = 0;
		int scoreCom = 0;
		int countCom = 0;
		int scoreMost = 0;
		int countMost = 0;
		
		for (int i=0; i < enemies.length; i++) {
			if (enemies[i]!=null) {
				scoreMost = enemies[i].getSumScr();
				nameEnMost = enemies[i].getName();
				levelMost = enemies[i].getLevel();
				
				for (int k=0; k<enemies.length; k++) {
					if (enemies[k]!=null) {
						scoreCom = enemies[k].getSumScr();
						nameEnCom = enemies[k].getName();
						levelCom = enemies[k].getLevel();
						
						if (scoreMost==scoreCom) {
							countCom ++;
						}
					}
					
					if (countMost < countCom) {
						countMost = countCom;
						scoreMost = scoreCom;
						nameEnMost = nameEnCom;
					}
					
					if (countMost==countCom) {
						 msg = "There are two enemies that gives the same points to the player. They are "+
					nameEnMost + " and " + nameEnCom + " with " + scoreMost + " points" + " in the levels "
								 + levelMost + " and " + levelCom;
					}
				}
			}
		}
		
		msg= "The enemy " + nameEnMost + " is the one that gives most score to the player " +
		" with " + scoreMost + " points. In the level " + levelMost;
		
		return msg;
	}

	
	/**Description: This method created and add one treasure to a level selected for the user
	 * and repeat it the time that he/she/they wants
	 * @param name String The name of the treasure
	 * @param url String The URL that leads to the treasure image
	 * @param givSc int The score the treasure gives the player
	 * @param numLvL int It's the identifier f the level
	 * @param times int It's the amount that a treasure is repeat on a level
	 * @return boolean. A boolean that shows if the treasure was added to the level or not
	 */
	public boolean addTreasureToLevel(String name, String url, int givSc, int numLvL, int times) {
		Level lv = null;
		boolean found = false;
		int count = times;

		
		for (int i = 0; i < levels.length && !found; i++) {
			if (levels[i] != null && levels[i].getNum()==numLvL) {
				lv = levels[i];
				found = true;
			}
		}
		
		if(found && lv!=null) {
			for (int i=0; i<treasures.length && count>0; i++){
				if (treasures[i]==null){
					Treasure newTreasure = new Treasure(name, url, givSc, numLvL);
					treasures[i] = newTreasure;
					count= count-1;
				}
			}
			if(count==0){
				return true;
			}
		}
		return false;
	}
	
	/**Description: This method show the treasures that have been registered
	 * @return treas String. Shows the list of the treasures that have been created
	 */
	public String showTreasure() {
		String treas = "";

		for (int i = 0; i < treasures.length; i++) {
			if (treasures[i] != null) {
				treas += treasures[i].toString();
			}
		}

		if (treas.equals("")) {
			treas = "No Treasure registered yet\n ";
		}

		return treas;
	}
	
	/**Description: This method count and show the treasures select by the user in all the levels of the game
	 * @param name String. The name of treasures that are going to be search
	 * @return msg String. Shows the list of the enemies that have been created
	 */
	public String treasuresAllLevels(String name) {
		String msg = "";
		int count = 0;
		
		for (int i=0; i < treasures.length; i++) {
			if (treasures[i]!=null) {
				String treasureName= treasures[i].getName();
				if(treasureName.equals(name)) {
					count++;
				}
			}	
		}	
		
		msg += "The amount of treasures " + name + " in the game is " + count;

		return msg;
	}
	
	/**Description: This method count and show the most repeat treasure in all the game
	 * @return msg String. Shows the most repeated treasure
	 */
	public String mostRepeatTrsr() {
		String msg = "";
		String nameCom = "";
		int countCom = 0;
		String mostRepeat = "";
		int countMost = 0;
		
		for (int i=0; i < treasures.length; i++) {
			if (treasures[i]!=null) {
				mostRepeat = treasures[i].getName();
				
				for (int k=0; k<treasures.length; k++) {
					if (treasures[k]!=null) {
						nameCom = treasures[k].getName();
						if (mostRepeat.equals(nameCom)) {
							countCom ++;
						}
					}
					
					if (countMost < countCom) {
						countMost = countCom;
						mostRepeat = nameCom;
					}
				}
			}
		}
		
		msg= "The treasure " + mostRepeat + " is the most repeated in all the levels of the game " +
		" with a total of " + countMost + " times.";
		
		return msg;
	}
	
	/**Description: This method show all the treasures and enemies in a level 
	 * selected for the user
	 * @param level int The level where the enemies and treasures and going to be search
	 * @return msg String. Shows the treasures and enemies
	 */
	public String trAndEneLevel(int level) {
		String msgt = "";
		String msge = "";
		String msg = "";
		
		if (levels[level]!=null) {
			msgt = "The treasure(s) in the level " + level +
					" is(are): " ;
			for (int i=0; i<treasures.length; i++) {
				if(treasures[i]!=null && (treasures[i].getLevel())==level) {
					String treasName = treasures[i].getName();
					msgt += treasName + ", ";
				}
				else if(treasures[i]==null) {
					msgt = "In the level there are no treasures, ";
				}
			}
			
			msge = "The enemy(enemies) in the level " + level +
					" is(are): ";
			for (int i=0; i<enemies.length;i++) {
				if(enemies[i]!=null && (enemies[i].getLevel())==level) {
					String enmName = enemies[i].getName();
					msge += enmName + ", ";
				}
				else if (enemies[i]==null) {
					msge = "In the level there are no enemies";
				}
			}
		}
		msg = msgt + msge;
			
		return msg;
	}
	
}
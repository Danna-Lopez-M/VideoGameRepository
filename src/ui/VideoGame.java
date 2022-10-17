package ui;

import model.VideoGameController;
import java.util.Scanner;
import java.util.Random;

public class VideoGame{

    public static Scanner sc = new Scanner(System.in);
    public static Random rd = new Random();
    public static VideoGameController videoController = new VideoGameController();

    public static void main(String[] args){
        createdLvl();
        menu();
    }

    /**Description: This method created all the levels automatically
	 * @return void
	 */
    public static void createdLvl(){
        int score=0;
        boolean control= true;

        for (int i=0; i<10; i++){
            score += rd.nextInt(100);
            control = control && videoController.createdLvl(i+1, score);
        }

        if(control){
            System.out.println("The levels was created successful");
        }
        else{
            System.out.println("Error");
            System.exit(0);
        }
    }
    
    /**Description: This method show to the user a general menu
	 * @return void
	 */
    public static void menu(){
        System.out.println("Welcome");
        boolean exit = false;

        while(!exit){
            System.out.println("Type an option\n1.Player\n2.Enemy\n3.Treasure"
            + "\n4.Exit");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    menuPlayer();
                    break;
                case 2:
                    menuEnemy();
                    break;
                case 3:
                    menuTreasure();
                    break;
                default:
                    System.out.println("Bye bye");
                    exit = true;
                    break;
            }
        }
    }

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a player
	 * @return void
	 */
    public static void menuPlayer(){
        boolean exit = false;

        while(!exit){
            System.out.println("\nType an option\n1. Register a player"+
            "\n2. Show players\n3. Modify the score of one player"+
            "\n4. Change the level of the player\n5. Go back menu");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    System.out.println(videoController.showPlayer());
                    break;   
                case 3: 
                	modifyPlayerScore();
                	break;
                case 4:
                	changePlayerLvL();
                	break;
                case 5:
                    System.out.println("Returning to the menu\n ");
                    exit = true;
                    break;
            }
        }
    }

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a enemy
	 * @return void
	 */
    public static void menuEnemy(){
        boolean exit = false;

        while(!exit){
            System.out.println("\nType an option\n1. Register a enemy\n2. Show enemies"+
            "\n3. Count the amount of enemies that have the same"
            + " type in all the levels of the game\n4. Count the number of consonants in "
            + "the name of each enemy in the video game\n5. Show the enemies and treasures"
            + " in a level\n6. Show the enemy that give more score and the level\n7. Go back menu");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    registerEnemy();
                    break;
                case 2:
                    System.out.println(videoController.showEnemy());
                    break;
                /*case 3:
                    addEnemytolevel();
                    break;*/
                case 3:
                    amountEnmGame();
                    break;
                case 4:
                	consonantsInEnemyName();
                    break;
                case 5:
                	enemiesAndTreasuresOneLevel();
                	break;
                case 6:
                	mostScoreEnemy();
                	break;
                case 7:
                    System.out.println("Returning to the menu\n ");
                    exit = true;
                    break;
            }
        }
    }

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a treasure
	 * @return void
	 */
    public static void menuTreasure(){
        boolean exit = false;

        while(!exit){
            System.out.println("\nType an option\n1. Register a treasure in a level\n2. Show treasures"+
            "\n3. Show the count of the same treasure in all the levels\n4. Show the enemies and"
            + " treasures in a level\n5. Show the most repeated treasure \n6. Go back menu");

            int option = sc.nextInt();

            switch(option){
                case 1:
                    addTreasuretolvl();
                    break;
                case 2:
                    System.out.println(videoController.showTreasure());
                    break;
                case 3:
                	amountTrsGame();
                	break;
                case 4:
                	enemiesAndTreasuresOneLevel();
                	break;
                case 5:
                	mostRepeatTreasure();
                	break;
                case 6:
                    System.out.println("Returning to the menu\n ");
                    exit = true;
                    break;
            }
        }
    }

    /**Description: This method register a player
	 * @return void
	 */
    public static void registerPlayer(){
        System.out.println("Type the nickname");
        sc.nextLine();
        String nickname = sc.nextLine();

        System.out.println("Type the name");
        String name = sc.nextLine();

        if (videoController.registerPlayer(nickname, name)){
            System.out.println("Registered player successfully\n ");
        }
        else{
            System.out.println("Error. It was not possible registered the player \n ");
        }
    }
    
    /**Description: This method modify the score of a player selected for the user
	 * @return void
	 */
    public static void modifyPlayerScore(){
        System.out.println("Type the nickname of the player that you want ");
        System.out.println(videoController.showPlayer());
        sc.nextLine();
        String nickname = sc.nextLine();

        System.out.println("Type the new score");
        int score = sc.nextInt();

        System.out.println(videoController.modifyScore(nickname, score));
    }
    
    /**Description: This method changes the level of a player
	 * @return void
	 */
    public static void changePlayerLvL() {
    	System.out.println("Type the nickname of the player that you want ");
        System.out.println(videoController.showPlayer());
        sc.nextLine();
        String nickname = sc.nextLine();
        
        System.out.println(videoController.changePlayerLevel(nickname));
    }

    /**Description: This method register a enemy
	 * @return void
	 */
    public static void registerEnemy(){
        System.out.println("Type the name");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter the type of enemy");
        System.out.println(videoController.showTEnm());
        int type = sc.nextInt();
        type --;
        sc.nextLine();

        System.out.println("Enter a score to subtra when beat a player");
        int subtrScr = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter a score to sum when lose against a player");
        int sumScr = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Select the number/name of the Level that you want to add a enemy to");
		System.out.println(videoController.showLevel());
		int selLvl = sc.nextInt();
        sc.nextLine();

        if (videoController.registerEnemy(name, type,subtrScr,sumScr, selLvl)){
            System.out.println("Registered enemy successfully\n ");
        }
        else{
            System.out.println("Error. It was not possible registered the enemy \n ");

        }
    }

    /*Description: This method add one enemy to a level 
     * chosen by the user
	 * @return void
	 */
    /*public static void addEnemytolevel() {
		System.out.println(videoController.showLevel());
		System.out.println("Select the number/name of the Level that you want to add a enemy to");
		int selLvl = sc.nextInt();
        sc.nextLine();

		System.out.println("Select the NAME of the Enemy to add");
		System.out.println(videoController.showEnemy());
		String selEne = sc.nextLine();

		System.out.println(videoController.addEnemyToLevel(selEne, selLvl));

	}*/
    
    /**Description: This method count the amount of 
     * enemies in the whole video game
	 * @return void
	 */
    public static void amountEnmGame() {
        System.out.println(videoController.showTEnm());
    	System.out.println("\nEnter the type of enemy that you want count");
        sc.nextLine();
        int type = sc.nextInt();
        
        System.out.println(videoController.enemiesAllLevels(type));
    }
    
    /**Description: This method count the consonants in
     * the name of each enemy
	 * @return void
	 */
    public static void consonantsInEnemyName(){
        System.out.println(videoController.countCnsEnmName());
    }
    
    /**Description: This method show the enemy that give more 
     * score in the game and the level where it is
	 * @return void
	 */
    public static void mostScoreEnemy() {
        System.out.println(videoController.mostScoreEnm());
    }

    /**Description: This method register a treasure in a level 
     * chosen by the user the times that the user wants
	 * @return void
	 */
    public static void addTreasuretolvl() {
    	System.out.println("Type the name");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Type the URL");
        String uRL = sc.nextLine();

        System.out.println("Type the score that the treasure gives to the player");
        int givSc = sc.nextInt();

		System.out.println("Select the number/name of the Level that you want to add a treasure to");
		System.out.println(videoController.showLevel());
		int selLvl = sc.nextInt();
        sc.nextLine();

        System.out.println("Type how many do you want that the treasure repeat in the level");
        int times = sc.nextInt();

        if (videoController.addTreasureToLevel(name, uRL, givSc, selLvl, times)){
            System.out.println("Registered treasures successfully\n ");
        }
        else{
            System.out.println("Error. It was not possible registered the treasure \n ");

        }
	}
    
    /**Description: This method show the amount of treasures
     * in the whole video game
	 * @return void
	 */
    public static void amountTrsGame() {
        System.out.println(videoController.showTreasure());
    	System.out.println("Type the name of the treasure");
        sc.nextLine();
        String name = sc.nextLine();
        
        System.out.println(videoController.treasuresAllLevels(name));
    }
    
    /**Description: This method show the treasure 
     *that is the most times in the game
	 * @return void
	 */
    public static void mostRepeatTreasure() {
        System.out.println(videoController.mostRepeatTrsr());
    }
    
    
    
    public static void enemiesAndTreasuresOneLevel() {
    	System.out.println(videoController.showLevel());
		System.out.println("Select the number/name of the Level in where you want to search");
		int selLvl = sc.nextInt();
        sc.nextLine();
        
        System.out.println(videoController.trAndEneLevel(selLvl));
    }
}

import java.io.Console;

public class App {

  public static void main(String[] args) {
    Game myGame = new Game();
    Console myConsole = System.console();
    while (myGame.getGameInProgress()) {
      System.out.println("Please guess a letter");
      System.out.println(myGame.getGameWord().getFormattedWord());
      String userInput = myConsole.readLine().toUpperCase();
      myGame.addGuess(userInput);
      if (!myGame.getLastGuess()) {
        myGame.update();
      }
      else{
        System.out.println("Please enter a different letter that is 1 character!\n\n");
      }
      myGame.setLastGuessTrue();
    }

    System.out.println(myGame.getGameWord().getFormattedWord());
    if(myGame.getWin()){
      System.out.println("Nice work, you guessed it!");
    }
    else{
      System.out.println("You've used up all your guesses!");
    }
  }
}

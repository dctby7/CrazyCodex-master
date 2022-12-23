import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

public class Game {
  private String[] mAnswers = {"BOAT", "HOUSE", "BRIAN", "YUSUF"};
  private Integer mAnswerIndex = -1;
  private List<String> mPastGuesses = new ArrayList<String>();
  private Word gameWord = new Word();
  private boolean mLastGuessNotRepeat = true;
  private boolean gameInProgress = true;
  private boolean win = false;
  private int incorrectAnswerCount = 0;
  public void update(){
    String[] word = gameWord.getWord();
    String[] encodedWord = gameWord.getEncodedWord();
    String wordString = String.join("", word);
    String encodedWordString = String.join("", encodedWord);
    if (wordString.equals(encodedWordString)) {
      gameInProgress = false;
      win = true;
    }
    if (incorrectAnswerCount > 8){
      gameInProgress = false;
    }
  }
  public boolean getWin(){
    return win;
  }
  public List<String> getPastGuesses(){
    return mPastGuesses;
  }
  public boolean getLastGuess(){
    return mLastGuessNotRepeat;
  }
  public void setLastGuessTrue(){
    mLastGuessNotRepeat = true;
  }
  private boolean repeatGuess(String guess){
    if (mPastGuesses.contains(guess) || guess.length() != 1 || !(Pattern.matches("[A-Z]+",guess) ) ){
      mLastGuessNotRepeat = true;
    }else{
      mLastGuessNotRepeat = false;
    }
    return mLastGuessNotRepeat;
  }
  public Game(){
    generateAnswerIndex();
    generateEncodedWord();
    generateWord();
  }
  public Integer getAnswerIndex(){
    return mAnswerIndex;
  }
  private void generateAnswerIndex(){
    Random randomNumber = new Random();
    mAnswerIndex = randomNumber.nextInt(4);
  }
  public void addGuess(String guess){
    if(repeatGuess(guess)){
      return;
    }
    mPastGuesses.add(guess);
    evaluateGuess(guess);
  }
  private void evaluateGuess(String guess){
    String[] word = gameWord.getWord();
    String[] encodedWord = gameWord.getEncodedWord();
    boolean incorrectGuess = true;
    for (int i = 0;i < word.length;i++ ) {
      if (word[i].equals(guess)) {
        encodedWord[i] = guess;
        incorrectGuess = false;
      }
    }
    if (incorrectGuess) {
      incorrectAnswerCount++;
    }
    gameWord.setWord(word);
    gameWord.setEncodedWord(encodedWord);
  }
  public boolean getGameInProgress(){
    return gameInProgress;
  }
  public Word getGameWord(){
    return gameWord;
  }
  private void generateEncodedWord(){
    String word = mAnswers[mAnswerIndex];
    String[] arrayOfChar = word.split("");
    for (int i = 0;i < arrayOfChar.length ;i++ ) {
      arrayOfChar[i] = "_";
    }
     gameWord.setEncodedWord(arrayOfChar);
  }
  private void generateWord(){
    String word = mAnswers[mAnswerIndex];
    String[] arrayOfChar = word.split("");
    gameWord.setWord(arrayOfChar);
  }
}

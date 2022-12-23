import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameTest {
  @Test
  public void getAnswerIndex_confirmRandom_numberBetween0and3() {
    Game testGame = new Game();
    Integer randomNumber = testGame.getAnswerIndex();
    boolean is0or1or2or3 = false;
    if(randomNumber == 0 || randomNumber == 1 || randomNumber == 2 || randomNumber == 3 ){
      is0or1or2or3 = true;
    }
    assertEquals(true,is0or1or2or3);
  }
  @Test
  public void addGuess_confirmAddtoList_A() {
    Game testGame = new Game();
    List<String> expectedList = new ArrayList<String>();
    String guess = "A";
    testGame.addGuess(guess);
    expectedList = testGame.getPastGuesses();
    String expectedGuessAdded = " ";
    if(!expectedList.isEmpty()){
      expectedGuessAdded = expectedList.get(0);
    }
    assertEquals(expectedGuessAdded,guess);
  }
}

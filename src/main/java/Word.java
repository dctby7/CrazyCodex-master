import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Word{
  private String[] word;
  private String[] encodedWord;
  public String getFormattedWord(){
    return String.join(" ", encodedWord);
  }
  public void setWord(String[] wordInput){
    word = wordInput;
  }
  public void setEncodedWord(String[] wordInput){
    encodedWord = wordInput;
  }
  public String[] getWord(){
    return word;
  }
  public String[] getEncodedWord(){
    return encodedWord;
  }
}

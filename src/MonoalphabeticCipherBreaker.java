import java.io.*;
import java.util.HashMap;

public class MonoalphabeticCipherBreaker {

    private HashMap<Character, Character> cipherKey = new HashMap<>();
     //build two arrays to eventually build the map of keys/values
    //if there is a better way to do this please let me know!
    private char keys[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char values[] = {'m', 'j', 'b', 'l', 't', 'y', 'a', 'h', 'w', 's', 'u', 'c', 'i', 'o', 'f', 'e', 'r', 'p', 'q', 'd', 'n', 'x', 'v', 'k', 'z', 'g'};

    public MonoalphabeticCipherBreaker() {

    }

    public void readInput(){
        FileReader inputStream = null;
        FileWriter outputStream = null;
        int c=0;
        //build the map
        for (int i = 0; i < keys.length; i++) {
            cipherKey.put(keys[i], values[i]);
        }
        try{
            inputStream = new FileReader("input file path here");
            outputStream = new FileWriter("output file path here");
            while((c = inputStream.read()) != -1){
                char key = (char) c;
                //check if a letter - don't want to convert digits, special characters, punctuation, etc.
               if(key>='A' && key<='Z') {
                    outputStream.write(cipherKey.get(key));
                }
                else{
                    outputStream.write(c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }catch(NullPointerException e){
            System.out.println("Could not find character " + c);
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }catch (Exception e){
                System.out.println("Error with input/output streams");
            }
        }
    }
}

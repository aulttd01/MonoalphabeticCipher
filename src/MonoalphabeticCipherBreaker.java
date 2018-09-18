import java.io.*;
import java.util.HashMap;

public class MonoalphabeticCipherBreaker {

    private HashMap<Character, Character> cipherKey = new HashMap<>();
    //there is probably a better way to do this - but I hard coded the mappings of characters
    //I didn't want to convert any digits or special characters so they are mapped to themselves.
    private char keys[] = {'&','*',';','/',':','\'',')','(','"','$','-','0','1','2','3','4','5','6','7','8','9',',','.','\r',' ','?','!','\n','\t','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char values[] = {'&','*',';','/',':','\'',')','(','"','$','-','0','1','2','3','4','5','6','7','8','9',',','.','\r',' ','?','!','\n','\t','m', 'j', 'b', 'l', 't', 'y', 'a', 'h', 'w', 's', 'u', 'c', 'i', 'o', 'f', 'e', 'r', 'p', 'q', 'd', 'n', 'x', 'v', 'k', 'z', 'g'};

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
            inputStream = new FileReader("C:\\Users\\63aultyl\\IdeaProjects\\MonoCipherProject\\files\\encypted.txt");
            outputStream = new FileWriter("C:\\Users\\63aultyl\\IdeaProjects\\MonoCipherProject\\files\\decrypted.txt");
            while((c = inputStream.read()) != -1){
                char key = (char) c;
                outputStream.write(cipherKey.get(key));
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

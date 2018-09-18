import java.nio.file.Path;
import java.nio.file.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyAnalyzer {
    final Path file;
    public FrequencyAnalyzer(){

        file = Paths.get("file-path.txt");
    }

    //note - the majority of this logic is NOT original code - credit goes to StackExchange and a working example
    //that featured how to use Java 8's new lambda functions to find the frequency of each character in the text
    //i modified and integrated the code in an object oriented manner to fit this project
    public String getCounts(){
        final String[] result = {""};
        try(final Stream<String> lines = Files.lines(file)){
            final Map<Character, Integer> count =lines.
                    flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt)).
                    filter(Character::isLetter).
                    map(Character::toLowerCase).
                    collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);
            count.forEach((letter, c) -> result[0] +=(letter + " : " + c + "\n"));
        }catch (Exception IOException){
            return "Failed to read file";
        }
        return result[0];
    }
}

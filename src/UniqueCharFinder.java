import java.util.*;
import java.util.stream.Collectors;
public class UniqueCharFinder {

    public static final String SPACE = " ";

    public Optional<Character> findFirstUniqueCharInText(String text) {
        return Optional
                .ofNullable(text)
                .map(text1 -> text1.split(SPACE))
                .map(Arrays::asList)
                .map(this::toUniqueCharacters)
                .flatMap(this::findFirstUniqueCharInWord);
    }

    private String toUniqueCharacters(List<String> list) {
        return list
                .stream()
                .map(this::findFirstUniqueCharInWord)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private Optional<Character> findFirstUniqueCharInWord(String word) {
        return word
                .chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isAlphabetic)
                .filter(c -> word.indexOf(c) == word.lastIndexOf(c))
                .findFirst();
    }

}
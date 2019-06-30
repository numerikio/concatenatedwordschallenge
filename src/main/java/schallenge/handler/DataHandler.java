package schallenge.handler;

import java.util.Collection;

public interface DataHandler {
    boolean isConcatWord(String word, Collection<String> targetCollection);

    Collection<Integer> getNumStrings(String word, Collection<String> targetCollection);

}

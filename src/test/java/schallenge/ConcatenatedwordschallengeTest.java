package schallenge;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import schallenge.executor.TerminalDataExecutor;
import schallenge.handler.DataHandler;
import schallenge.handler.DataHandlerCorrectImpl;
import schallenge.handler.DataHandlerImpl;
import schallenge.provider.ListDataProvider;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConcatenatedwordschallengeTest {
    private List<String> targetList = new ArrayList<>();
    private ConcatenatedWordsFinder finder;
    private DataHandler dataHandler;

    @Before
    public void init() {
        targetList.add("cat");
        targetList.add("cats");
        targetList.add("catas");
        targetList.add("catsdog");
        targetList.add("catdog");
        targetList.add("catgdog");
        targetList.add("catgdogcar");
        targetList.add("dogcat");
        targetList.add("dogcatdog");
        targetList.add("catdogcat");
        targetList.add("catdogcatet");
        targetList.add("catdogcatas");
        targetList.add("catdogcatass");
        targetList.add("catasdog");
        targetList.add("dog");
        targetList.add("et");
        targetList.add("ass");
        targetList.add("asss");
        targetList.add("catd");

        Collections.sort(targetList);

        finder = new ConcatenatedWordsFinderImpl(new ListDataProvider(targetList), new DataHandlerCorrectImpl(), new TerminalDataExecutor());
        dataHandler = new DataHandlerImpl();
    }

    @Test
    public void test1() {
        assertThat(finder.getAllConcatWodrs(targetList), containsInAnyOrder("catasdog", "catdog", "catdogcat", "catdogcatas", "catdogcatass", "catdogcatet", "catsdog", "dogcat", "dogcatdog"));
    }

    @Test
    public void test2() {
        assertThat(dataHandler.isConcatWord("catass", targetList), is(true));
    }


    @Test
    public void test3() {
        assertThat(dataHandler.isConcatWord("cat", targetList), is(false));
    }


}

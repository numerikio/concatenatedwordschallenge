package schallenge;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import schallenge.executor.TerminalDataExecutor;
import schallenge.handler.DataHandler;
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
        targetList.add("cata");
        targetList.add("catdog");
        targetList.add("catgdog");
        targetList.add("catgdogcar");
        targetList.add("dog");
        targetList.add("dogcat");
        targetList.add("dogcatdog");
        targetList.add("catdogcat");
        finder = new ConcatenatedWordsFinderImpl(new ListDataProvider(targetList), new DataHandlerImpl(), new TerminalDataExecutor());
        dataHandler = new DataHandlerImpl();
    }

    @Test
    public void test1() {
        assertThat(finder.getAllConcatWodrs(targetList), containsInAnyOrder("catdog", "dogcat", "dogcatdog", "catdogcat"));
    }

    @Test
    public void test2() {
        assertThat(dataHandler.isConcatWord("catdogcat", targetList), is(true));
    }

    @Test
    public void test3() {
        assertThat(dataHandler.isConcatWord("cat", targetList), is(false));
    }

    @Test
    public void test4() {
        assertThat(dataHandler.getNumStrings("dogcat", targetList), contains(5, 0));
    }
}

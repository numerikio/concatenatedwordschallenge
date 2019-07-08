package schallenge;

import schallenge.executor.DataExecutor;
import schallenge.handler.DataHandler;
import schallenge.provider.DataProvider;

import java.util.*;

public class ConcatenatedWordsFinderImpl extends ConcatenatedWordsFinder {

    static List<String> resultList = new ArrayList<>();


    public ConcatenatedWordsFinderImpl(DataProvider dataProvider, DataHandler dataHandler, DataExecutor dataExecutor) {
        super(dataProvider, dataHandler, dataExecutor);
    }

    @Override
    protected Collection<String> getAllConcatWodrs(Collection<String> targetCollection) {
        for (String s : targetCollection
        ) {
            if (dataHandler.isConcatWord(s, targetCollection)) {
                resultList.add(s);
            }
        }
        return resultList;
    }

    @Override
    protected Collection<String> getSortedColection(Collection<String> strings) {
        List<String> list = (List<String>) strings;
        list.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        return list;
    }
}

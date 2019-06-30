package schallenge;

import schallenge.executor.DataExecutor;
import schallenge.handler.DataHandler;
import schallenge.provider.DataProvider;

import java.util.Collection;

abstract class ConcatenatedWordsFinder {

    protected DataProvider dataProvider;
    protected DataHandler dataHandler;
    private DataExecutor dataExecutor;
    private int quantityWords = 2;

    public ConcatenatedWordsFinder(DataProvider dataProvider, DataHandler dataHandler, DataExecutor dataExecutor) {
        this.dataProvider = dataProvider;
        this.dataHandler = dataHandler;
        this.dataExecutor = dataExecutor;
    }

    public void doWork() {
        Collection<String> collection = dataProvider.getData();
        Collection<String> concatedWordsList = getAllConcatWodrs(collection);
        dataExecutor.writeConcatWords(getSortedColection(concatedWordsList), quantityWords, dataHandler, collection);
        dataExecutor.writeQuantityWords(concatedWordsList);

    }

    abstract protected Collection<String> getAllConcatWodrs(Collection<String> targetCollection);

    abstract protected Collection<String> getSortedColection(Collection<String> strings);

}

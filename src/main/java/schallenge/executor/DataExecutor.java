package schallenge.executor;

import schallenge.handler.DataHandler;

import java.util.Collection;

public interface DataExecutor {
    void writeConcatWords(Collection<String> words, int quantity, DataHandler dataHandler, Collection<String> targetCollection);

    void writeQuantityWords(Collection<String> words);
}

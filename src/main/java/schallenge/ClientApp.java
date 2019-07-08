package schallenge;

import schallenge.executor.TerminalDataExecutor;
import schallenge.handler.DataHandlerCorrectImpl;
import schallenge.handler.DataHandlerImpl;
import schallenge.provider.TextFileDataProvider;

import java.io.File;

public class ClientApp {

    public static void main(String[] args) {

      /*  ConcatenatedWordsFinder finder =  new ConcatenatedWordsFinderImpl(
                new TextFileDataProvider(new File("words.txt")),
                new DataHandlerImpl(),
                new TerminalDataExecutor());
        finder.doWork();*/

        ConcatenatedWordsFinder finder =  new ConcatenatedWordsFinderImpl(
                new TextFileDataProvider(new File("words.txt")),
                new DataHandlerCorrectImpl(),
                new TerminalDataExecutor());
        finder.doWork();

    }
}



package schallenge.executor;

import schallenge.handler.DataHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminalDataExecutor implements DataExecutor {

    private String seporator = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private String seporator2 = "==";
    private String seporator4 = "====================================";
    private String seporator3 = "-";
    private String newLine = "newLine";
    private String thisLine = "thisLine";
    private String next = "next";
    private int corrector = 1;

    @Override
    public void writeConcatWords(Collection<String> words, int quantity, DataHandler dataHandler, Collection<String> targetCollection) {
        ArrayList<String> list = (ArrayList<String>) words;
        print("", next);
        for (int i = 0; i < quantity; i++) {
            print(seporator2 + "The longest concatenated word #" + (i + corrector) + seporator2, newLine);
            print(seporator, newLine);
            print(list.get(i), newLine);
            print(seporator, newLine);
           // printAllCatWord(dataHandler.getNumStrings(list.get(i), targetCollection), targetCollection);
            print(seporator4, newLine);
            print("", next);
        }
    }

    @Override
    public void writeQuantityWords(Collection<String> words) {
        print("The total count of all the concatenated words in the file:" + "\t" + words.size(), newLine);
        print(seporator4, thisLine);
        print(seporator4, newLine);
    }

    private void printAllCatWord(Collection<Integer> numbers, Collection<String> targetCollection) {
        List<String> list = (List<String>) targetCollection;
        for (int i = 0; i < numbers.size(); i++) {
            print(list.get(((ArrayList<Integer>) numbers).get(i)), thisLine);
            if (i < numbers.size() - corrector) {
                print(seporator3, thisLine);
            }
        }
        print("", next);
        print("", next);
        print("Line numbers of words:", newLine);
        for (Integer integer : numbers) {
            print(integer + corrector, newLine);
        }
    }

    private void print(Object s, String tipe) {
        switch (tipe) {
            case "newLine": {
                System.out.println(s);
                break;
            }
            case "thisLine": {
                System.out.print(s);
                break;
            }
            default: {
                System.out.println();
            }
            break;

        }

    }

}

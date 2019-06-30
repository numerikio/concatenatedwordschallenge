package schallenge.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataHandlerImpl implements DataHandler {

    @Override
    public boolean isConcatWord(String word, Collection<String> targetCollection) {
        List<String> targetWord = getCatStringList(word);
        String temp = "";
        boolean result = false;
        int coint = 0;
        for (int i = 0; i < targetWord.size(); i++) {
            temp = addString(temp, targetWord.get(i));
            if (binarySearch((List<String>) targetCollection, temp) >= 0) {
                coint += 1;
                result = true;
                temp = "";
            } else result = false;
        }
        if (coint > 1 && result) {
            result = true;
        } else result = false;
        return result;
    }


    private List<String> getCatStringList(String s) {
        return Arrays.asList(s.split(""));
    }

    private String addString(String s1, String s2) {
        return String.valueOf(new StringBuilder().append(s1).append(s2));
    }

    private int binarySearch(List<String> list, String target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = target.compareTo(list.get(m));
            if (res == 0)
                return m;
            if (res > 0)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    @Override
    public List<Integer> getNumStrings(String word, Collection<String> targetCollection) {
        List<Integer> list = new ArrayList<>();
        List<String> targetWord = getCatStringList(word);
        String temp = "";

        for (int i = 0; i < targetWord.size(); i++) {
            temp = addString(temp, targetWord.get(i));
            if (binarySearch((List<String>) targetCollection, temp) >= 0) {
                list.add(binarySearch((List<String>) targetCollection, temp));
                temp = "";
            }
        }
        return list;
    }


}

package schallenge.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataHandlerCorrectImpl implements DataHandler {

    private List<String> getFirstCatWord(String word, Collection<String> targetCollection) {
        List<String> list = new ArrayList<>();
        List<String> targetWord = getCatStringList(word);
        String temp = "";
        for (int i = 0; i < targetWord.size(); i++) {
            temp = addString(temp, targetWord.get(i));
            if (binarySearch((List<String>) targetCollection, temp) >= 0 && temp.length() != word.length()) {
                list.add(temp);
            }
        }
        return list;
    }

    private List<String> getNextCatWord(String word, Collection<String> targetCollection, List<String> tempList) {
        boolean flag = false;
        List<String> list = new ArrayList<>();

        for (String s : tempList) {
            List<String> targetWord = getCatStringList(word);
            String temp = "";
            for (int i = s.length(); i < targetWord.size(); i++) {
                temp = addString(temp, targetWord.get(i));
                if (binarySearch((List<String>) targetCollection, temp) >= 0) {
                    list.add(s.concat(temp));
                    flag = true;
                }
            }
        }

        for (String d : list
        ) {
            if (d.length() == word.length()) {
                return list;
            }
        }
        if (!flag) {
            return new ArrayList<>();
        } else {
            list = getNextCatWord(word, targetCollection, list);
        }

        return list;
    }

    public boolean isConcatWord(String word, Collection<String> targetCollection) {
        if (getNextCatWord(word, targetCollection, getFirstCatWord(word, targetCollection)).size() != 0) {
            return true;
        }
        return false;
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
    public Collection<Integer> getNumStrings(String word, Collection<String> targetCollection) {

        return new ArrayList<>();

    }
}

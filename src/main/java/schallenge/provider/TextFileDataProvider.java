package schallenge.provider;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class TextFileDataProvider implements DataProvider {

    private File file;

    public TextFileDataProvider(File file){
        this.file=file;
    }

    @Override
    public Collection<String> getData() {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }




}

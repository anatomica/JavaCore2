package Lesson4;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class dz {

    protected static final int NUMBER_LINES_HISTORY = 10;
    protected File file;
    protected final TextArea chatTextArea = null;

    private void getHistory() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<String> history = new LinkedList<>();
            while ((line = bufferedReader.readLine()) != null) {
                history.add(line + '\n');
            }
            bufferedReader.close();
            int numberLinesHistory;
            if (history.size() >= NUMBER_LINES_HISTORY) numberLinesHistory = history.size() - 1 - NUMBER_LINES_HISTORY;
            else numberLinesHistory = 0;
            for (int i = numberLinesHistory; i < history.size();  i++) {
                if (history.size() != 0)
                    chatTextArea.appendText(history.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addInHistory(String msgToView) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(msgToView);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

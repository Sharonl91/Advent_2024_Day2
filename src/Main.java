import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        System.out.println(getAnswer(fileData));

    }

    public static int getAnswer(ArrayList<String> fileData) {
        ArrayList<Integer> levels = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            String[] num = line.split(" ");
            for(int j = 0; j < num.length;j++){
                levels.add(j,Integer.parseInt(num[j]));
                boolean safe = false;
            }

            System.out.println(levels);
        }
        return -1;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
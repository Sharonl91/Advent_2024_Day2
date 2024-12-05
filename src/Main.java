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
        int safeCount = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            String[] num = line.split(" ");
            for(int j = 0; j < num.length;j++){
                levels.add(j,Integer.parseInt(num[j]));
            }
            boolean s = checkSafe(levels);
            if (s){
                safeCount++;
            }
            levels.clear();
        }
        return safeCount;
    }
    public static boolean checkSafe(ArrayList<Integer> levels){
        boolean safe = false;
        boolean in = false;
        boolean de = false;
        for (int i = 1; i < levels.size();i++){
            int a = levels.get(i-1);
            int b = levels.get(i);
            System.out.println(Math.abs(a-b) + "");
            if (Math.abs(a-b) <= 3 && !de || Math.abs(a-b) > 1 && !de){
                safe = true;
                in = true;
            } else if (Math.abs(b-a) <= 3 && !in || Math.abs(b-a) > 1 && !in) {
                safe = true;
                de = true;
            } else return safe;
            System.out.println(safe);
        }
        return safe;
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
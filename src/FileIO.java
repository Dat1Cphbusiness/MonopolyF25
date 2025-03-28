import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public void saveData(ArrayList<String> list, String path, String header){
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(header+"\n");
            for (String s : list) {
                writer.write(s+"\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("problem: "+ e.getMessage());
        }
    }

    public ArrayList<String> readData(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();   //  "tess, 0"
                data.add(line);
            }
        } catch (FileNotFoundException e) {
        }
        return data;
    }

    public String[] readData(String path, int length){
        String[] data = new String[length];
        File file = new File(path);
        int counter = 0;
        try{
          Scanner scan = new Scanner(file);
          scan.nextLine();
          while(scan.hasNextLine()){
              String line = scan.nextLine();
              data[counter] = line;
              counter++;
          }
        } catch(FileNotFoundException e){
            System.out.println("Filen blev ikke fundet " + e.getMessage());

        }
        return data;
    }
}

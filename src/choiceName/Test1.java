package choiceName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //简单随机姓名
        File randomName = new File("randomName.txt");
        File choiceName = new File("choiceName.txt");
        choiceName(randomName,choiceName);


    }
    public static void choiceName(File randomName,File choiceName)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("randomName.txt"));
        ArrayList<String> list = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        Collections.shuffle(list);
        //输出随机姓名
        System.out.println(list.get(0));
        BufferedWriter bw = new BufferedWriter(new FileWriter("choiceName.txt", true));
        bw.write(list.get(0));
        bw.newLine();

        bw.close();
        br.close();
    }
}
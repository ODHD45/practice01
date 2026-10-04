package choiceName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static choiceName.Test1.choiceName;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //权重点名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄-年龄，以及概率");
        int choice = sc.nextInt();
        int choice2 = sc.nextInt();
        double probability = sc.nextDouble();



            choiceName(choice, choice2, probability, 50);


    }

    private static void choiceName(int choice, int choice2, double probability, int count) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("randomName.txt"));
        //读取随机姓名
        String line;
        ArrayList<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        //整理数据
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        for (String s : list) {
            String[] str = s.split("-");
            if (Integer.parseInt(str[1]) >= choice && Integer.parseInt(str[1]) <= choice2) {
                list2.add(s);
            } else {
                list3.add(s);
            }
        }

        //依据概率输出随机姓名
        Random random = new Random();
        BufferedWriter bw = new BufferedWriter(new FileWriter("choiceName.txt", true));
        for (int i = 0; i < count; i++) {

            int r = random.nextInt(100) + 1;

            if (r <= (int) (100 * probability * 100)) {
                Collections.shuffle(list2);
                bw.write(list2.get(0));
                bw.newLine();


            } else {
                Collections.shuffle(list3);
                bw.write(list3.get(0));
                bw.newLine();
            }

        }
        bw.close();





    }
}

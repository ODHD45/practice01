package getName;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class getNameTest {
    public static void main(String[] args) throws IOException {
        //获取网页内容
        String familyNamestr = HttpUtil.get("https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0");
        String Namestr = HttpUtil.get("https://www.mingyannet.com/qiming/1725544692.html");


        //获取数据
        List<String> familyNameTempList = ReUtil.findAll("([\\u4e00-\\u9fa5]{4})(，|。)", familyNamestr, 1);
        List<String> NameTempList = ReUtil.findAll("([\\u4e00-\\u9fa5]{2})(、)", Namestr, 1);


        //整理数据

        ArrayList<String> familyNameList = new ArrayList<>();
        for (String s : familyNameTempList) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                familyNameList.add(c + "");
            }
        }
        ArrayList<String> NameList = new ArrayList<>();
        for (String s : NameTempList) {
            NameList.add(s);

        }
        //生成随机姓名

        ArrayList<String> list = getInfo(familyNameList, NameList, 40);

        //输出随机姓名

        BufferedWriter bw = new BufferedWriter(new FileWriter("randomName.txt", true));
        for (String s : list) {
            bw.write(s+"\n");
        }
        bw.close();
    }

    private static ArrayList<String> getInfo(ArrayList<String> familyNameList, ArrayList<String> nameList, int i) {
        ArrayList<String> Name = new ArrayList<>();
        int age ;
        Random random = new Random();

        for (int j=0; j<i; j++) {
            age = random.nextInt(10)+18;
            Collections.shuffle(familyNameList);
            Collections.shuffle(nameList);
            Name.add(familyNameList.get(0)+nameList.get(0)+"-"+age);
        }
        return Name;
    }
}
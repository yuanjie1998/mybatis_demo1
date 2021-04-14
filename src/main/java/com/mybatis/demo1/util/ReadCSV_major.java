package com.mybatis.demo1.util;



import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author yuan jie
 * @Date 2021/4/7 15:46
 */
//从CSV文件中读取数据
@Component
public class ReadCSV_major {
//    public static void main(String[] args) {
//        ReadCSV_major major = new ReadCSV_major();
//        major.run();
//    }

        public List<Map<String,String>> run(){
            String csv = "src/main/resources/csv/new.csv";
            BufferedReader br = null;
            String line = "";
            //数据中有,号时使用  //进行分割。 这种的好处是只对引号外面的逗号进行分割，对引号内的不分割
            String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
            List<Map<String,String>> dataList = new ArrayList<>();
            try {
                br = new BufferedReader(new FileReader(csv));
                while ((line = br.readLine()) != null){
                    Map<String,String> dataLine = Maps.newHashMap();
                    String[] splitData = line.split(csvSplitBy);
                    for (int i=0; i<=splitData.length-1;i++){
//                        System.out.println((i+1)+"："+splitData[i]);
                        dataLine.put(" "+(i+1),(splitData[i]));
                    }
//                    System.out.println("dataLine："+dataLine);
                    dataList.add(dataLine);
                }
                System.out.println("dataList的值："+dataList);
            }catch (Exception e){
                e.printStackTrace();
            }
            return dataList;
        }
}

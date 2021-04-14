package com.mybatis.demo1.Controller;

import com.mybatis.demo1.util.ReadCSV_major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author yuan jie
 * @Date 2021/4/7 16:47
 */
@RestController
@RequestMapping("/TestCSV")
public class TestCSV {
    @Autowired
    ReadCSV_major csv_major;

    @GetMapping("/getCSVData")
    public List<Map<String,String>> getCSVData(){
        List<Map<String, String>> run = csv_major.run();
        return run;
    }
}

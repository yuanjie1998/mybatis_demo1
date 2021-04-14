package com.mybatis.demo1.util;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.mybatis.demo1.entity.vo.HolidayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 判断今天知否是节假日
 * @Author yuan jie
 * @Date 2021/4/6 13:53
 */
@Slf4j
@Component
public class HolidayUtil {

    //得到当前天的数据 (true为 是节假日 false为不是节假日)
    public boolean getTodayInfo(){
        List<HolidayVo> dateList = this.getCurrentDateInfo();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (HolidayVo date:dateList){
            if (dateFormat.format(date.getSolarDate()).equals(dateFormat.format(new Date()))){
                return date.isVacation();
            }
        }
        return false;
    }

    //得到当前页的全部li中数据
    public List<HolidayVo> getCurrentDateInfo(){
        WebClient webClient = null;
        List<HolidayVo> dateList = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateList = new ArrayList<HolidayVo>();
            webClient = new WebClient();
            HtmlPage page = webClient.getPage("http://hao.360.cn/rili/");
            //最大等待60秒
            for(int k = 0; k < 60; k++){
                if(!page.getElementById("M-dates").asText().equals("")) break;
                Thread.sleep(1000);
            }

            DomNodeList<HtmlElement> htmlElements = page.getElementById("M-dates").getElementsByTagName("li");
            for (HtmlElement element:htmlElements){
                HolidayVo holidayVo = new HolidayVo();
                //得到String类型日期
                holidayVo.setSolarDate(dateFormat.parse(element.getAttribute("date")));

                if (element.getAttribute("class").indexOf("vacation") != -1){
                    //是假期就为true
                    holidayVo.setVacation(true);
                }
                dateList.add(holidayVo);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("数据获取失败!");
        }finally {
            webClient.close();
        }
        return dateList;
    }


}

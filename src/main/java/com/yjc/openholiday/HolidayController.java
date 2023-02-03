package com.yjc.openholiday;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@Slf4j
@RestController
public class HolidayController {


    @GetMapping("/test")
    public Integer getCurrentDataIsHoliday() {
        String currentYear = DateUtil.format(new Date(), "yyyy");
        String currentDate = DateUtil.format(new Date(), "MM-dd");

        log.info("getCurrentDataIsHoliday-{}----{}", currentYear, currentDate);
        String url = "http://timor.tech/api/holiday/year/" + currentYear;
        HttpRequest get = HttpUtil.createGet(url);
        HttpResponse execute = get.execute();
        String s = execute.body();
        if (StrUtil.isNotEmpty(s)) {
            JSONObject jsonObject = JSONUtil.parseObj(s);
            Object holiday = jsonObject.get("holiday");
            JSONObject holidayJsonObj = JSONUtil.parseObj(holiday);
            Set<String> allHolidayDate = holidayJsonObj.keySet();
            log.info("getCurrentDataIsHoliday-{}", allHolidayDate);
            if (ObjectUtil.isNotEmpty(allHolidayDate) && allHolidayDate.contains(currentDate)) {
                return 0;
            } else {
                return 1;
            }
        }
        return 1;
    }

    @GetMapping("/test2")
    public Integer getCurrentDataIsHoliday2() {
        String currentYear = DateUtil.format(new Date(), "yyyy");
        String currentDate = DateUtil.format(new Date(), "MM-dd");

        log.info("getCurrentDataIsHoliday-{}----{}", currentYear, currentDate);
        String url = "http://timor.tech/api/holiday/year/" + currentYear;
        HttpRequest get = HttpUtil.createGet(url);
        HttpResponse execute = get.execute();
        String s = execute.body();
        if (StrUtil.isNotEmpty(s)) {
            JSONObject jsonObject = JSONUtil.parseObj(s);
            Object holiday = jsonObject.get("holiday");
            JSONObject holidayJsonObj = JSONUtil.parseObj(holiday);
            Set<String> allHolidayDate = holidayJsonObj.keySet();
            log.info("getCurrentDataIsHoliday-{}", allHolidayDate);
            if (ObjectUtil.isNotEmpty(allHolidayDate) && allHolidayDate.contains(currentDate)) {
                return 0;
            } else {
                return 1;
            }
        }
        return 1;
    }


}

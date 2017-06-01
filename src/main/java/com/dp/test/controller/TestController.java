package com.dp.test.controller;

import com.dp.test.service.TestConfigFile;
import com.dp.test.service.TestConfigOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dp on 2017/5/24.
 */
@RestController
public class TestController {
    
    @Autowired
    private TestConfigFile testConfigFile;
    
    @Qualifier("testConfigOption")
    @Autowired
    private TestConfigOption testConfigOption;
    
    @Value("${test.value.abc}")
    private String myValue;
    
    /*  @Value("${test.myname}")
        String myname;
        
        @Value("${test.myage}")
        Integer age;
        */
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @ResponseBody
    @RequestMapping("/test")
    public Map<String, Object> test() {
        HashMap<String, Object> map = new HashMap<>();
        String myname = testConfigFile.getMyname();
        Integer age = testConfigFile.getMyage();
        
        map.put("name", myname);
        map.put("age", age);
        map.put("count", testConfigOption.getCount());
        map.put("value", myValue);
    
        logger.debug("map :{}", map);
        return map;
    }
}

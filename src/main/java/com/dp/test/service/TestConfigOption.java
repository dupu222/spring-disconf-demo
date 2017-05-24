package com.dp.test.service;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by dp on 2017/5/24.
 */
@Service
@Scope("singleton")
//@DisconfFile(filename = "wtf.properties")
public class TestConfigOption {
    private String count;
    
    @DisconfItem(key = "test.count",associateField = "count")
    public String getCount() {
        return count;
    }
    
    public void setCount(String count) {
        this.count = count;
    }
}

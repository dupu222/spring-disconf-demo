package com.dp.test.service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by dp on 2017/5/24.
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "test.properties")
public class TestConfigFile {
    
    
    private String myname;
    
    private Integer myage;
    
    @DisconfFileItem(name = "test.myage",associateField = "myage")
    public Integer getMyage() {
        return myage;
    }
    
    public void setMyage(Integer myage) {
        this.myage = myage;
    }
    
    @DisconfFileItem(name = "test.myname",associateField = "myname")
    public String getMyname() {
        return myname;
    }
    
    public void setMyname(String myname) {
        this.myname = myname;
    }
}

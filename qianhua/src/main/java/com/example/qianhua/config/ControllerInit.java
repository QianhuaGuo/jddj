package com.example.qianhua.config;

import com.example.qianhua.requestVo.TestBTO;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletRequest;

/**
 * 初始化绑定参数
 */
public class ControllerInit {
    public static void initBinder(WebDataBinder binder, HttpServletRequest request){
        String catalog = request.getHeader("catalog");
        Object target = binder.getTarget();
        if (target instanceof TestBTO){
            TestBTO testBTO = (TestBTO) target;
            testBTO.setCatalog(catalog);
        }
    }
}

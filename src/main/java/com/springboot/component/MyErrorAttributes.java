package com.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义异常响应数据
 *
 * @ProjectName: springboot-web1
 * @Package: com.springboot.component
 * @ClassName: MyErrorAttributes
 * @Author: gnnt
 * @Date: 2019/1/24 17:19
 * @Version: 1.0
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }
}

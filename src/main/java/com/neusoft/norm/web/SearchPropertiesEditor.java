package com.neusoft.norm.web;

import com.google.common.collect.Maps;
import com.neusoft.norm.domain.vo.Criteria;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.utils.HttpRequestUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.Enumeration;
import java.util.Map;

/**
 * 作者: 张明楠 创建于 16/12/19.
 */
public class SearchPropertiesEditor extends PropertyEditorSupport {

    private static  final String sp  = "search_params-";
    private final Map<String,String> map;
    public SearchPropertiesEditor(){
        map = Maps.newHashMap();
        map.put("is","=");
        map.put("less_than","<");
        map.put("greater_than",">");
        map.put("less_than_equal","<=");
        map.put("greater_than_equals",">=");
        map.put("like","like");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      super.setAsText(text);
    }

    @Override
    public void setValue(Object value) {
        HttpServletRequest request = HttpRequestUtils.getHttpServletRequest();
        SearchParams searchParams = (SearchParams) value;
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            if (StringUtils.startsWith(name,sp)){
                Criteria c = new Criteria();
                String s = StringUtils.removeStart(name,sp);
                c.setProperty(StringUtils.substringBefore(s,"-"));
                c.setValue(request.getParameter(name));
                c.setConjunction(MapUtils.getString(map,StringUtils.substringAfter(s,"-"),"="));
                searchParams.getCriterias().add(c);
            }
        }
        super.setValue(searchParams);
    }

    @Override
    public void setSource(Object source) {
        super.setSource(source);
    }

}

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

    private static final String sp = "sp_";
    private final Map<String, String> map;

    public SearchPropertiesEditor() {
        map = Maps.newHashMap();
        map.put("is", "=");
        map.put("lessThan", "<");
        map.put("greaterThan", ">");
        map.put("lessThanEqual", "<=");
        map.put("greaterThanEquals", ">=");
        map.put("like", "like");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setAsText(text);
    }

    @Override
    public void setValue(Object value) {
        HttpServletRequest request = HttpRequestUtils.getHttpServletRequest();
        SearchParams searchParams = (SearchParams) value;
        StringBuilder sb = new StringBuilder();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String inputName = names.nextElement();
            String inputValue = request.getParameter(inputName);
            if (StringUtils.startsWith(inputName, sp) && StringUtils.isNotEmpty(inputValue)) {
                Criteria c = new Criteria();
                String s = StringUtils.removeStart(inputName, sp);
                String p = StringUtils.substringBefore(s, "_");
                c.setProperty(camel2underscore(p));
                c.setValue(inputValue);
                String e = StringUtils.substringAfter(s, "_");
                c.setConjunction(MapUtils.getString(map, e, "="));
                request.setAttribute(String.format("%s%s_%s", sp, p, e), c.getValue());
                searchParams.getCriterias().add(c);
                sb.append("&" + inputName + "=" + c.getValue());
            }
        }
        request.setAttribute("currentParams", sb.toString());
        super.setValue(searchParams);
    }

    @Override
    public void setSource(Object source) {
        super.setSource(source);
    }


    /**
     * 驼峰转下划线
     *
     * @param camelName
     * @return
     */
    public String camel2underscore(String camelName) {
        if (StringUtils.isNotBlank(camelName)) {
            char[] chars = camelName.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            camelName = new String(chars);
            String regex = "([A-Z][a-z]+)";
            String replacement = "$1_";
            String underscoreName = camelName.replaceAll(regex, replacement);
            underscoreName = underscoreName.toLowerCase().substring(0, underscoreName.length() - 1);
            return underscoreName;
        }
        return null;
    }

}









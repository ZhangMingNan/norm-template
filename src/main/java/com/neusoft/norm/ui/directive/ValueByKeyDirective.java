package com.neusoft.norm.ui.directive;

import com.neusoft.norm.domain.CommonBean;
import com.neusoft.norm.mapper.CommonMapper;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

/**
 * 作者: 张明楠 创建于 16/12/23.
 */
public class ValueByKeyDirective implements TemplateDirectiveModel {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        String prefix = MapUtils.getString(map, "prefix");
        String key = MapUtils.getString(map, "key");
        if (prefix != null) {
            String[] arr = StringUtils.split(prefix, ".");
            if (arr.length == 3) {
                CommonBean bean = new CommonBean();
                bean.setTable(arr[0]);
                bean.setColumn(arr[1]);
                bean.setKeyColumn(arr[2]);
                bean.setKey(key);
                String value = commonMapper.valueByKey(bean);
                if (StringUtils.isNotEmpty(value)) {
                    TextDirectiveBody body = new TextDirectiveBody(value);
                    body.render(environment.getOut());
                }
            }
        }
    }
}

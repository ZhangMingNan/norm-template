package com.neusoft.norm.ui.directive;

import com.neusoft.norm.domain.Dict;
import com.neusoft.norm.mapper.DictMapper;
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
public class DictDirective implements TemplateDirectiveModel {
    @Autowired
    DictMapper dictMapper;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String key = MapUtils.getString(map, "key");
        if (StringUtils.isNotEmpty(key) && StringUtils.contains(key, ".")) {
            String type = StringUtils.substringBefore(key, ".");
            String value = StringUtils.substringAfter(key, ".");

            Dict dict = dictMapper.findByTypeAndValue(type, value);

            if (dict != null) {
                TextDirectiveBody body = new TextDirectiveBody(dict.getLabel());
                body.render(environment.getOut());
            }

        }

    }
}

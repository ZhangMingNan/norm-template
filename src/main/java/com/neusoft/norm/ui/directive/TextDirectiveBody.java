package com.neusoft.norm.ui.directive;

import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;

/**
 * 作者: 张明楠 创建于 16/12/23.
 */
public class TextDirectiveBody  implements TemplateDirectiveBody {
    
    private  String text;

    public TextDirectiveBody(String text) {
        this.text = text;
    }

    @Override
    public void render(Writer writer) throws TemplateException, IOException {
            writer.write(text);
    }
}

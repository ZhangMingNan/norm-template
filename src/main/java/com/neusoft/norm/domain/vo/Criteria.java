package com.neusoft.norm.domain.vo;
import lombok.ToString;
/**
 * 作者: 张明楠 创建于 16/12/19.
 */
@ToString
public class Criteria {
    private String property; //属性
    private String conjunction; //连接词
    private String value;//值

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getConjunction() {
        return conjunction;
    }

    public void setConjunction(String conjunction) {
        this.conjunction = conjunction;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

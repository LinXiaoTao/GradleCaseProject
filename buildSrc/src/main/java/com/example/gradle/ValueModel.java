package com.example.gradle;

/**
 * Created on 2018/5/27 上午11:15
 * leo linxiaotao1993@vip.qq.com
 */
public class ValueModel {

    private final String name;
    private String value;

    public ValueModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ValueModel{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

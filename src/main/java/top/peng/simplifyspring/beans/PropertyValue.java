/*
 * @(#) PropertyValue.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans;

/**
 * PropertyValue 属性值
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/20
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

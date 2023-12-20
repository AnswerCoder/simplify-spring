/*
 * @(#) PropertyValues.java
 *
 * Copyright ⓒ 2023 rebound
 */
package top.peng.simplifyspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues 属性集合
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/20
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}

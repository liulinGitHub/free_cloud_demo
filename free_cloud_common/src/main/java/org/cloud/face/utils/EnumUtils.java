package org.cloud.face.utils;

import org.apache.commons.lang3.StringUtils;
import org.cloud.face.enums.BaseEnum;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取枚举列表
 *
 * @author guohuaming
 * @version 1.0.0
 * @date 2017-06-14
 */
public class EnumUtils {

    private EnumUtils(){}

    /**
     * 用于返回 enum 里面的值
     * @param clazz
     * @return Map的结构， name：名字， value：值
     */
    public static <T> List<Map> enumMap(Class <T> clazz){
        if ( clazz == null || !clazz.isEnum()) {
            throw new InvalidParameterException("非 Enum 操作");
        }
        List<Map> valueNameList = new ArrayList();
        try {
            T[] enumConstants = clazz.getEnumConstants();
            Method methodGetName = clazz.getDeclaredMethod("getName");
            Method methodGetValue = clazz.getDeclaredMethod("getValue");

            for(Object obj : enumConstants) {
                HashMap<String, String> enumMap = new HashMap<>(2);
                enumMap.put("name", (String) methodGetName.invoke(obj));
                enumMap.put("value", (String) methodGetValue.invoke(obj));
                valueNameList.add(enumMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Enum 解析出错");
        } finally {
            return valueNameList;
        }
    }

    /**
     * 用于返回 enum 里面的值
     * @param clazz
     * @return Map的结构， name：名字， value：值
     */
    public static <T> List<Map> enumMap(Class <T> clazz,String location){
        if ( clazz == null || !clazz.isEnum()) {
            throw new InvalidParameterException("非 Enum 操作");
        }
        List<Map> valueNameList = new ArrayList();
        try {
            T[] enumConstants = clazz.getEnumConstants();
            Method methodGetName = clazz.getDeclaredMethod("getName");
            Method methodGetValue = clazz.getDeclaredMethod("getValue");
            Method methodGetLocation = clazz.getDeclaredMethod("getLocation");
            Method methodGetIsReturn = clazz.getDeclaredMethod("getIsReturn");
            for(Object obj : enumConstants) {
                if(StringUtils.isNotBlank(location)){
                    //状态所属位置
                    String enumLocation = (String) methodGetLocation.invoke(obj);
                    //是否返回下拉列表
                    String enumIsReturn = (String) methodGetIsReturn.invoke(obj);
                    if((location.equals(enumLocation) || "3".equals(enumLocation) ) && "1".equals(enumIsReturn)){
                        HashMap<String, String> enumMap = new HashMap<>(2);
                        enumMap.put("name", (String) methodGetName.invoke(obj));
                        enumMap.put("value", (String) methodGetValue.invoke(obj));
                        valueNameList.add(enumMap);
                    }
                }else {
                    HashMap<String, String> enumMap = new HashMap<>(2);
                    enumMap.put("name", (String) methodGetName.invoke(obj));
                    enumMap.put("value", (String) methodGetValue.invoke(obj));
                    valueNameList.add(enumMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Enum 解析出错");
        } finally {
            return valueNameList;
        }
    }

    /**
     * 用于返回 enum 里面的值
     * @param enumStr Enum 类的值
     * @return Map的结构， name：名字， value：值
     */
    public static List<Map> enumMap(String enumStr){
        Object clazz = null;
        try {
            clazz = Class.forName(enumStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enumMap((Class) clazz);
    }


    /**
     * 使用枚举类型对应的value获取枚举对象
     * @param enumClass    枚举类的class
     * @param value  传入的value值，这个方法为String类型
     * @return 枚举对象
     */

    public static <T extends BaseEnum> T getByValue(Class<T> enumClass, String value) {
        //通过反射取出Enum所有常量的属性值
        for (T each: enumClass.getEnumConstants()) {
            //利用value进行循环比较，获取对应的枚举
            if (value.equals(each.getValue())) {
                return each;
            }
        }
        return null;
    }

    /**
     * 使用枚举类型对应的name获取枚举对象
     * @param enumClass    枚举类的class
     * @param name  传入的name值，这个方法为String类型
     * @return 枚举对象
     */

    public static <T extends BaseEnum> T getByName(Class<T> enumClass, String name) {
        //通过反射取出Enum所有常量的属性值
        for (T each: enumClass.getEnumConstants()) {
            //利用name进行循环比较，获取对应的枚举
            if (name.equals(each.getName())) {
                return each;
            }
        }
        return null;
    }

    /**
     * 判断枚举里是否包含name
     * @param enumClass    枚举类的class
     * @param name  传入的name值
     * @return Boolean
     */
    public static <T extends BaseEnum> Boolean contains(Class<T> enumClass, String name) {
        for (T each: enumClass.getEnumConstants()) {
            if (name.equals(each.getName())) {
                return true;
            }
        }
        return false;
    }


//    public static void main(String[] args) {
//        MessageTypeEnum validStatusEnum = getByValue(MessageTypeEnum.class, "1");
//        if(Objects.nonNull(validStatusEnum)){
//            System.out.println(validStatusEnum.getName());
//            System.out.println(validStatusEnum.getValue());
//        }
//
//    }


}

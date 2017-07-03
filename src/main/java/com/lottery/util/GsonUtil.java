package com.lottery.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class GsonUtil {
    private static Logger logger = LoggerFactory.getLogger(GsonUtil.class);


    /**
     * json字符串转换为指定对象实例(适用于所有类型)
     *
     * @param json json字符串
     * @param t    指定类型,以匿名内部类的方式传入参数
     * @return 目标对象
     */
    public static <T> T json2Obj(String json, T t) {
        Type type = getSuperclassTypeParameter(t.getClass());
        return new Gson().fromJson(json, type);
    }

    /**
     * 获取父类的类型
     *
     * @param subclass 子类类型
     * @return 返回父类的类型
     */
    private static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        ParameterizedType parameterized = (ParameterizedType) superclass;
        logger.debug(parameterized.toString());
        return parameterized;
    }

    /**
     * json字符串转换为指定对象实例(只适用于普通类型,不适用于泛型)
     *
     * @param json json串
     * @param c    目标类型
     * @return 目标对象
     */
    public static <T> T json2Obj(String json, Class<T> c) {
        return new Gson().fromJson(json, c);
    }


    /**
     * 对象转换为json字符串
     *
     * @param o 请求对象
     * @return json串
     */
    public static String toJsonStr(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}

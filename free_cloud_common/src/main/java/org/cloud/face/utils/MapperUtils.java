package org.cloud.face.utils;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @program: nbbolg
 * @description:
 * @author: liulin
 * @create: 2019-04-27 13:54
 */
public class MapperUtils {

    private MapperUtils() { }

    /**
     * 构建一个Mapper工厂
     */
    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    /**
     * 将s属性映射到R的具体实例上
     * @param s 已有的Bean,源Bean
     * @param rClass
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> R mapperBean(S s, Class<R> rClass) {
        return MAPPER_FACTORY.getMapperFacade().map(s, rClass);
    }

    /**
     * 将s属性映射到R的具体实例上,如果转换的属性名不一样，可以传入Map进行说明
     * @param s 已有的Bean,源Bean
     * @param rClass
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> R mapperBean(S s, Class<R> rClass, Map<String, String> diffFieldMap) {
        ClassMapBuilder<?, R> classMap = MAPPER_FACTORY.classMap(s.getClass(), rClass);
        diffFieldMap.forEach(classMap::field);
        classMap.byDefault()
                .register();
        return MAPPER_FACTORY.getMapperFacade().map(s, rClass);
    }

    /**
     * 将s的集合射成R的集合
     * @param sList 已有的Bean的集合
     * @param rClass 要转换的类型
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> List<R> mapperList(List<S> sList, Class<R> rClass) {
        return MAPPER_FACTORY.getMapperFacade().mapAsList(sList, rClass);
    }

    /**
     * 将s的集合射成R的集合,不同的属性通过Map<String, String> 传入
     * @param sList 已有的Bean的集合
     * @param rClass 要转换的类型
     * @param <S>  sourceBean
     * @param <R>  ReturnBean
     * @return    R的实例
     */
    public static <S, R> List<R> mapperList(List<S> sList, Class<R> rClass, Map<String, String> diffFieldMap) {
        if (sList.isEmpty()) {
            return Collections.emptyList();
        }
        ClassMapBuilder<?, R> classMap = MAPPER_FACTORY.classMap(sList.get(0).getClass(), rClass);
        diffFieldMap.forEach(classMap::field);
        classMap.byDefault()
                .register();
        return MAPPER_FACTORY.getMapperFacade().mapAsList(sList, rClass);
    }

    /**
     * 用例：复制bean/list的简单用法
     * 支持传入Map控制属性， key-value 分别是 复制对象-目标对象 的属性名
     * @param args
     * @author liuyuxuan
     */
//    public static void main(String [] args) {
//        Map m = new HashMap<>();
//        m.put("roleName", "remark");
/*        m.put("remark", "roleName");
        //单个bean复制
        SysRoleAddQO before = new SysRoleAddQO("管理员", "拥有最大权力");
//        SysRole after = MapperUtils.mapperBean(before, SysRole.class, m);
        SysRole after = MapperUtils.mapperBean(before, SysRole.class);
        //输出复制后的bean
        System.out.println("单个bean复制，result:===============================================================>>>" + JSON.toJSON(after));

        //list复制
        List<SysRoleAddQO> beforeList = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            SysRoleAddQO item = new SysRoleAddQO("管理员" + i, "拥有最大权力" + i);
            beforeList.add(item);
        }
//        List<SysRole> afterList = MapperUtils.mapperList(beforeList, SysRole.class, m);
        List<SysRole> afterList = MapperUtils.mapperList(beforeList, SysRole.class);
        //输出复制后的list
        afterList.stream().forEach(item -> {
            System.out.println("list复制，result:===============================================================>>>" + JSON.toJSON(item));
        });*/
//    }
}

package org.cloud.face.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @program: free_blog
 * @description:
 * @author: liulin
 * @create: 2019-04-27 13:43
 */
public class BaseController {

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>(2);
        rspData.put("data", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }

    public static void main(String[] args) {;

        Map<Object, Object> map = new LinkedHashMap<Object, Object>(5, .75F) {
            private static final long serialVersionUID = 4267176411845948333L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig = size() > 5;
                if (tooBig) {
                    Object eldestKey = eldest.getKey();
                    System.out.println(eldestKey);
                }
                return tooBig;
            }
        };
        map.put("1","test1");
        map.put("2","test2");
        map.put("8","test3");
        map.put("4","test4");
        map.put("7","test5");
        map.put("6","test6");
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        System.out.println("================");
        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("1","test1");
        map1.put("2","test2");
        map1.put("3","test3");
        map1.put("4","test4");
        map1.put("5","test5");
        map1.put("6","test6");
        map1.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}

package com.hc.admc.utils;

import android.util.Xml;

import com.hc.admc.bean.PostResult;
import com.hc.admc.bean.program.MatItemBean;
import com.hc.admc.bean.program.MaterialBean;
import com.hc.admc.bean.program.ProgramBean;
import com.hc.admc.bean.program.ProgramItemBean;
import com.hc.admc.bean.program.ProgramTaskRelationBean;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2017/8/9.
 */

public class XmlUtils {
    public static Object getXMLObject(String result, Class<?> clazz) {
        if (clazz.equals(String.class)) {
            int startResult = result.indexOf(">") + 1;
            int endResult = result.indexOf("</");
            return result.substring(startResult, endResult);
        }

        Object o = null;

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        try {
            o = serializer.read(clazz, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    public static <T, T1> PostResult<T> getBeanByParseXml(XmlPullParser parser, String listRoot, Class<T> listClazz, String beanRoot, Class<T1> beanClazz) throws Exception {
        //最后结果
        PostResult<T> result = null;
        //list  存放一堆item
        ArrayList<T> list = null;
        //内层ListBean
        T t = null;
        //外层Bean
        T1 bean = null;
        //一个计数器
        int count = 0;
        try {
            //获得当前标签类型
            int eventType = parser.getEventType();
            //如果不是xml文件结束标签，则一个一个向下解析
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    //如果是xml文件开始标签，则初始化一些数据
                    case XmlPullParser.START_DOCUMENT:
                        //最后的结果
                        result = new PostResult<T>();
                        //list
                        list = new ArrayList<T>();
                        //将list加入到result中，当前list是空的，等后面加入了数据后，就不是空了
                        result.setList(list);
                        break;
                    //开始标签
                    case XmlPullParser.START_TAG:
                        //获得标签的名字
                        String tagName = parser.getName();
                        //如果内层的ListBean已经实例化出来的话
                        if (t != null) {
                            try {
                                //判断当前标签在没在ListBean的属性中
                                Field field = listClazz.getField(tagName);
                                //如果ListBean中有当前标签
                                if (field != null) {
                                    //计数器+1
                                    count++;
                                    //将取出来的值赋给ListBean中对应的属性
                                    field.set(t, parser.nextText());
                                }
                            } catch (Exception e) {
                                //如果ListBean中没有当前标签，则会直接跳到这里，什么都不执行，然后再继续往下走

                            }
                            //如果外层的Bean已经实例化出来的话
                        } else if (bean != null) {
                            try {
                                //判断当前标签在没在Bean的属性中
                                Field field = beanClazz.getField(tagName);
                                //如果Bean中有当前标签
                                if (field != null) {
                                    //计数器+1
                                    count++;
                                    //将取出来的值赋给Bean中对应的属性
                                    field.set(bean, parser.nextText());
                                }
                            } catch (Exception e) {
                                //如果Bean中没有当前标签，则会直接跳到这里，什么都不执行，然后再继续往下走
                            }
                        }
                        //如果当前标签为我们传入的内层根标签，说明ListBean需要实例化出来了
                        if (tagName.equals(listRoot)) {
                            //将ListBean实例化出来
                            t = listClazz.newInstance();
                        }
                        //如果当前标签为我们传入的内层根标签，说明Bean需要实例化出来了
                        if (tagName.equals(beanRoot)) {
                            //将Bean实例化出来
                            bean = beanClazz.newInstance();
                        }
                        break;
                    //结束标签
                    case XmlPullParser.END_TAG:
                        //如果当前标签为</item>
                        if (listRoot.equalsIgnoreCase(parser.getName())) {
                            //如果ListBean不为空
                            if (t != null) {
                                //保存到list中，同时也保存到了result中，因为list已经是保存在result中了，
                                //只不过刚才没有值，现在有值了
                                list.add(t);
                                //并且把ListBean置空，因为后续还有好多个item
                                t = null;
                            }
                            //如果当前标签为</root>
                        } else if (beanRoot.equalsIgnoreCase(parser.getName())) {
                            //将Bean保存到result中
                            result.setBean(bean);
                        }
                        break;
                }
                //移动到下一个标签
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果计数器为0说明没有解析到任何数据
        if (count == 0) {
            //将result置空就可以了
            result = null;
        }
        //将result返回
        return result;

    }

    public static List<ProgramItemBean> parsePrograms(String xmlStr) {
        InputStream in = new ByteArrayInputStream(xmlStr.getBytes());
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(in, "UTF-8");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        List<ProgramItemBean> resultList = new ArrayList<>();
        ProgramItemBean programItemBean = null;
        List<MatItemBean> matItemBeanList = new ArrayList<>();
        MatItemBean matItemBean = null;
        MaterialBean materialBean = null;
        ProgramBean programBean = null;
        ProgramTaskRelationBean programTaskRelationBean = null;
        try {
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = parser.getName();
                        switch (tagName) {
                            case "programItem":
                                programItemBean = new ProgramItemBean();
                                break;
                            case "matItems":
                                matItemBeanList = new ArrayList<>();
                                break;
                            case "matItem":
                                matItemBean = new MatItemBean();
                                matItemBean.setItemId(parser.getAttributeValue(null, "itemId"));
                                matItemBean.setSortNum(parser.getAttributeValue(null, "sortNum"));
                                break;
                            case "material":
                                materialBean = new MaterialBean();
                                materialBean.setType(parser.getAttributeValue(null, "type"));
                                break;
                            case "content":
                                materialBean.setContent(parser.nextText());
                                break;
                            case "matName":
                                materialBean.setMatName(parser.nextText());
                                break;
                            case "path":
                                materialBean.setSuffix(parser.nextText());
                                break;
                            case "program":
                                programBean = new ProgramBean();
                                programBean.setHeight(parser.getAttributeValue(null, "height"));
                                programBean.setWidth(parser.getAttributeValue(null, "width"));
                                break;
                            case "items":
                                programBean.setItems(parser.nextText());
                                break;
                            case "programTaskRelation":
                                programTaskRelationBean = new ProgramTaskRelationBean();
                                programTaskRelationBean.setBeginDate(parser.getAttributeValue(null, "beginDate"));
                                programTaskRelationBean.setBeginTime(parser.getAttributeValue(null, "beginTime"));
                                programTaskRelationBean.setEndDate(parser.getAttributeValue(null, "endTime"));
                                programTaskRelationBean.setEndTime(parser.getAttributeValue(null, "endDate"));
                                programTaskRelationBean.setPlayNum(parser.getAttributeValue(null, "playNum"));
                                programTaskRelationBean.setWeek(parser.getAttributeValue(null, "week"));
                                break;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        switch (parser.getName()){
                            case "programItem":
                                if (programItemBean!=null){
                                    resultList.add(programItemBean);
                                }
                                break;
                            case "matItems":
                                if (programItemBean!=null){
                                    programItemBean.setMatItems(matItemBeanList);
                                }
                                break;
                            case "matItem":
                                if (matItemBean!=null){
                                    matItemBeanList.add(matItemBean);
                                }
                                break;
                            case "material":
                                if (materialBean!=null){
                                    matItemBean.setBean(materialBean);
                                }
                                break;
                            case "program":
                                if (programBean!=null){
                                    programItemBean.setProgramBean(programBean);
                                }
                                break;
                            case "programTaskRelation":
                                if (programTaskRelationBean!=null){
                                    programItemBean.setProgramTaskRelationBean(programTaskRelationBean);
                                }
                                break;
                        }
                        break;
                    case XmlPullParser.END_DOCUMENT:

                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

package com.sungrow.wind.aop;

import com.sungrow.wind.annotation.PrimaryKey;
import com.sungrow.wind.constant.Constant;
import com.sungrow.wind.enumeration.ValidFlag;
import com.sungrow.wind.exception.MultiPrimaryKeyException;
import com.sungrow.wind.exception.NoPrimaryKeyException;
import com.sungrow.wind.global.RequestHeader;
import com.sungrow.wind.global.snowflake.IdWorker;
import com.sungrow.wind.util.BeanUtils;
import com.sungrow.wind.global.RequestHeader;
import com.sungrow.wind.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * 主要是对通用字段的统一填充，数据来源于请求头（token查询）本地线程变量
 * @author ZHENGDONG
 * @date 2020/11/13 13:47
 */
@Aspect
@Slf4j
@Component
public class DataCommonFillAop {

    private static final ConcurrentHashMap<Class, String> CACHE_CLASS_KEY_MAP = new ConcurrentHashMap();

    @Autowired
    private IdWorker idWorker;


    @Pointcut("execution(public * com.sungrow.wind.dao.postgre.*.insert*(..))")
    public void daoInsertMethod() {

    }

    @Pointcut("execution(public * com.sungrow.wind.dao.postgre.*.delete*(..))" +
            "|| execution(public * com.sungrow.wind.dao.postgre.*.update*(..))")
    public void daoUpdateMethod() {

    }

    @Before("daoUpdateMethod()")
    public void fillBeforeUpdate(JoinPoint jionPoint) {
        doHandle(jionPoint, this::singleUpdateHandle);
    }



    @Before("daoInsertMethod()")
    public void fillBeforeInsert(JoinPoint jionPoint) {
        doHandle(jionPoint, this::singleInsertHandle);
    }

    private void doHandle(JoinPoint jionPoint, Consumer consumer) {
        Object[] args = jionPoint.getArgs();
        if (args != null && args.length > 0 && args[0] != null) {
            Object firstPara = args[0];
            if (firstPara instanceof Iterable) {
                for (Object o : (Iterable) firstPara) {
                    consumer.accept(o);
                }
            } else {
                consumer.accept(firstPara);
            }
        }
    }


    private void singleInsertHandle(Object o) {
        //填充-主键
        fillPrimaryKey(o);
        //填充-在插入操作时需要初始化的字段
        filInsertlCommonProps(o);
    }

    private void singleUpdateHandle(Object o) {
        //填充-在更新操作时需要初始化的字段
        filUpdateCommonProps(o);
    }

    private void filUpdateCommonProps(Object o) {
        RequestHeader requestHeader = RequestHeader.getHeader();
        if (requestHeader == null) {
            log.warn("no get header");
            return;
        }
        Date date = new Date();
        BeanUtils.fill(o, Constant.LAST_UPDATED_BY_FIELD_NAME, requestHeader.getUserId());
        BeanUtils.fill(o, Constant.LAST_UPDATED_BY_NAME_FIELD_NAME, requestHeader.getUserName());
        BeanUtils.fill(o, Constant.LAST_UPDATE_DATE_FIELD_NAME, date);

    }

    private void filInsertlCommonProps(Object o) {
        RequestHeader requestHeader = RequestHeader.getHeader();
        if (requestHeader == null) {
            log.warn("no get header");
            return;
        }
        Date date = new Date();
        BeanUtils.fill(o, Constant.CREATED_BY_FIELD_NAME, requestHeader.getUserId());
        BeanUtils.fill(o, Constant.CREATED_BY_NAME_FIELD_NAME, requestHeader.getUserName());
        BeanUtils.fill(o, Constant.CREATION_DATE_FIELD_NAME, date);

        BeanUtils.fill(o, Constant.LAST_UPDATED_BY_FIELD_NAME, requestHeader.getUserId());
        BeanUtils.fill(o, Constant.LAST_UPDATED_BY_NAME_FIELD_NAME, requestHeader.getUserName());
        BeanUtils.fill(o, Constant.LAST_UPDATE_DATE_FIELD_NAME, date);

        BeanUtils.fill(o, Constant.ENABLED_FLAG_FIELD_NAME, ValidFlag.Y.getFlag());


    }

    private void fillPrimaryKey(Object o) {
        String keyFieldName = getKeyFieldName(o);
        BeanUtils.fillIfNull(o, keyFieldName, idWorker.nextId());
    }



    private String getKeyFieldName(Object o) {
        return CACHE_CLASS_KEY_MAP.computeIfAbsent(o.getClass(), k -> {
            final List<String> list = new ArrayList<>();
            ReflectionUtils.doWithFields(k, (Field field) -> {
                if (AnnotatedElementUtils.hasAnnotation(field, PrimaryKey.class)) {
                    list.add(field.getName());
                }
            });
            if (list.isEmpty()) {
                throw new NoPrimaryKeyException();
            }
            if (list.size() > 1) {
                throw new MultiPrimaryKeyException();
            }
            return list.get(0);
        });
    }


}

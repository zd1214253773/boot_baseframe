package com.sungrow.wind.common;

import com.sungrow.wind.common.annotation.ApiPropIgnore;
import com.sungrow.wind.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 结合ApiPropIgnore使用，实现注解ApiPropIgnore语义
 * @author ZHENGDONG
 * @date 2020/11/15 1:34
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class RmvPageParamIfAnnoted implements OperationBuilderPlugin {

    public static final String PARAMETERS = "parameters";

    @Override
    public void apply(OperationContext context) {
        List<ApiPropIgnore> propIgnores = context.getParameters().stream().map(
                p-> p.findAnnotation(ApiPropIgnore.class)).filter(
                        o->o.isPresent()).map(o->o.get()).collect(Collectors.toList());
        if(propIgnores.isEmpty()) {
            return;
        }
        final List<String> list = new LinkedList();
        propIgnores.stream().forEach(p->{
            if(p.value() != null && p.value().length>0) {
                list.addAll(Arrays.asList(p.value()));
            }
        });

        List<String> finalList = list.stream().filter(s-> !StringUtils.isEmpty(s)).collect(Collectors.toList());
        if(finalList.isEmpty()) {
            return;
        }
        //List<Parameter>
        Field fieldParam = this.getParamsField(context.operationBuilder().getClass());
        if(fieldParam != null) {
            try {
                List<Parameter> parameters = (List<Parameter>)fieldParam.get(context.operationBuilder());
                Iterator<Parameter> parameterIterator = parameters.iterator();
                while (parameterIterator.hasNext()) {
                    Parameter parameter = parameterIterator.next();

                    if(finalList.stream().anyMatch(p->
                            parameter.getName().equals(p)
                            || parameter.getName().startsWith(p + Constant.DOT)
                            || parameter.getName().contains(Constant.DOT + p + Constant.DOT))) {
                        parameterIterator.remove();
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }



        //context.operationBuilder().parameters(context.getGlobalOperationParameters());
        //context.operationBuilder().parameters(readParameters(context));
    }

    private static final Map<Class, Field> CACHE_MAP = new HashMap<>();
    private Field getParamsField(Class c) {
       return CACHE_MAP.computeIfAbsent(c, k-> {
            for(Field field : c.getDeclaredFields()) {
                if(field.getName().equals(PARAMETERS)) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        });

    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }
}
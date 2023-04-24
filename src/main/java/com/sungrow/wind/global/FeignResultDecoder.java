package com.sungrow.wind.global;

import com.alibaba.fastjson.JSON;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.exception.RemoteBackErrorException;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.MessageFormat;

/**
 * @author ZHENGDONG
 * @date 2020/12/2 11:24
 */
@Slf4j
public class FeignResultDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        if (response.body() == null) {
            String msg = MessageFormat.format("状态码:{0}, 没有返回有效的数据. ", response.status());
            log.error(msg + response.request());
            throw new DecodeException(msg);
        }
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        log.info("============>" + bodyStr);
        //对结果进行转换
        Result result = JSON.parseObject(bodyStr, Result.class);
        //如果返回错误，且为内部错误，则直接抛出异常
        if (!result.isSuccess() && 200 != result.getCode() && 0 != result.getCode()) {
            String msg = MessageFormat.format("{0}", result.getMsg());
            log.error(msg + response.request());
            //throw new Throwable(msg);
            RemoteBackErrorException remoteBackErrorException = new RemoteBackErrorException(msg);
            remoteBackErrorException.setBackResult(result);
            throw remoteBackErrorException;
        }
        return JSON.parseObject(JSON.toJSONString(result.getData()), type);
    }

}

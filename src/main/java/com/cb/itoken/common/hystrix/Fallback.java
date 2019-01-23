package com.cb.itoken.common.hystrix;

import com.cb.itoken.common.constants.HttpStatusConstants;
import com.cb.itoken.common.dto.BaseResult;
import com.cb.itoken.common.utils.MapperUtils;
import com.google.common.collect.Lists;

/**
 * @Author:congbing
 * @Description 通用的熔断方法
 * @Date: 19:53 2019/1/23
 **/
public class Fallback {

    /**
     * 502
     * @return
     */
    public static String badGateway(){
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

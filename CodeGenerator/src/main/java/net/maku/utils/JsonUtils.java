package net.maku.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class JsonUtils {
    private static final Logger logger=LoggerFactory.getLogger(JsonUtils.class);
    public static String convertObj2Json(Object obj){
        try{
            return JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
        }catch (Exception e){
            logger.error("对象转json失败",e);
        }
        return null;
    }
}

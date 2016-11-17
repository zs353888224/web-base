package com.wscq.service.util;

import org.nustaq.serialization.FSTConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 主动序列化
 * <p>
 * Created by zs on 16/9/29.
 */
public class SerializeUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(SerializeUtils.class);
    private static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();

    public static byte[] serializeObject(Object object) {
        LOGGER.info("SerializeUtils serialize object: {}", object.toString());
        return configuration.asByteArray(object);
    }

    public static Object deserializeObject(byte[] buf) {
        if (buf == null || buf.length == 0) {
            return null;
        }
        return configuration.asObject(buf);
    }
}

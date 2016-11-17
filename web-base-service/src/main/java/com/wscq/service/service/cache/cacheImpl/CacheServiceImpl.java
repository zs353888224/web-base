package com.wscq.service.service.cache.cacheImpl;

import com.wscq.service.constants.SystemConstants;
import com.wscq.service.service.cache.CacheService;
import com.wscq.service.util.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by zs on 16/9/27.
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Inject
    private RedisSourceServiceImpl redisSourceService;

    @Override
    public void save(String key, Serializable obj, Integer time) {
        ShardedJedis shardedJedis = redisSourceService.getRedisClient();
        shardedJedis.hsetnx(SystemConstants.APP_GLOBAL_VARIABLE.getBytes(), key.getBytes(), SerializeUtils.serializeObject(obj));
        // TODO 将数据的有效时间添加进去, 实在不行就设置一个检测时间戳的方法
        redisSourceService.returnResource(shardedJedis);
        logger.info("save to redis, the key is: {}, data is: {}", key, obj);
    }

    @Override
    public void save(String key, Serializable obj) {
        save(key, obj, null);
    }

    @Override
    public Object get(String key) {
        ShardedJedis shardedJedis = redisSourceService.getRedisClient();
        byte[] obj = shardedJedis.hget(SystemConstants.APP_GLOBAL_VARIABLE.getBytes(), key.getBytes());
        redisSourceService.returnResource(shardedJedis);
        return SerializeUtils.deserializeObject(obj);
    }

    @Override
    public boolean delete(String key) {
        ShardedJedis shardedJedis = redisSourceService.getRedisClient();
        Long rs;
        rs = shardedJedis.hdel(SystemConstants.APP_GLOBAL_VARIABLE.getBytes(), key.getBytes());
        redisSourceService.returnResource(shardedJedis);
        logger.info("delete redis's data, the key is: {}. {}", key, rs >= 0 ? "succeed" : "failed");
        return rs >= 0;
    }
}

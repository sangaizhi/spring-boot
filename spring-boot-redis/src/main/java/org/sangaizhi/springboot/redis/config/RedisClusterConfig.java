package org.sangaizhi.springboot.redis.config;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * redis 集群配置
 * @author sangaizhi
 * @date 2017/7/4
 */
@Configuration
@EnableAutoConfiguration
public class RedisClusterConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisClusterConfig.class);

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 自定义 redisTemplate 的时候可以采用该 Bean
     * @return
     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
//    public JedisCluster getRedisCluster(){
//        List<String> nodes = redisProperties.getCluster().getNodes();
//        if(CollectionUtils.isEmpty(nodes)){
//            logger.error("Not Found Cluster Node");
//        }
//        Set<HostAndPort> hostAndPortSet = new HashSet();
//        for(String node : nodes){
//            hostAndPortSet.add(new HostAndPort(node.split(":")[0], Integer.valueOf(node.split(":")[1])));
//        }
//        JedisCluster JedisCluster = new JedisCluster(hostAndPortSet, redisProperties.getTimeout());
//        return JedisCluster;
//    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return jedisPoolConfig;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisClusterConfiguration getRedisClusterConfiguration(){
        return new RedisClusterConfiguration(redisProperties.getCluster().getNodes());

    }

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory getJedisConnectionFactory(){
        return new JedisConnectionFactory(getRedisClusterConfiguration(), getJedisPoolConfig());
    }

    @Bean
    public RedisTemplate<?,?> getRedisTemplate(){
        return new StringRedisTemplate(getJedisConnectionFactory());
    }


}

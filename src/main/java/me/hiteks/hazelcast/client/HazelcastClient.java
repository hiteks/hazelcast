package me.hiteks.hazelcast.client;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class HazelcastClient {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        GroupConfig groupConfig = config.getGroupConfig();
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");

        HazelcastInstance client = com.hazelcast.client.HazelcastClient.newHazelcastClient(config);

        IMap<Long, String> map = client.getMap("data");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            log.debug("key: {}, value: {}", entry.getKey(), entry.getValue());
        }
    }

}

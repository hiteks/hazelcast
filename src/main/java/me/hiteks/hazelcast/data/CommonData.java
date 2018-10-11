package me.hiteks.hazelcast.data;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class CommonData {

    private final HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void init() {
        log.debug("hazelcastInstance: {}", hazelcastInstance);
    }

    public void generate() {
        Map<Long, String> map = getDataMap();

        IdGenerator idGenerator = hazelcastInstance.getIdGenerator("newid");
        for (int i=0; i<10; i++) {
            map.put(idGenerator.newId(), "message" + i);
        }
    }

    public Map<Long, String> getDataMap() {
        return hazelcastInstance.getMap("data");
    }

}

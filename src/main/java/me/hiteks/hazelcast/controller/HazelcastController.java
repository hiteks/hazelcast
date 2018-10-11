package me.hiteks.hazelcast.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hiteks.hazelcast.data.CommonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
public class HazelcastController {

    private final CommonData commonData;

    @GetMapping("/")
    public String index() {
        commonData.generate();
        Map<Long, String> map = commonData.getDataMap();
        map.keySet().forEach( k -> log.debug("key: {}", k));
        return "";
    }

}

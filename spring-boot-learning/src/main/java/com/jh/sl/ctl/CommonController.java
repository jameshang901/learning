package com.jh.sl.ctl;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/common/v1")
public class CommonController {

    private static final String METHOD = "method";

    @GetMapping("httpGet")
    public Map<String, Object> httpGet() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.GET);
        return map;
    }

    @PostMapping("httpPost")
    public Map<String, Object> httpPost() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.POST);
        return map;
    }

    @PutMapping("httpPut")
    public Map<String, Object> httpPut() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.PUT);
        return map;
    }

    @PatchMapping("httpPatch")
    public Map<String, Object> httpPatch() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.PATCH);
        return map;
    }

    @DeleteMapping("httpDelete")
    public Map<String, Object> httpDelete() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.DELETE);
        return map;
    }

    @RequestMapping(value = "httpOptions", method = RequestMethod.OPTIONS)
    public Map<String, Object> httpOptions() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.OPTIONS);
        return map;
    }

    @RequestMapping(value = "httpHead", method = RequestMethod.HEAD)
    public Map<String, Object> httpHead() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.HEAD);
        return map;
    }

    @RequestMapping(value = "httpTrace", method = RequestMethod.TRACE)
    public Map<String, Object> httpTrace() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(METHOD, HttpMethod.TRACE);
        return map;
    }

}

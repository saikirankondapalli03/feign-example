package com.travellerapp.client;

import com.travellerapp.cdd.Employee;
import feign.HeaderMap;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value="sample",url = "http://localhost:8080")
public interface DataClient {
    @RequestMapping(method = RequestMethod.GET, value = "/employees/sample")
    List<Employee> getSample();
    /*

    @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
    Employee getFactorGroupsById(
            @HeaderMap Map<String, Object> headerMap, @Param("id") String fgId);

     */
}

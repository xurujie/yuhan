package com.yuhan.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yuhan.entities.Banner;


@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=BanerClientServiceFallbackFactory.class)
public interface BannerClientService {
	  @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	    public List<Banner> list();
}

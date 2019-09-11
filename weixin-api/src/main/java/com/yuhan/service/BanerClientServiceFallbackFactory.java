package com.yuhan.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yuhan.entities.Banner;

import feign.hystrix.FallbackFactory;

@Component
public class BanerClientServiceFallbackFactory  implements FallbackFactory<BannerClientService>  {

	 @Override
	    public BannerClientService create(Throwable throwable) {
	        return new BannerClientService() {
				
				@Override
				public List<Banner> list() {
					// TODO Auto-generated method stub
					return null;
				}
			};

	    }
}

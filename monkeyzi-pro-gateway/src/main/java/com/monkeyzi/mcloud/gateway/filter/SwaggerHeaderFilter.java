/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.monkeyzi.mcloud.gateway.filter;

import com.monkeyzi.mcloud.gateway.config.SwaggerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * 添加X-Forwarded-Prefix header
 */
@Component
@Slf4j
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
	private static final String HEADER_NAME = "X-Forwarded-Prefix";

	@Override
	public GatewayFilter apply(Object config) {
		log.info("哈哈哈=={}");
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			String path = request.getURI().getPath();
			log.info("-----------------{}",path);
			if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
				return chain.filter(exchange);
			}

			String basePath = path.substring(0, path.lastIndexOf(SwaggerProvider.API_URI));
            log.info("basePath={}",basePath);

			ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
			ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
			return chain.filter(newExchange);
		};
	}
}

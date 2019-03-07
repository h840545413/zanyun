package com.zanyun.model.service;

import java.util.Map;

public interface ModelService {


	String topThreeModels();

	Map<String, Object> findModels(Integer start, Integer limit, String key);

	Map<String, Object> findVideos(Integer start, Integer limit);

}

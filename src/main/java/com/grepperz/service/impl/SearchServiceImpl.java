package com.grepperz.service.impl;

import com.grepperz.service.SearchService;
import com.grepperz.web.client.WebClient;

public class SearchServiceImpl implements SearchService{
	@Override
	public String getSearchData(String url) {
		return WebClient.doGet(url);
	}
}

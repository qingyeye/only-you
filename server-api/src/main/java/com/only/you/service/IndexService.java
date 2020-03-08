package com.only.you.service;

import com.only.you.response.ServerResponse;

public interface IndexService {

    ServerResponse getIndexGoods(int pageId, int pageSize, int classifyType);
}

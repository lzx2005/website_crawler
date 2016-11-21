package com.lzx2005.service;


import com.lzx2005.entity.Website;

import java.util.List;

public interface WebsiteService {
    Website findWebsite(Long websiteId);

    List<Website> findUrl(String url);

    Website createWebsite(Website website);
}

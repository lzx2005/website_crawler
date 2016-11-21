package com.lzx2005.service.impl;

import com.lzx2005.entity.Website;
import com.lzx2005.repository.WebsiteRepository;
import com.lzx2005.service.WebsiteService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("WebsiteService")
@Transactional
public class WebsiteServiceImpl implements WebsiteService{


    private final WebsiteRepository websiteRepository;

    public WebsiteServiceImpl(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    @Override
    public Website findWebsite(Long websiteId) {
        return websiteRepository.findByWebsiteId(websiteId);
    }

    @Override
    public List<Website> findUrl(String url) {
        return websiteRepository.findByUrl(url);
    }


    @Override
    public Website createWebsite(Website website) {
        Website save = websiteRepository.save(website);
        return save;
    }
}

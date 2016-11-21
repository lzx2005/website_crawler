package com.lzx2005.repository;

import com.lzx2005.entity.Website;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WebsiteRepository extends CrudRepository<Website, Long> {
    public Website findByWebsiteId(Long websiteId);

    public List<Website> findByUrl(String findByUrl);
}

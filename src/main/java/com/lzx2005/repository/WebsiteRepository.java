package com.lzx2005.repository;

import com.lzx2005.dto.Count;
import com.lzx2005.entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WebsiteRepository extends JpaRepository<Website, Long> {
    public Website findByWebsiteId(Long websiteId);

    public List<Website> findByUrl(String findByUrl);

    @Query(nativeQuery = true,value = "select host,count(*) from website group by host")
    public List<Object[]> getCount();
}

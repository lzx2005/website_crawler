package com.lzx2005.repository;

import com.lzx2005.entity.ThreadMark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Li Zhengxian on 2016/12/9 0009.
 */
public interface ThreadMarkRepository extends CrudRepository<ThreadMark,Integer> {
    ThreadMark findByHost(String host);

    List<ThreadMark> findByStatus(short stauts);
}

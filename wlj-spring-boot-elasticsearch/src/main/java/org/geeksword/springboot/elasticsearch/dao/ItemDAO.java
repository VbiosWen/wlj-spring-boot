package org.geeksword.springboot.elasticsearch.dao;

import org.geeksword.springboot.elasticsearch.entity.ItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAO {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public Boolean createIndex() {
        return elasticsearchTemplate.createIndex(ItemDO.class);
    }
//
//    public List<ItemDO> query() {
//        elasticsearchTemplate.query();
//    }


}

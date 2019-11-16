package org.geeksword.springboot.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "doc_item", type = "doc", shards = 1, replicas = 1)
public class ItemDO implements Serializable {
    private static final long serialVersionUID = -928282886175562076L;

    @Id
    private Long id;

    private String name;

    private String test;
}

package org.geeksword.springboot.spider.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @wenliujie
 */
@Data
public class ShopForm implements Serializable {
    private static final long serialVersionUID = 6044256945774555744L;

    private String url;

}

package org.geeksword.springboot.spider.control;

import lombok.AllArgsConstructor;
import org.geeksword.springboot.spider.form.ShopForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * @wenliujie
 */
@RestController
@RequestMapping("/spider")
@AllArgsConstructor
public class SpiderController {

    private final Spider spider;

    @PostMapping
    public void getItemsFromShop(@RequestBody ShopForm shopForm) {
        spider.addUrl(shopForm.getUrl()).run();
    }
}

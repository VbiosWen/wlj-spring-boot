package org.geeksword.springboot.spider.processors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @wenliujie
 */
@Component
@AllArgsConstructor
public class TaobaoShopProcessor implements PageProcessor {

    private final Site site;

    @Override
    public void process(Page page) {
        List<String> all = page.getHtml().xpath("//*[@id=\"J_ItemList\"]/div[1]/div/div[1]/a").all();
        List<String> collect = all.stream().map(str -> str = "https:" + str).collect(Collectors.toList());
        page.addTargetRequests(collect);
    }

    @Override
    public Site getSite() {
        return this.site;
    }
}

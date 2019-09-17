package org.geeksword.springboot.spider.configuration;

import org.geeksword.springboot.spider.processors.TaobaoShopProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import java.nio.charset.StandardCharsets;

/**
 * @wenliujie
 */
@Configuration
public class SpiderConfiguration {


    @Bean
    public Spider spider(TaobaoShopProcessor taobaoShopProcessor) {
        return Spider.create(taobaoShopProcessor).thread(1);
    }

    @Bean
    public Site site() {
        return Site.me().setRetryTimes(3).setSleepTime(1000).setRetrySleepTime(1000).setCharset(StandardCharsets.UTF_8.toString());
    }

}

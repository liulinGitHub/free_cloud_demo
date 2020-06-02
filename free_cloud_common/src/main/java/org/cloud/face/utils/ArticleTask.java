package org.cloud.face.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @program: nbbolg
 * @description: 定时器执行
 * @author: liulin
 * @create: 2019-04-09 11:01
 */
@Slf4j
@Component
@EnableScheduling
public class ArticleTask {

    //@Autowired
    //private ArticleService articleService;

    //@Scheduled(cron = "*/3 * * * * *")
    public void task() {
        log.info("执行一次，");
//        ArticleCheckDTO articleCheckDTO = new ArticleCheckDTO();
//        articleCheckDTO.setArticleTitle("Spring Boot 实战");
//        articleCheckDTO.setArticleContent("这是关于Spring Boot 实战的文章！");
//        articleCheckDTO.setArticleTag("Spring");
//        articleService.saveDraft(articleCheckDTO);
    }
}

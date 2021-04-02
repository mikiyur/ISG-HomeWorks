package app.controller;

import app.logger.Logger;
import app.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    Logger logger;

    @GetMapping ("")
    public List <Topic> getAllTopics (){
        logger.log(this.getClass().toString()+ " method: getAllTopics");
        return topicService.getAllTopics();
    }


    @GetMapping ("/name/{name}")
    public Topic geTopicByName (@PathVariable String name){
        logger.log(this.getClass().toString()+ " method: geTopicByName, name: " + name);
        return topicService.getTopicByName(name);
    }

    @GetMapping ("/theme/{theme}")
    public List <Topic> getTopicsByTheme (@PathVariable String theme){
        logger.log(this.getClass().toString()+ " method: geTopicsByTheme, theme: " + theme);
        return topicService.getTopicsByTheme(theme);
    }

    @PutMapping ("/order")
    public void setOrder (@RequestParam boolean order){
        logger.log(this.getClass().toString()+ " method: setOrder, order: " + order);
        topicService.setOrder(order);
    }


}

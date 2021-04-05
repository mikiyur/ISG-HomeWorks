package app.service.impl;

import app.model.Topic;
import app.service.TopicService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service("old")
public class TopicServiceOldImpl implements TopicService {

    private static final List <Topic> TOPICS = new ArrayList<>();

    public TopicServiceOldImpl() {
        init();
    }

    public void setOrder(boolean order) {
        ORDER.setOrder(order);
    }

    public List<Topic> getAllTopics(){
        return sortByDateIfOrder(TOPICS);
    }

    public Topic getTopicByName(String name){
         return TOPICS.stream()
                 .filter(topic -> topic.getName().equals(name))
                 .findFirst()
                 .orElse(null);
    }

    public List<Topic> getTopicsByTheme(String theme){
        return sortByDateIfOrder(TOPICS.stream()
                .filter(topic -> topic.getTheme().equals(theme))
                .collect(Collectors.toList()));
    }

    private void init(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Topic topic = new Topic();
            topic.setId((long)i);
            topic.setName(Integer.valueOf(random.nextInt(10000)).toString());
            topic.setTheme(Integer.valueOf(random.nextInt(10)).toString());
            LocalDateTime date =  LocalDateTime.now().minusDays(random.nextInt(100));
            topic.setDate(date);
            TOPICS.add(topic);
        }
    }

    private List<Topic> sortByDateIfOrder(List<Topic> topics){
        if (ORDER.isOrder()){
            List <Topic> sortedTopics = new ArrayList<>(topics);
            sortedTopics.sort(Comparator.comparing(Topic::getDate));
            return sortedTopics;
        }
         return topics;
    }
}

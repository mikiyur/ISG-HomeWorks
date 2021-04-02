package app.service;

import app.model.Topic;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private static final List <Topic> TOPICS = new ArrayList<>();
    private boolean order = false;

    public TopicService() {
        init();
    }

    public void setOrder(boolean order) {
        this.order = order;
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
            Date date = new Date();
            date.setTime(random.nextLong());
            topic.setDate(date);
            TOPICS.add(topic);
        }
    }

    private List<Topic> sortByDateIfOrder(List<Topic> topics){
        if (order){
            List <Topic> sortedTopics = new ArrayList<>(topics);
            sortedTopics.sort(Comparator.comparing(Topic::getDate));
            return sortedTopics;
        }
         return topics;
    }
}

package app.service.impl;

import app.model.Topic;
import app.repository.TopicRepository;
import app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service("new")
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
        init();
    }

    @Override
    public void setOrder(boolean order) {
        ORDER.setOrder(order);
    }

    @Override
    public List<Topic> getAllTopics() {
        return sortByDateIfOrder(topicRepository.findAll());
    }

    @Override
    public Topic getTopicByName(String name) {
        return topicRepository.findByName(name);
    }

    @Override
    public List<Topic> getTopicsByTheme(String theme) {
        return sortByDateIfOrder(topicRepository.findAllByTheme(theme));
    }

    private List<Topic> sortByDateIfOrder(List<Topic> topics){
        if (ORDER.isOrder()){
            List <Topic> sortedTopics = new ArrayList<>(topics);
            sortedTopics.sort(Comparator.comparing(Topic::getDate));
            return sortedTopics;
        }
        return topics;
    }

    private void init(){
        Random random = new Random();
        List<Topic> topics = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Topic topic = new Topic();
            topic.setName(Integer.valueOf(random.nextInt(10000)).toString());
            topic.setTheme(Integer.valueOf(random.nextInt(10)).toString());
            LocalDateTime date =  LocalDateTime.now().minusDays(random.nextInt(100));
            topic.setDate(date);
            topics.add(topic);
        }
        topicRepository.saveAll(topics);
    }
}

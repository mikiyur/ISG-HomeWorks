package app.service;

import app.model.Topic;
import app.model.Wrapper;
import java.util.List;


public interface TopicService {
    Wrapper ORDER = new Wrapper();

    void setOrder(boolean order);
    List<Topic> getAllTopics();
    Topic getTopicByName(String name);
    List<Topic> getTopicsByTheme(String theme);
}

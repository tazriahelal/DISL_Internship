package springbootproject.springDISLfirst;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Frame", "Spring Framework Desscription"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("Python", "Python", "Python description")
    ));

    public List<Topic> getALlTopics() {

        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Topic> getTopicsByName(String name) {
        return topics.stream()
                .filter(topic -> topic.getName().contains(name))
                .collect(Collectors.toList());
    }

    public Topic addTopic(Topic topic) {
        topics.add(topic);
        return topic;
    }

    public Topic updateTopic(Topic topic, String id) {
       topics.stream().filter(t -> t.getId().equals(id)).
               findFirst().ifPresent(t -> topics.set(topics.indexOf(t), topic));
        return topic;

}

    public Topic deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
        //eturn id;
        return null;
    }
}

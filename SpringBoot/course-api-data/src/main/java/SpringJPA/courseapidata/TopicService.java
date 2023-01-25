package SpringJPA.courseapidata;

import SpringJPA.courseapidata.requests.AddTopicRequest;
import SpringJPA.courseapidata.requests.UpdateTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Frame", "Spring Framework Desscription"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("Python", "Python", "Python description")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(topicId -> topicId.getId().equals(id)).
                findFirst().orElse(null);
    }

    public List<Topic> getTopicsByName(String name) {
        return topics.stream().filter(topicName -> topicName.getName().contains(name)).
                collect(Collectors.toList());
    }

    /*public Topic addTopic(Topic topic) {
        //topics.add(topic);
        //return topic;
        return topicRepository.save(topic);
    }*/

    /*public void addTopic(Topic topic) {
        topicRepository.save(topic);
     }*/

    public Topic addTopic(Topic topic, AddTopicRequest request){
        topic.setName(request.getName());
        topic.setDescription(request.getDescription());
        topic.setId(request.getId());

        return topic;
    }
    public Topic updateTopic(Topic topic, UpdateTopicRequest request) {
        topic.setName(request.getName());
        topic.setDescription(request.getDescription());

        topics.stream()
                .filter(t -> t.getId().equals(topic.getId())).
                findFirst()
                .ifPresent(t -> topics.set(topics.indexOf(t), topic));

        return topic;
    }

    public Topic deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
        //return id;
        return null;
    }


}

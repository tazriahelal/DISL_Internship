package SpringJPA.courseapidata;

import SpringJPA.courseapidata.requests.AddTopicRequest;
import SpringJPA.courseapidata.requests.DeleteTopicRequest;
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
        /*List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics :: add);
        return topics;*/
        return topicRepository.findAll();

    }

    public Topic getTopicById(String id) {
        return topicRepository.findById(id).orElse(null);
//        return topics.stream().filter(topicId -> topicId.getId().equals(id)).
//                findFirst().orElse(null);
    }

    public Topic getTopicsByName(String name) {
        /*return topics.stream().filter(topicName -> topicName.getName().contains(name)).
                collect(Collectors.toList());*/
        return topicRepository.findTopByName(name);
    }

    /*public Topic addTopic(Topic topic) {
        //topics.add(topic);
        //return topic;
        return topicRepository.save(topic);
    }*/

    /*public void addTopic(Topic topic) {
        topicRepository.save(topic);
     }*/

    public Topic addTopic(AddTopicRequest request){
        Topic topic = new Topic();
       topic.setName(request.getName());
       topic.setDescription(request.getDescription());
       topic.setId(request.getId());
       return topicRepository.save(topic);
    }
    public Topic updateTopic(Topic topic, UpdateTopicRequest request) {
        topic.setName(request.getName());
        topic.setDescription(request.getDescription());

        topics.stream()
                .filter(t -> t.getId().equals(topic.getId())).
                findFirst()
                .ifPresent(t -> topics.set(topics.indexOf(t), topic));

        return topicRepository.save(topic);
    }

    public Topic deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        //return id;
        return topicRepository.delete(id);
    }


}

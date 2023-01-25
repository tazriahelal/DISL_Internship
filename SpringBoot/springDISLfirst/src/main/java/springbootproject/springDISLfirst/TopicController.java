package springbootproject.springDISLfirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics()  {

        return topicService.getALlTopics();
    }

    @GetMapping("/topics/id/{id}")
    public Topic getTopic(@PathVariable String id) {

        return topicService.getTopic(id);
    }

    @GetMapping("/topics/name/{name}")
    public List<Topic> getTopicsByName(@PathVariable String name) {

        return topicService.getTopicsByName(name);
    }

    @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic){

        return topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/id/{id}")
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id){

        return topicService.updateTopic(topic, id);
    }

    /*@DeleteMapping("/topics/id/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }*/

    @DeleteMapping("/topics/id/{id}")
    public Topic deleteTopic(@PathVariable String id){
        return topicService.deleteTopic(id);
    }
}

package SpringJPA.courseapidata;

import SpringJPA.courseapidata.payload.ResponsePayload;
import SpringJPA.courseapidata.requests.AddTopicRequest;
import SpringJPA.courseapidata.requests.DeleteTopicRequest;
import SpringJPA.courseapidata.requests.UpdateTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/all")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/id/{id}")
    public ResponsePayload getTopicById(@PathVariable String id){
        Topic topic = topicService.getTopicById(id);
        if(topic == null) {
            return new ResponsePayload(false, "Topic not found");
        }

        return new ResponsePayload(true, "Topic loaded", topic);
    }

    @GetMapping("/name/{name}")
    public ResponsePayload getTopicsByName(@PathVariable String name){
        Topic topic = topicService.getTopicsByName(name);
        return new ResponsePayload(true, "Topic Loaded", topic); //topicService.getTopicsByName(name);
    }

   /* @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic){

        return topicService.addTopic(topic);
    }
*/
   @PostMapping("/add")
   public ResponsePayload addTopic(@RequestBody AddTopicRequest request){
      // Topic topic = topicService.getTopicById(request.getId());
       //topicService.addTopic(topic);
      return new ResponsePayload(true, "Topic added", topicService.addTopic(request));
   }

    @PutMapping("/update")
    public ResponsePayload updateTopic(@RequestBody UpdateTopicRequest request) {
        Topic topic = topicService.getTopicById(request.getId());
        if(topic == null) {
            return new ResponsePayload(false, "Topic not found");
        }

        return new ResponsePayload(true, "Topic updated", topicService.updateTopic(topic, request));
    }

    /*@DeleteMapping("/topics/id/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponsePayload deleteTopic(@PathVariable String id) {
      /* Topic topic = topicService.getTopicById(request.getId());
       // return topicService.deleteTopic(id);
       return new ResponsePayload(true, "Topic Deleted", topicService.deleteTopic(String.valueOf(topic), request));*/
        Topic topic = topicService.getTopicsByName(id);
        return new ResponsePayload(true, "Topic deleted");
    }

}

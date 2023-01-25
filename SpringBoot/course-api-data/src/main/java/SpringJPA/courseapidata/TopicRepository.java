package SpringJPA.courseapidata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {

    Topic findTopByName(String name);

    Topic delete(String id);
}

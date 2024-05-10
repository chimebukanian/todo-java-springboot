package ebuks.app.repository;

import ebuks.app.data.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<ToDo, String>{
    
}

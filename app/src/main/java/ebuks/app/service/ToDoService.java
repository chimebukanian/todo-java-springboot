package ebuks.app.service;

import ebuks.app.data.ToDo;
import ebuks.app.exception.EntityNotFoundException;
import ebuks.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    
    @Autowired
    private TodoRepository toDoRepository;

    public List<ToDo> findAll(){
        return toDoRepository.findAll();
    }

    public ToDo findById(String id){
        return toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
        
    }

    public void deleteById(String id){
        toDoRepository.deleteById(id);
    }


}

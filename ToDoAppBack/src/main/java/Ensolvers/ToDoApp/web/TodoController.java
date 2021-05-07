package Ensolvers.ToDoApp.web;

import Ensolvers.ToDoApp.domain.TblItems;
import Ensolvers.ToDoApp.repository.TblItemsRepository;
import Ensolvers.ToDoApp.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class TodoController {
    
    @Autowired
    private TblItemsRepository tir;
    
    @Autowired
    private TodoService todoServ;
    
    @GetMapping("/")
    public List<TblItems> fetchAllTodoItems() {
        return tir.findAll();
    }
    
    @PostMapping("/create")
    public TblItems createItem(TblItems item) {
        todoServ.createItem();
        return tir.save(item);
    }
    
    @PutMapping("/{id}")
    public TblItems modifyItem(@PathVariable Integer id, @RequestBody TblItems item){
        TblItems updatedTblItems = todoServ.updateTodoItem(id, item);
        return tir.save(updatedTblItems);
    }
    
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id){
        tir.deleteById(id);
    }
    
}

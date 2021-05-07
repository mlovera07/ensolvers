package Ensolvers.ToDoApp.service;

import Ensolvers.ToDoApp.domain.TblItems;
import Ensolvers.ToDoApp.web.TodoController;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    @Autowired
    private TodoController todoControl;
    
    public TblItems updateTodoItem(Integer id, TblItems tblItem){
        Optional<TblItems> todoOpt;
        todoOpt = todoControl.fetchAllTodoItems()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findAny();
        if (todoOpt.isPresent()){
            TblItems item = todoOpt.get();
            item.setIsDone(tblItem.getIsDone());
            item.setTask(tblItem.getTask());
            return item;
        }
        return null;
                   
    }

    public void createItem() {
        TblItems tblItem = new TblItems();
        tblItem.setIsDone(false);
    }
    
}

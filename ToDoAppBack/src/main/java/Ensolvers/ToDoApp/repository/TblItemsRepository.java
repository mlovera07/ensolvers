package Ensolvers.ToDoApp.repository;

import Ensolvers.ToDoApp.domain.TblItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblItemsRepository extends JpaRepository<TblItems,Integer> {
       
}

import './App.css';
import React, { useEffect, useState } from 'react';
import TodoItem from './components/todoItem';

function App() {

  const [todoItems, setTodoItems] = useState(null);

  useEffect(() =>{
    console.log("Hey, i loaded up"); 

    if(!todoItems){
      fetch('http://localhost:8080/')
      .then((response) => response.json())
      .then((data) => {
        console.log("Todo items list: ", data);
        setTodoItems(data);
      });
    }
  }, [todoItems]);

  function addNewTodoItem() {
  }

  return (
    <>
      <div>
        <button onClick={addNewTodoItem}>Add new task</button>
      </div>
      <div>
        {todoItems 
          ? todoItems.map((todoItem) => {
              return <TodoItem key={todoItem.id} data={todoItem}/>;    
            })
          : 'loading data...'}
      </div> 
    </>
  );     
}

export default App;

import React from 'react';
import TodoList from "./todo/TodoList";


function App() {
    const todos = [
    {id: 1, completed: false, title: 'Bread'},
        {id: 2, completed: false, title: 'Milk'},
        {id: 3, completed: false, title: 'Butter'}
    ]
  return (
    <div className='wrapper'>
        <h1>React app</h1>

        <TodoList todos={todos}/>
    </div>
  );
}

export default App;

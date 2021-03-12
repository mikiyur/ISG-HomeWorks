import React from "react"
import TodoItem from "./TodoItem";

const style = {
    listStyle: 'none',
    margin: 0,
    padding: 0
}

function TodoList(props) {
    return (
        <ul style={style}>
            {props.todos.map(
                (todo, index) => {
                    return <TodoItem todo={todo} key={todo.id} index={index}/>
                }
            )}
        </ul>
    )
}

export default TodoList;
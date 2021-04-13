import "./TodoList.scss"
import {observer} from "mobx-react-lite";
import Data from "../data/Data";
import {ChangeEvent, useState} from "react";
import Todo from "../Todo/Todo";

const TodoList = observer(() => {
    const [inputValue, setInputValue] = useState("");
    const isAuthenticated = Data.isAuthenticated;
    const inputHendler = (e: ChangeEvent<HTMLInputElement>) => {setInputValue(e.target.value);}
    if (!isAuthenticated) {return (<h2>You need to sign in</h2>)}

    return (
        <div>
            {Data.todos.map(value => <Todo key={value.id} todo={value}/>)}
            <div className="todo">
                <form className="todo__form" onSubmit={(e) => {
                    e.preventDefault();
                    Data.newTodo(inputValue);
                    setInputValue("")
                }}>
                    <input type="text" value={inputValue} onChange={inputHendler}/>
                    <button>new task</button>
                </form>
            </div>
        </div>
    );


})

export default TodoList;

import Data from "../data/Data";
import "./Todo.scss"

interface ITodo{
    id: number,
    task: string,
}

interface ITodoProps {
    todo: ITodo;
}

const Todo = (props: ITodoProps) => {
    const {todo: {id, task}} = props;
    return (
        <div className="todo">
            <b>Task: </b> {task}
            <button onClick={() => Data.deleteTodo(id)}>remove</button>
        </div>
    );
}

export default Todo;

import {makeAutoObservable} from "mobx";

const uniqueId = (): number => new Date().getTime();

interface ITodo{
    id: number,
    task: string,
}

class Data {

    todos: ITodo[] = [
        {
            id: 1,
            task: "do smth",
        },
        {
            id: 2,
            task: "Buy smth",
        },
        {
            id: 3,
            task: "Go somewhere",
        },
    ];

    isAuthenticated: boolean = false;

    constructor() {
        makeAutoObservable(this);
    }


    setIsAuthenticated(status: boolean): void {
        this.isAuthenticated = status;
    }

    signIn(login: string, password: string): void {
        let users = localStorage.getItem("users");

        if (users === null || !Array.isArray(JSON.parse(users))) {
            alert("Please create your account!")
        } else if (Array.isArray(JSON.parse(users))) {
            if ([...JSON.parse(users)].findIndex(value => value.login === login && value.password === password) >= 0) {
                localStorage.setItem("loginedUser", JSON.stringify({login, password}));
                this.isAuthenticated = true;
            } else {
                alert("Incorrect login or password");
            }
        }
    }

    signOut(): void {
        localStorage.removeItem("loginedUser");
    }

    signUp(login: string, password: string): void {
        let users = localStorage.getItem("users");
        const newUser = {id: uniqueId(), login, password};

        if (users === null || !Array.isArray(JSON.parse(users))) {
            localStorage.setItem("users", JSON.stringify([newUser]));
        } else if (Array.isArray(JSON.parse(users))) {
            if ([...JSON.parse(users)].findIndex(value => value.login === login) < 0) {
                localStorage.setItem("users", JSON.stringify([...JSON.parse(users), newUser]));
                alert("Account created successfully!")
            } else {
                alert("Login already exists!")
            }
        }
    }

    deleteTodo(id: number): void {
        this.todos = this.todos.filter(value => value.id !== id);
    }

    newTodo(task: string): void {
        this.todos.push({
            id: uniqueId(),
            task
        })
    }

    getAuthenticatedUserName(): string {
        const login = localStorage.getItem("loginedUser");
        return login === null ? '' : JSON.parse(login).login;
    }

}

export default new Data();

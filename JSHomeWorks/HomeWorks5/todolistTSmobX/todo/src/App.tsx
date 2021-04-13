import {observer} from "mobx-react-lite";
import {useEffect} from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Data from "./data/Data";
import Header from "./Header/Header";
import TodoList from "./TodoList/TodoList";
import SignIn from "./SignIn/SignIn";
import SignUp from "./SignUp/SignUp";



const App = observer(() => {

    useEffect(() => {
        if (localStorage.getItem("loginedUser")) {
            Data.setIsAuthenticated(true);
        }
    }, [])

    return (
        <div>
            <Router>
                <Header/>
                <Switch>
                    <Route exact={true} path="/">
                        <TodoList/>
                    </Route>

                    <Route exact={false} path="/signIn">
                        <SignIn/>
                    </Route>

                    <Route exact={false} path="/signUp">
                        <SignUp/>
                    </Route>
                </Switch>
            </Router>
        </div>
    );
})

export default App;

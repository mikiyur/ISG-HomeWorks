import "./SignIn.scss"
import {Link, useHistory} from "react-router-dom";

import {observer} from "mobx-react-lite";
import Data from "../data/Data";


const SignIn = observer(() => {
    const history = useHistory();

    if (Data.isAuthenticated) {
        history.push("/");
    }

    const formChecker = (e: any): void => {
        e.preventDefault();

        const login = e.target[0].value;
        const password = e.target[1].value;
        Data.signIn(login, password);
    }

    return (
        <div className="form-wrapper">
            <h3>Sign in</h3>
            <form onSubmit={formChecker}>
                <div>
                    Login
                    <br/>
                    <input type="text" name="login"/>
                </div>
                <div>
                    Password
                    <br/>
                    <input type="password" name="password"/>
                </div>
                <button>Sign in</button>
            </form>
            <hr/>
            <div>
                Don't have an account?
                <Link to="/signUp">
                    <button>Sign up</button>
                </Link>
            </div>

        </div>
    );
})

export default SignIn;

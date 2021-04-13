import "./SignUp.scss"
import {observer} from "mobx-react-lite";
import {Link, useHistory} from "react-router-dom";
import Data from "../data/Data";


const SignUp = observer(() => {
    const history = useHistory();

    const formChecker = (e: any): void => {
        e.preventDefault();

        const login = e.target[0].value;
        const password = e.target[1].value;

        if (login && password) {
            Data.signUp(login, password);
            history.push("./signIn");
        } else {
            alert("Smth went wrong")
        }
    }

    return (
        <div className="form-box">
            <h3>Sign up</h3>
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
                <button>Sign up</button>
            </form>
            <hr/>
            <div>
                Maybe you have an account?
                <Link to="/signIn">
                    <button>Sign in</button>
                </Link>
            </div>
        </div>
    );
})

export default SignUp;

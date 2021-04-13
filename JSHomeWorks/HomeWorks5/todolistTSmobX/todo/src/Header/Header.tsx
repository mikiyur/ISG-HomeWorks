import "./Header.scss"
import {Link} from "react-router-dom";
import {observer} from "mobx-react-lite";
import Data from "../data/Data";

const Header = observer(() => {


    return (
        <div className="header">
            {Data.isAuthenticated ? (
                <div>
                    {
                        Data.getAuthenticatedUserName() + " "
                    }
                    <button onClick={() => {
                        Data.signOut();
                        Data.setIsAuthenticated(false);
                    }}>
                        signOut
                    </button>
                </div>

            ) : (
                <Link to="/signIn"><button>sign in</button></Link>
            )}
        </div>
    );
})
export default Header;

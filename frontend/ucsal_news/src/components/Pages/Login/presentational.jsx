import React from 'react'
import './styles.css'
import {useHistory} from 'react-router-dom'

function login() {

    // eslint-disable-next-line react-hooks/rules-of-hooks
    const history = useHistory();

    return (
        <div className="login-back">

        
        <div className='container'>
            <div className="login-box">
                <h2>Welcome</h2>
                <h2 className="txt">LOGIN</h2>
                <form>
                    <div>
                        <input type="text" placeholder="Username"/>
                    </div>

                    <div>
                        <input type="password" placeholder="Password" />
                    </div>

                    <div>
                        <button onClick={() => {history.push('/Home')}} className="submit">Sign In</button>
                        <button onClick={() => {history.push('/SignUp')}} className="submit">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    )
}

export default login;

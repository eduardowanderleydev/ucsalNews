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
                <h2 className="maintitle">LOGIN</h2>
                <form>
                    <div>
                        <input type="text" placeholder="Username" className="input-login"/>
                    </div>

                    <div>
                        <input type="password" placeholder="Password" className="input-login" />
                    </div>

                    <div className="buttonContainer">
                        <button onClick={() => {history.push('/Home')}} className="sign-in">Sign In</button>
                        <button onClick={() => {history.push('/SignUp')}} className="sign-up">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    )
}

export default login;

import React from 'react'
import './styles.css'

function login() {
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
                        <input type="text" placeholder="Password" />
                    </div>

                    <div>
                        <input className="submit" type="submit" value="sign in" />
                    </div>
                </form>
            </div>
        </div>
    </div>
    )
}

export default login;

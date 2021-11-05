import React from 'react'
import './styles.css'
import {useHistory} from 'react-router-dom'

function Signup() {

    const history = useHistory();

    return(
        <div>
        <div className="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr/>

        <label for="email"><b>Email</b></label>
        <input 
        type="text" 
        placeholder="Enter Email" 
        name="email" />

        <label for="email"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="email" required/>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required/>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required/>

        <div className="clearfix">
        <button type="button" className="cancelbtn">Cancel</button>
        <button type="submit" className="signupbtn"onClick={() => {history.push('/')}} >Sign Up</button>
        </div>
    </div>
        </div>
    )
}

export default Signup;
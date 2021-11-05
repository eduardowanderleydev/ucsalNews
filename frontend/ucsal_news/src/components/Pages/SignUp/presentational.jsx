import React from 'react'
import './styles.css'

//External Libraries
import {useHistory} from 'react-router-dom';
import { useForm } from 'react-hook-form';
import * as yup from "yup";
import { yupResolver } from '@hookform/resolvers/yup';

const validationForm = yup.object().shape({
    email: yup.string().required("Insira seu Email").email("Necessário um email válido"),
    username: yup.string().required("Insira seu Username").max(20, "O seu nome de usuário precisa ter menos que 20 caracteres"),
    password: yup.string().required("Insira uma Senha ").min(6, "A senha precisa de no mínimo 6 dígitos"),
    confirmPassword: yup.string().required("Insira uma Senha").min(6, "A senha precisa de no mínimo 6 dígitos"),
})

function Signup() {

    const history = useHistory();

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(validationForm)
    })
    const onsubmit = data => console.log(data)
    
    return(
        <div>
            <div className="container">
            <h1 className="signup-title">Sign Up</h1>
            <p className="signup-subtitle">Please fill in this form to create an account.</p>
            <hr/>

        <form onSubmit={handleSubmit(onsubmit)}>

        <div>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" {...register("email")} />
            <p className="error-message">{errors.email?.message}</p>
        </div>

        <div>
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" {...register("username")} />
            <p className="error-message">{errors.username?.message}</p>
        </div>
        
        <div>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" {...register("password")} />
            <p className="error-message">{errors.password?.message}</p>
        </div>
       
        <div>
            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="confirmPassword" {...register("confirmPassword")} />
            <p className="error-message">{errors.confirmPassword?.message}</p>
        </div>
        
        <div>
        <button type="button" className="cancelbtn">Cancel</button>
        <button 
        type="submit" 
        className="signupbtn">Sign Up</button>
        </div>

        </form>    
    </div>
        </div>
    )
}

export default Signup;
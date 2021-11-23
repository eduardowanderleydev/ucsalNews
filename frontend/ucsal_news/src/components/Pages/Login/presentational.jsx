import React from "react";
import "./styles.css";

import { ErrorMessage, Formik, Form, Field } from "formik";
import * as yup from "yup";

import axios from "axios";

import {useHistory} from 'react-router-dom';


const login = () => {
  const handleSubmit = (values) => {
    axios
      .post("http://localhost:8080/user/autenticar", values)
      .then((resp) => console.log(resp));
  };

  const validationsSignIn = yup.object().shape({
    userName: yup.string().required("Insira seu nome de usuário"),
    password: yup.string().required("Insira sua senha"),
  });

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const history = useHistory();

  return (
    <div className="login-back">
      <div className="container">
        <div className="login-box">
          <h2>Welcome</h2>
          <h2 className="maintitle">LOGIN</h2>

          <Formik
            initialValues={{}}
            onSubmit={handleSubmit}
            validationSchema={validationsSignIn}
          >
            <Form className="Form">
              <div className="Form-Group">
                <Field
                  placeholder="Usuário"
                  name="userName"
                  className="input-login"
                />
                <ErrorMessage
                  component="span"
                  name="userName"
                  className="Form-Error"
                />
              </div>

              <div className="Form-Group">
                <Field
                  placeholder="Senha"
                  name="password"
                  className="input-login"
                />
                <ErrorMessage
                  component="span"
                  name="password"
                  className="Form-Error"
                />
              </div>

              <div className="buttonContainer">
                <button className="sign-up" onClick={()=>{
                  history.push("/SignUp")
                }}>Sign up</button>

                <button className="sign-in" type="submit">
                  Sign in
                </button>
              </div>
            </Form>
          </Formik>
        </div>
      </div>
    </div>
  );
};

export default login;

import React, {useState} from "react";
import "./styles.css";

import Error from "../../Generic/Error";

import { ErrorMessage, Formik, Form, Field } from "formik";
import * as yup from "yup";

import axios from "axios";

import { useHistory } from "react-router-dom";

function login () {

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [hasError, setHasError] = useState(false)

  const handleSubmit = (values) => {
    axios.post("http://localhost:8080/user/autenticar", values).then((resp) => {
      const { data } = resp;
      if (data) {
        localStorage.setItem("app-token", data);
        history.push("/");
        setHasError(false)
      }
    })
    .catch(() => {
      setHasError(true)
    })
    ;
  };

  const validationsSignIn = yup.object().shape({
    email: yup
      .string()
      .required("Insira seu email")
      .email("informe um email válido"),
    password: yup
      .string()
      .required("Insira sua senha")
      .min(6, "Senha precisa de no mínimo 6 dígitos"),
  });

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const history = useHistory();

  return (
    <div className="login-back">
      <div className="container_login">
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
                  placeholder="email"
                  name="email"
                  className="input-login"
                />
                <ErrorMessage
                  component="span"
                  name="email"
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
                <button className="sign-in" type="submit">
                  Sign in
                </button>

                <button
                  className="sign-up"
                  onClick={() => {
                    history.push("/SignUp");
                  }}
                >
                  Sign up
                </button>
              </div>
            </Form>
          </Formik>
        </div>
        {hasError? <Error/> : null}
      </div>
      
    </div>
  );
};

export default login;

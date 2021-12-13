import React from "react";
import "./styles.css";

//External Libraries
import { useHistory } from "react-router-dom";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import axios from "axios";

const validationSignUpForm = yup.object().shape({
  name: yup.string().required("Insira seu name"),
  userName: yup.string().required("Insira seu Username"),
  email: yup
    .string()
    .required("Insira seu email")
    .email("Necessário um email válido"),
  password: yup
    .string()
    .required("Insira uma Senha ")
    .min(6, "A senha precisa de no mínimo 6 dígitos"),
});

function Signup() {
  const history = useHistory();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(validationSignUpForm),
  });
  const onsubmit = (values) => {
    axios.post("http://localhost:8080/user", values).then((resp) => {
      const { data } = resp;
      if (data) {
        localStorage.setItem("app-token", data);
        history.push("/");
      }
    });
  };

  return (
    <div>
      <div className="container-signup">
        <h1 className="signup-title">Sign Up</h1>
        <p className="signup-subtitle">
          Please fill in this form to create an account.
        </p>
        <hr />

        <form onSubmit={handleSubmit(onsubmit)}>
          <div>
            <label>
              <b>Name</b>
            </label>
            <input
              className="input-signup"
              type="text"
              placeholder="Enter name"
              name="name"
              {...register("name")}
            />
            <p className="error-message">{errors.name?.message}</p>
          </div>

          <div>
            <label>
              <b>Username</b>
            </label>
            <input
              className="input-signup"
              type="text"
              placeholder="Enter Username"
              name="userName"
              {...register("userName")}
            />
            <p className="error-message">{errors.userName?.message}</p>
          </div>

          <div>
            <label>
              <b>Email</b>
            </label>
            <input
              className="input-signup"
              type="email"
              placeholder="Enter email"
              name="email"
              {...register("email")}
            />
            <p className="error-message">{errors.email?.message}</p>
          </div>

          <div>
            <label>
              <b>Password</b>
            </label>
            <input
              className="input-signup"
              type="password"
              placeholder="Password"
              name="password"
              {...register("password")}
            />
            <p className="error-message">{errors.password?.message}</p>
          </div>

          <div>
            <button type="button" className="cancelbtn">
              Cancel
            </button>
            <button type="submit" className="signupbtn">
              Sign Up
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Signup;

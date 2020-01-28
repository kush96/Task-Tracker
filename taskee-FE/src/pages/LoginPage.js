import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router-dom";
// import {history} from "history"
class LoginPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isAuthenticated: "false",
      email: "",
      errorMessage:""
    };
  }
  changeHandler = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });

  };
  submitHandler = (e) => {
    e.preventDefault();
    const payload = this.state;
    console.log(payload);
    console.log(this);
    axios({
      method: 'post',
      url: "http://localhost:8080/authenticate",
      data: payload,
      headers: {'Content-Type': 'application/json' }
      })
      .then((response) => {
          //handle success
          this.setState({
            errorMessage:"",
            isAuthenticated : "true"
          });
          localStorage.setItem("token",response.data.token);
          console.log(this);
      })
      .catch((error) => {
          //handle error
          this.setState({
            errorMessage:error.response.data.message
          });
          console.log(error.response);
      });
    console.log("form submitted");
  };
  render() {
    if(this.state.isAuthenticated === "true"){
      return <Redirect to = "/dashboard"/>
    }

    return (
      <div className="form-wrapper">
        <h1>Sign In</h1>
        <form onSubmit={this.submitHandler}>
          <div className="email">
            <label htmlFor="email">Email</label>
            <input
              placeholder="Email"
              type="email"
              name="email"
              id="email"
              onChange={this.changeHandler}
            />
          </div>
          <div className="password">
            <label htmlFor="password">Password</label>
            <input
              placeholder="password"
              type="password"
              name="password"
              id="password"
              onChange={this.changeHandler}
            />
          </div>
          <label className = "errorMessage">{this.state.errorMessage}</label>
          <input type="submit" value="Login" />
        </form>
      </div>
    );
  }
}

export default LoginPage;
import React,{Component,Fragment} from "react";
import "../App.css";
import LoginPage from "./LoginPage";
import DashBoardPage from "./DashBoardPage"
import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";

class App extends Component {
  render(){
    return (
    <Router>
      <div className="wrapper">
        <Route exact path="/">
          <LoginPage/>
        </Route>
        <Route exact path="/dashboard">
          <DashBoardPage/>
        </Route>
      </div>
      </Router>
  );
  }
}

export default App;
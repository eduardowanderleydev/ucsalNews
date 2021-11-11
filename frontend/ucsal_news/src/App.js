import Login from './components/Pages/Login';
import Home from './components/Pages/Home'
import SignUp from './components/Pages/SignUp';
import Notfound from './components/Pages/NotFound';
 //import PrivateRoute from './components/Pages/PrivateRoute';

import './App.css'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/Login" component={Login}/>
          <Route exact path="/" component={Home}/>
          <Route exact path="/SignUp" component={SignUp}/>
          <Route component={Notfound}/>
        </Switch>  
      </Router>
    </div>
  );
}

export default App;
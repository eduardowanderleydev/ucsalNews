import Login from './components/Pages/Login';
import Home from './components/Pages/Home'
import SignUp from './components/Pages/SignUp';
import './App.css'

import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={Login}/>
          <Route exact path="/Home" component={Home}/>
          <Route exact path="/SignUp" component={SignUp}/>
        </Switch>  
      </Router>
    </div>
  );
}

export default App;
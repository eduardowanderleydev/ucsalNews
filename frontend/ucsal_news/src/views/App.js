import React from 'react'
import LoginPage from '../components/layout/Login';
import Content from '../components/layout/Content'

import {BrowserRouter as Router} from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <Router>
        <Content/>
        <LoginPage/>
      </Router>
    </div>
  );
}

export default App;

import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import Message from './Message';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          {/* <img src={logo} className="App-logo" alt="logo" /> */}
          <h1 className="App-title">Message Manager V2</h1>
        </header>
        <div>
          <Route exact path="/" component={Message} />
        </div>
      </div>
    </Router>
  );
}

export default App;

import React, { Component } from 'react'
import { ACCESS_TOKEN } from '../constants';
import Film from './film.jpg'
import './Welcome.css'

class Welcome extends Component {

  render() {
    return (
      <div style={{ backgroundImage: `url(${Film})` }} className="main-content">
        {this.props.currentUser ?
          <h3>Welcome {this.props.currentUser.name}!</h3>
          : ''}

      </div>
    );
  }
}



export default Welcome;
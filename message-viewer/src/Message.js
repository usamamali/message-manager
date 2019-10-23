import React, { Component } from 'react';
import axios from 'axios';

class Message extends Component {
  constructor(props) {
    super(props);
    this.state = { title: '', body: '', savedMessages: [] };
    this.handleInputChange = this.handleInputChange.bind(this);
  }

  componentDidMount() {}

  persistMessage = async event => {
    event.preventDefault();

    await axios.post('/message-api/api/v1/messages', {
      title: this.state.title,
      body: this.state.body
    });
  };

  getAllPersistedMessages = async event => {
    event.preventDefault();

    const messages = await axios.get('/message-api/api/v1/messages/all');
    this.setState({ savedMessages: messages.data });
  };

  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    console.log(value);

    var messageProperty = { ...this.state.message };

    console.log(messageProperty);

    messageProperty[name] = value;
    this.setState({ messageProperty });

    console.log(this.state.message);
  }

  renderSavedMessages() {
    const entries = [];

    for (let key in this.state.savedMessages) {
      entries.push(
        <div key={key}>
          <lable name="Title">
            <b>{this.state.savedMessages[key].title}</b>
          </lable>
          <br></br>
          <lable name="Body">{this.state.savedMessages[key].body}</lable>
          <br></br>
          <br></br>
        </div>
      );
    }

    return entries;
  }

  render() {
    return (
      <div>
        <div>
          <form onSubmit={this.persistMessage}>
            <label>
              Tile:
              <br></br>
              <input
                name="title"
                type="text"
                value={this.state.title}
                onChange={event => this.setState({ title: event.target.value })}
              />
            </label>
            <br></br>

            <label>
              Body:
              <br></br>
              <textarea
                name="body"
                rows="4"
                cols="50"
                value={this.state.body}
                // onChange={this.handleInputChange}
                onChange={event => this.setState({ body: event.target.value })}
              ></textarea>
            </label>
            <br></br>
            <button type="submit">Save</button>
          </form>
        </div>

        <button type="button" onClick={this.getAllPersistedMessages}>
          Get All Messages
        </button>

        <div>
          <h2>Persisted Messages:</h2>
          {this.renderSavedMessages()}
        </div>
      </div>
    );
  }
}

export default Message;

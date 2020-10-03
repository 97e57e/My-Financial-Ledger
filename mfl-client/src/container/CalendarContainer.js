import React, { Component } from "react";
import { connect } from "react-redux";
import Calendar from "../components/calendar";
import { increment, decrement } from "../modules/counter";

class CalendarContainer extends Component {
  handleIncrement = () => {
    this.props.increment();
  };

  handleDecrement = () => {
    this.props.decrement();
  };

  render() {
    const { number } = this.props;
    return (
      <Calendar
        value={number}
        onIncrement={this.handleIncrement}
        onDecrement={this.handleDecrement}
      />
    );
  }
}

const mapStateToProps = ({ counter }) => ({
  number: counter.number,
});

const mapDispatchToProps = { increment, decrement };

export default connect(mapStateToProps, mapDispatchToProps)(CalendarContainer);

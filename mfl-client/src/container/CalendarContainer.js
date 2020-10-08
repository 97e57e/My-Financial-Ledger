import React, { Component } from "react";
import { connect } from "react-redux";
import Calendar from "../components/calendar";
import { next_month, prev_month } from "../modules/month-manager";

class CalendarContainer extends Component {
  handleNextMonth = () => {
    this.props.next_month();
  };

  handlePrevMonth = () => {
    this.props.prev_month();
  };

  render() {
    const { number } = this.props;
    return (
      <Calendar
        value={number}
        onNextMonth={this.handleNextMonth}
        onPrevMonth={this.handlePrevMonth}
      />
    );
  }
}

const mapStateToProps = ({ monthManager }) => ({
  number: monthManager.number,
});

const mapDispatchToProps = { next_month, prev_month };

export default connect(mapStateToProps, mapDispatchToProps)(CalendarContainer);

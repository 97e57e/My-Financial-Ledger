import React, { Component } from "react";
import { connect } from "react-redux";
import Calendar from "../components/Calendar";
import { next_month, prev_month } from "../modules/date-reducer";

import "../assets/scss/container/calendarContainer.scss";

class CalendarContainer extends Component {
  handleNextMonth = () => {
    this.props.next_month();
  };

  handlePrevMonth = () => {
    this.props.prev_month();
  };

  render() {
    const { currentDate } = this.props;
    return (
      <div className="calendarContainer">
        <Calendar
          currentDate={currentDate}
          onNextMonth={this.handleNextMonth}
          onPrevMonth={this.handlePrevMonth}
        />
      </div>
    );
  }
}

const mapStateToProps = ({ dateReducer }) => ({
  currentDate: dateReducer.currentDate,
});

const mapDispatchToProps = { next_month, prev_month };

export default connect(mapStateToProps, mapDispatchToProps)(CalendarContainer);

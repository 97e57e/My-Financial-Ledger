import React, { Component } from "react";
import { connect } from "react-redux";
import Calendar from "../components/calendar";
import { next_month, prev_month } from "../modules/date-reducer";

class CalendarContainer extends Component {
  handleNextMonth = () => {
    this.props.next_month();
  };

  handlePrevMonth = () => {
    this.props.prev_month();
  };

  render() {
    const { currentYear, currentMonth, firstDayOfWeek } = this.props;
    return (
      <Calendar
        date={{ currentYear, currentMonth }}
        firstDayOfWeek={firstDayOfWeek}
        onNextMonth={this.handleNextMonth}
        onPrevMonth={this.handlePrevMonth}
      />
    );
  }
}

const mapStateToProps = ({ dateReducer }) => ({
  currentYear: dateReducer.currentYear,
  currentMonth: dateReducer.currentMonth,
  firstDayOfWeek: dateReducer.firstDayOfWeek,
});

const mapDispatchToProps = { next_month, prev_month };

export default connect(mapStateToProps, mapDispatchToProps)(CalendarContainer);

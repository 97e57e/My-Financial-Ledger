import React from "react";

function CalendarHead(props) {
  return <div className="CalendarHead">Calendar Head</div>;
}

function CalendarBody(props) {
  return (
    <div className="CalendarBody">
      <p>Calendar Body</p>
      <span>{props.date}</span>
    </div>
  );
}

function Calendar(props) {
  return (
    <div className="CalendarContainer">
      <CalendarHead date={"2020-10-02"} />
      <CalendarBody date={"2020-10-02"} />
    </div>
  );
}

export default Calendar;

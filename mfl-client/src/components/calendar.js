import React from "react";

function CalendarHead(props) {
  return (
    <div className="CalendarHead" style={{
      border: '1px solid black'
    }}>
      <p>Calendar Head</p>
      <button onClick={props.onNextMonth}>+</button>
      <button onClick={props.onPrevMonth}>-</button>
      <h2>{props.date.currentYear}.{props.date.currentMonth}</h2>
    </div>
  );
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
      {console.log(props.firstDayOfWeek)}
      <CalendarHead
        date={props.date}
        onNextMonth={props.onNextMonth}
        onPrevMonth={props.onPrevMonth}
      />
      <CalendarBody date={"2020-10-02"} />
    </div>
  );
}

export default Calendar;

import React from "react";

function CalendarHead(props) {
  return (
    <div className="CalendarHead">
      <p>Calendar Head</p>
      <button onClick={props.onIncrement}>+</button>
      <button onClick={props.onDecrement}>-</button>
      <h2>{props.value}</h2>
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
      <CalendarHead
        value={props.value}
        onIncrement={props.onIncrement}
        onDecrement={props.onDecrement}
      />
      <CalendarBody date={"2020-10-02"} />
    </div>
  );
}

export default Calendar;

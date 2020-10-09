import React from "react";

const dayOfWeekEn = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const dayOfWeekKo = ["일", "월", "화", "수", "목", "금", "토"];

function CalendarHead(props) {
  return (
    <div
      className="CalendarHead"
      style={{
        border: "1px solid black",
      }}
    >
      <p>Calendar Head</p>
      <button onClick={props.onNextMonth}>+</button>
      <button onClick={props.onPrevMonth}>-</button>
      <h2>
        {props.date.currentYear}.{props.date.currentMonth}
      </h2>
    </div>
  );
}

function CalendarBody(props) {
  return (
    <div className="CalendarBody">
      <p>Calendar Body</p>
      <p>
        {dayOfWeekEn[props.firstDayOfWeek]}({dayOfWeekKo[props.firstDayOfWeek]})
      </p>
    </div>
  );
}

function Calendar(props) {
  return (
    <div className="CalendarContainer">
      <CalendarHead
        date={props.date}
        onNextMonth={props.onNextMonth}
        onPrevMonth={props.onPrevMonth}
      />
      <CalendarBody date={props.date} firstDayOfWeek={props.firstDayOfWeek} />
    </div>
  );
}

export default Calendar;

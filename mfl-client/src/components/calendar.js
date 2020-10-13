import React from "react";
import "../assets/scss/components/calendar.scss";
import { getWeeksInMonth, lastDayOfMonth, startOfMonth } from "date-fns";

const dayOfWeekEn = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const dayOfWeekKo = ["일", "월", "화", "수", "목", "금", "토"];

function CalendarHead(props) {
  const date = props.date;

  return (
    <div
      className="calendarHead"
      style={{
        border: "1px solid black",
      }}
    >
      <p>Calendar Head</p>
      <button onClick={props.onNextMonth}>+</button>
      <button onClick={props.onPrevMonth}>-</button>
      <h2>
        {date.getFullYear()}.{date.getMonth() + 1}.{date.getDate()}
      </h2>
    </div>
  );
}

function makeBody(props) {
  const date = props.date;
  const firstDay = startOfMonth(date).getDay();
  const weeks = getWeeksInMonth(date);
  const lastDay = lastDayOfMonth(date).getDate();

  const body = [];

  for (let week = 0; week < weeks; week++) {
    body.push(
      <div className="row" key={week}>
        {Array(7)
          .fill(0)
          .map((n, i) => {
            const day = i + week * 7 - firstDay + 1;
            if (day > 0 && lastDay >= day) {
              return (
                <div className="dayBox" key={i}>
                  <div>
                    {dayOfWeekKo[i]}
                    <br></br>
                    {day}
                  </div>
                </div>
              );
            } else {
              return (
                <div className="dayBox" key={i}>
                  <div></div>
                </div>
              );
            }
          })}
      </div>
    );
  }
  return body;
}

function CalendarBody(props) {
  return (
    <div className="calendarBody">
      <div className="row">
        {Array(7)
          .fill(0)
          .map((n, i) => {
            return <div className="dayBox">{dayOfWeekEn[i]}</div>;
          })}
      </div>

      {makeBody(props)}
    </div>
  );
}

function Calendar(props) {
  return (
    <div className="calendar">
      {console.log(props)}
      <CalendarHead
        date={props.currentDate}
        onNextMonth={props.onNextMonth}
        onPrevMonth={props.onPrevMonth}
      />
      <CalendarBody date={props.currentDate} />
    </div>
  );
}

export default Calendar;

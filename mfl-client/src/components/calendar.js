import React from "react";
import "../assets/scss/components/calendar.scss";
import { getLastDayOfMonth } from "../utils/calendarUtils";

const dayOfWeekEn = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const dayOfWeekKo = ["일", "월", "화", "수", "목", "금", "토"];

function CalendarHead(props) {
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
        {props.date.currentYear}.{props.date.currentMonth}
      </h2>
    </div>
  );
}

function CaledarBodyDayOfWeek({ day }) {
  return <div className="dayBox">{dayOfWeekEn[day]}</div>;
}

function makeBodyHead() {
  const bodyHead = [];
  for (let i = 0; i < 7; i++) {
    bodyHead.push(<CaledarBodyDayOfWeek key={i} day={i} />);
  }
  return bodyHead;
}

function makeBody(props) {
  const { currentYear, currentMonth } = props.date;
  const fisrtDay = new Date(
    currentYear.toString() + "-" + currentMonth.toString() + "-1"
  ).getDay();

  const body = [];

  for (let week = 0; week < 6; week++) {
    body.push(
      <div className="row" key={week}>
        {Array(7)
          .fill(0)
          .map((n, i) => {
            const current = i + week * 7 - fisrtDay + 1;
            if (
              current > 0 &&
              getLastDayOfMonth(currentYear, currentMonth) >= current
            ) {
              return (
                <div className="dayBox" key={i}>
                  <div>
                    <span>{current}</span>
                    <br></br>i : {dayOfWeekKo[i]}
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
      <p>Calendar Body</p>

      <div className="row">{makeBodyHead()}</div>
      {makeBody(props)}
    </div>
  );
}

function Calendar(props) {
  return (
    <div className="calendar">
      <CalendarHead
        date={props.date}
        onNextMonth={props.onNextMonth}
        onPrevMonth={props.onPrevMonth}
      />
      <CalendarBody date={props.date} />
    </div>
  );
}

export default Calendar;

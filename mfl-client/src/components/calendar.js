import React from "react";
import "../assets/scss/components/calendar.scss";
import { getWeeksInMonth, lastDayOfMonth, startOfMonth } from "date-fns";

const dayOfWeekEn = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const dayOfWeekKo = ["일", "월", "화", "수", "목", "금", "토"];

function CalendarHead(props) {
  const date = props.date;

  return (
    <div className="calendarHead">
      <div className="headItem headButtonArea">
        <button onClick={props.onPrevMonth}>-</button>
      </div>
      <div className="headItem">
        <h2>
          {date.getFullYear()}.{date.getMonth() + 1}
        </h2>
      </div>
      <div className="headItem headButtonArea">
        <button onClick={props.onNextMonth}>+</button>
      </div>
    </div>
  );
}

function makeBody(props) {
  const date = props.date;
  const firstDay = startOfMonth(date).getDay();
  const weeks = getWeeksInMonth(date);
  const lastDay = lastDayOfMonth(date).getDate();

  const body = [];
  const hello = "h";

  for (let week = 0; week < weeks; week++) {
    body.push(
      <div className="row" key={week}>
        {Array(7)
          .fill(0)
          .map((n, i) => {
            const day = i + week * 7 - firstDay + 1;
            if (day > 0 && lastDay >= day) {
              return (
                <div className={`box dateBox ${"day" + i}`} key={i}>
                  <div>
                    {dayOfWeekKo[i]}
                    <br></br>
                    {day}
                  </div>
                </div>
              );
            } else {
              return (
                <div className="box dateBox" key={i}>
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
            return (
              <div className={`box ${"day" + i}`} key={i}>
                {dayOfWeekEn[i]}
              </div>
            );
          })}
      </div>

      {makeBody(props)}
    </div>
  );
}

function Calendar(props) {
  return (
    <div className="calendar">
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

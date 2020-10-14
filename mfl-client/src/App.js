import React from "react";
import "./assets/scss/global/common.scss";
import SideBar from "./components/SideBar";

import CalendarContainer from "./container/CalendarContainer";

function App() {
  return (
    <div className="App">
      <SideBar />
      <CalendarContainer />
    </div>
  );
}

export default App;

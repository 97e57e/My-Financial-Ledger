import React from "react";

import "../assets/scss/components/sideBar.scss";

function SideBar() {
  return (
    <div className="sideBar">
      <div className="sideBarHeadArea">
        <p>여기에 로고나 이름을 넣자, 근데 고로가 있나?</p>
      </div>
      <div className="sideBarMenuArea">
        <p>기능이 있나?</p>
        <ul>
          <li>그런거 없는데...</li>
          <li>아직 생각 안했는데...</li>
          <li>생기면 넣지 뭐...</li>
        </ul>
      </div>
    </div>
  );
}

export default SideBar;

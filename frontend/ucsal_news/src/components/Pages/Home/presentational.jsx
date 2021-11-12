import React from "react";

import AsideNav from "./AsideNav";
import MainContent from "./MainContent";

import "./styles.css";

function Home() {
  return (
    <div className="container_components">
      <AsideNav />
      <MainContent />
    </div>
  );
}

export default Home;

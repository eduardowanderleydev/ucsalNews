import React from "react";

import "./styles.css";

import { AiFillGithub, AiFillLinkedin } from "react-icons/ai";

function SocialFollow() {
  return (
    <div>
      <div className="social-container">
        <h3>Social Follow</h3>
          <span className="member-team">Caio Macedo <span className="frufru">(Back-end Developer):</span></span>
          <div className="member-info-container">
          <a href="https://github.com/ccaiomacedo">
            <div className="social-medias-icons">
              <AiFillGithub color="black" size="2em" />
            </div>
          </a>
          <a href="https://www.linkedin.com/in/caio-macedo-728851208/">
            <div className="social-medias-icons">
              <AiFillLinkedin color="black" size="2em" />
            </div>
          </a>
        </div>

        <span className="member-team">Eduardo Pinto <span className="frufru">(Back-end Developer):</span></span>
          <div className="member-info-container">
          <a href="https://github.com/eduardowanderleydev">
            <div className="social-medias-icons">
              <AiFillGithub color="black" size="2em" />
            </div>
          </a>
          <a href="https://www.linkedin.com/in/eduardowanderleydev/">
            <div className="social-medias-icons">
              <AiFillLinkedin color="black" size="2em" />
            </div>
          </a>
        </div>

        <span className="member-team">Guilherme Falcão <span className="frufru">(Front-end Developer):</span></span>
          <div className="member-info-container">
          <a href="https://github.com/guilhermefcs7">
            <div className="social-medias-icons">
              <AiFillGithub color="black" size="2em" />
            </div>
          </a>
          <a href="https://www.linkedin.com/in/guilherme-falcão-580718208/">
            <div className="social-medias-icons">
              <AiFillLinkedin color="black" size="2em" />
            </div>
          </a>
        </div>

        <span className="member-team">Guilherme Pontes <span className="frufru">(Back-end Developer):</span></span>
          <div className="member-info-container">
          <a href="https://github.com/GuilhermePontes1">
            <div className="social-medias-icons">
              <AiFillGithub color="black" size="2em" />
            </div>
          </a>
          <a href="https://www.linkedin.com/in/guilherme-pontes-baa319199/">
            <div className="social-medias-icons">
              <AiFillLinkedin color="black" size="2em" />
            </div>
          </a>
        </div>

        
      </div>
    </div>
  );
}

export default SocialFollow;

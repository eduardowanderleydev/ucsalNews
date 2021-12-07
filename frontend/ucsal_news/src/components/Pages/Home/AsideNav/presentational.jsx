import React from 'react'

import SocialFollow from '../../../Generic/Contact';

import './styles.css'

function AsideNav() {
    return (
        <div>
            <header className="tm-header" id="tm-header">
        <aside>
          <div className="tm-header-wrapper">
            <div className="tm-site-header">
              <h1 className="text-center">Ucsal News</h1>
            </div>
            <nav className="tm-nav" id="tm-nav">
              <ul>
                <li className="tm-nav-item active">
                  <span className="tm-nav-link">
                    <i className="fas fa-home"></i>
                    Blog Home
                  </span>
                </li>
              </ul>
            </nav>
            <div className="social-media-container">
                <SocialFollow/>
            </div>
          </div>
        </aside>
      </header>
        </div>
    )
}

export default AsideNav;

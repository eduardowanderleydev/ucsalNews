import React from 'react'

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
                  <a href="index.html" className="tm-nav-link">
                    <i className="fas fa-home"></i>
                    Blog Home
                  </a>
                </li>
                <li className="tm-nav-item">
                  <a href="post.html" className="tm-nav-link">
                    <i className="fas fa-pen"></i>
                    Single Post
                  </a>
                </li>
                <li className="tm-nav-item">
                  <a href="about.html" className="tm-nav-link">
                    <i className="fas fa-users"></i>
                    About Xtra
                  </a>
                </li>
                <li className="tm-nav-item">
                  <a href="contact.html" className="tm-nav-link">
                    <i className="far fa-comments"></i>
                    Contact Us
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </aside>
      </header>
        </div>
    )
}

export default AsideNav;

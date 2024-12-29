import { BrowserRouter, Route, Routes } from 'react-router-dom';
import useLocalStorage from 'use-local-storage'
import './App.css'
import B_Slogan from '../Components/B_Slogan';

function App() {
  const [darkTheme, setDarkTheme] = useLocalStorage("darkTheme", false);

  return (



      <div data-theme={darkTheme ? "dark" : "light"}>
        <nav className="navbar navbar-expand-lg bg-body-tertiary" id="header">
          <div className="container-fluid">
            <div id="div-logo">
            <i className="bi bi-lightbulb-fill" id='logo'></i>
              <h1 id="invoice">Glow</h1>
            </div>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span><i className="bi bi-blockquote-right"></i></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <a  className="nav-link active" aria-current="page">Home</a>
                </li>
                <li className="nav-item">
                <a className="nav-link active" aria-current="page">Filters</a>
                </li>
                <li className="nav-item">
                <a className="nav-link active" aria-current="page">Built With</a>
                </li>
                <li className="nav-item">
                <a className="nav-link active" aria-current="page">Get in Touch</a>
                </li>
              </ul>

              {/* Theme */}

              <div id="theme-box">
                <input type="checkbox" className="checkbox" id="checkbox" onChange={() => {
                  setDarkTheme(!darkTheme);
                }} checked={darkTheme} />
                <label htmlFor="checkbox" className="checkbox-label">
                  <i className="bi bi-moon-stars-fill" id="fa-moon"></i>
                  <i className="bi bi-brightness-high-fill" id="fa-sun"></i>
                  <span className="ball"></span>
                </label>
              </div>
            </div>

          </div>
        </nav>
      <hr className="line"></hr>


      <B_Slogan />
      </div>

      

  )
}

export default App

import { useState, useEffect } from "react";
import {
  getWeather,
  getRisk,
  planRoute,
  calculateFuel,
  sendSOS,
  getDashboard
} from "./api";

import "./App.css";

function App() {

  const [activePage, setActivePage] = useState("Dashboard");

  const [dashboard, setDashboard] = useState(null);

  const [weather, setWeather] = useState(null);
  const [weatherLocation, setWeatherLocation] = useState("");
  const [weatherError, setWeatherError] = useState("");
  const [weatherLoading, setWeatherLoading] = useState(false);

  useEffect(() => {
    loadDashboard();
  }, []);

  const loadDashboard = async () => {
    try {
      const data = await getDashboard();
      setDashboard(data);
    } catch {
      setDashboard(null);
    }
  };

  const checkWeather = async () => {

    if (!weatherLocation.trim()) {
      setWeatherError("Please enter a location");
      return;
    }

    try {

      setWeatherLoading(true);
      setWeatherError("");

      const data = await getWeather(weatherLocation);

      setWeather(data);

    } catch {

      setWeatherError("Unable to fetch weather");

    } finally {

      setWeatherLoading(false);

    }
  };

  const openPage = (page) => {
    setActivePage(page);
  };

  return (

    <div className="app">

      {/* SIDEBAR */}

      <aside className="sidebar">

        <div className="logo">

          <div className="logo-icon">
            🌊
          </div>

          <div>
            <h2>WaveWise</h2>
            <span>Maritime Safety</span>
          </div>

        </div>


        <nav>

          <button
            className={activePage === "Dashboard" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Dashboard")}
          >
            🏠
            <span>Dashboard</span>
          </button>


          <button
            className={activePage === "Weather" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Weather")}
          >
            🌤️
            <span>Weather</span>
          </button>


          <button
            className={activePage === "Risk Prediction" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Risk Prediction")}
          >
            ⚠️
            <span>Risk Prediction</span>
          </button>


          <button
            className={activePage === "Route Planner" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Route Planner")}
          >
            🧭
            <span>Route Planner</span>
          </button>


          <button
            className={activePage === "Fuel Calculator" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Fuel Calculator")}
          >
            ⛽
            <span>Fuel Calculator</span>
          </button>


          <button
            className={activePage === "GPS Tracking" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("GPS Tracking")}
          >
            📍
            <span>GPS Tracking</span>
          </button>


          <button
            className={activePage === "Emergency SOS" ? "nav-item active" : "nav-item"}
            onClick={() => openPage("Emergency SOS")}
          >
            🚨
            <span>Emergency SOS</span>
          </button>

        </nav>


        <div className="sidebar-bottom">

          <div className="safety-status">
            <span className="status-dot"></span>
            System Online
          </div>

        </div>

      </aside>


      {/* MAIN */}

      <div className="main-area">

        {/* TOP BAR */}

        <header className="topbar">

          <div>

            <h1>{activePage}</h1>

            <p>
              AI-powered maritime safety & navigation
            </p>

          </div>


          <div className="profile">

            <span className="notification">
              🔔
            </span>

            <div className="profile-circle">
              K
            </div>

            <div>
              <strong>Fisherman</strong>
              <small>Safe Journey</small>
            </div>

          </div>

        </header>


        <main className="content">

          {/* DASHBOARD */}

          {activePage === "Dashboard" && (

            <DashboardPage
              dashboard={dashboard}
              weather={weather}
              weatherLocation={weatherLocation}
              setWeatherLocation={setWeatherLocation}
              weatherError={weatherError}
              weatherLoading={weatherLoading}
              checkWeather={checkWeather}
              openPage={openPage}
            />

          )}


          {/* WEATHER */}

          {activePage === "Weather" && (

            <WeatherPage />

          )}


          {/* RISK */}

          {activePage === "Risk Prediction" && (

            <RiskPage />

          )}


          {/* ROUTE */}

          {activePage === "Route Planner" && (

            <RoutePage />

          )}


          {/* FUEL */}

          {activePage === "Fuel Calculator" && (

            <FuelPage />

          )}


          {/* GPS */}

          {activePage === "GPS Tracking" && (

            <GPSPage />

          )}


          {/* SOS */}

          {activePage === "Emergency SOS" && (

            <EmergencyPage />

          )}

        </main>

      </div>

    </div>

  );
}


/* =========================
   DASHBOARD
========================= */

function DashboardPage({
  dashboard,
  weather,
  weatherLocation,
  setWeatherLocation,
  weatherError,
  weatherLoading,
  checkWeather,
  openPage
}) {

  return (

    <div className="dashboard">

      <section className="hero">

        <div>

          <span className="hero-label">
            WELCOME TO WAVEWISE
          </span>

          <h2>
            Stay Safe.<br />
            Navigate Smart.
          </h2>

          <p>
            AI-powered safety and navigation tools
            designed for fishermen.
          </p>

        </div>

        <div className="hero-icon">
          🌊
        </div>

      </section>


      {/* STAT CARDS */}

      <section className="stats-grid">

        <div className="stat-card">

          <div className="stat-icon blue">
            👤
          </div>

          <div>
            <span>Total Users</span>

            <h3>
              {dashboard ? dashboard.totalUsers : 0}
            </h3>

            <small>
              Registered users
            </small>
          </div>

        </div>


        <div className="stat-card">

          <div className="stat-icon green">
            🚤
          </div>

          <div>
            <span>Total Boats</span>

            <h3>
              {dashboard ? dashboard.totalBoats : 0}
            </h3>

            <small>
              Registered boats
            </small>
          </div>

        </div>


        <div className="stat-card">

          <div className="stat-icon red">
            🚨
          </div>

          <div>
            <span>Active Emergencies</span>

            <h3>
              {dashboard ? dashboard.activeEmergencies : 0}
            </h3>

            <small>
              Emergency alerts
            </small>
          </div>

        </div>


        <div className="stat-card">

          <div className="stat-icon purple">
            📍
          </div>

          <div>
            <span>GPS Status</span>

            <h3>Active</h3>

            <small>
              Location tracking
            </small>
          </div>

        </div>

      </section>


      {/* WEATHER */}

      <section className="weather-search-card">

        <div>

          <h3>
            🌤️ Live Weather
          </h3>

          <p>
            Check current weather conditions
            before going fishing.
          </p>

        </div>


        <div className="weather-search">

          <input
            type="text"
            placeholder="Enter location..."
            value={weatherLocation}
            onChange={(e) =>
              setWeatherLocation(e.target.value)
            }
            onKeyDown={(e) => {
              if (e.key === "Enter") {
                checkWeather();
              }
            }}
          />

          <button onClick={checkWeather}>
            {weatherLoading ? "Checking..." : "Check Weather"}
          </button>

        </div>


        {weatherError && (

          <div className="weather-error-box">
            {weatherError}
          </div>

        )}


        {weather && (

          <div className="weather-result">

            <div>
              <span>Location</span>
              <strong>{weather.location}</strong>
            </div>

            <div>
              <span>Weather</span>
              <strong>{weather.weather}</strong>
            </div>

            <div>
              <span>Temperature</span>
              <strong>{weather.temperature} °C</strong>
            </div>

            <div>
              <span>Wind</span>
              <strong>{weather.windSpeed} m/s</strong>
            </div>

            <div>
              <span>Safety</span>
              <strong>{weather.safetyStatus}</strong>
            </div>

          </div>

        )}

      </section>


      {/* SAFETY */}

      <section className="dashboard-grid">

        <div className="panel">

          <h3>
            🛡️ Safety Overview
          </h3>

          <div className="safety-row">

            <span>Safe Weather Zones</span>

            <strong>
              {dashboard ? dashboard.safeWeatherZones : 0}
            </strong>

          </div>


          <div className="safety-row">

            <span>High Risk Zones</span>

            <strong>
              {dashboard ? dashboard.highRiskZones : 0}
            </strong>

          </div>


          <div className="safety-row">

            <span>System Status</span>

            <strong className="safe-text">
              {dashboard ? dashboard.systemStatus : "ACTIVE"}
            </strong>

          </div>

        </div>


        <div className="panel emergency-panel">

          <h3>
            🚨 Emergency Center
          </h3>

          <p>
            In case of emergency, send your
            location immediately.
          </p>

          <button
            className="sos-button"
            onClick={() => openPage("Emergency SOS")}
          >
            🚨 SEND SOS
          </button>

        </div>

      </section>


      {/* QUICK ACTIONS */}

      <section className="quick-actions">

        <h3>
          Quick Actions
        </h3>

        <div className="quick-grid">

          <button onClick={() => openPage("Weather")}>
            🌤️
            <span>Weather</span>
          </button>

          <button onClick={() => openPage("Risk Prediction")}>
            ⚠️
            <span>Risk Prediction</span>
          </button>

          <button onClick={() => openPage("Route Planner")}>
            🧭
            <span>Plan Route</span>
          </button>

          <button onClick={() => openPage("GPS Tracking")}>
            📍
            <span>GPS Tracking</span>
          </button>

        </div>

      </section>

    </div>

  );
}


/* =========================
   WEATHER PAGE
========================= */

function WeatherPage() {

  const [location, setLocation] = useState("");
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const searchWeather = async () => {

    if (!location.trim()) {
      setError("Please enter a location");
      return;
    }

    try {

      setLoading(true);
      setError("");

      const data = await getWeather(location);

      setWeather(data);

    } catch {

      setError("Unable to fetch weather");

    } finally {

      setLoading(false);

    }
  };

  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          Weather Monitoring
        </h2>

        <p>
          Get real-time weather information for
          your fishing location.
        </p>

      </div>


      <div className="weather-search-card">

        <div className="weather-search">

          <input
            type="text"
            placeholder="Enter location..."
            value={location}
            onChange={(e) => setLocation(e.target.value)}
          />

          <button onClick={searchWeather}>
            {loading ? "Loading..." : "Check Weather"}
          </button>

        </div>

      </div>


      {error && (

        <div className="weather-error-box">
          {error}
        </div>

      )}


      {weather && (

        <div className="weather-result weather-full-result">

          <div>
            <span>Location</span>
            <strong>{weather.location}</strong>
          </div>

          <div>
            <span>Weather</span>
            <strong>{weather.weather}</strong>
          </div>

          <div>
            <span>Temperature</span>
            <strong>{weather.temperature} °C</strong>
          </div>

          <div>
            <span>Wind Speed</span>
            <strong>{weather.windSpeed} m/s</strong>
          </div>

          <div>
            <span>Safety Status</span>
            <strong>{weather.safetyStatus}</strong>
          </div>

          <div>
            <span>Recommendation</span>
            <strong>{weather.recommendation}</strong>
          </div>

        </div>

      )}

    </div>

  );
}


/* =========================
   RISK PAGE
========================= */

function RiskPage() {

  const [location, setLocation] = useState("");
  const [risk, setRisk] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const calculateRisk = async () => {

    if (!location.trim()) {
      setError("Please enter a location");
      return;
    }

    try {

      setLoading(true);
      setError("");

      const data = await getRisk(location);

      setRisk(data);

    } catch {

      setError("Unable to calculate risk");

    } finally {

      setLoading(false);

    }
  };

  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          Risk Prediction
        </h2>

        <p>
          Analyze weather conditions and calculate
          fishing risk.
        </p>

      </div>


      <div className="weather-search-card">

        <div className="weather-search">

          <input
            type="text"
            placeholder="Enter fishing location..."
            value={location}
            onChange={(e) => setLocation(e.target.value)}
          />

          <button onClick={calculateRisk}>
            {loading ? "Calculating..." : "Calculate Risk"}
          </button>

        </div>

      </div>


      {error && (

        <div className="weather-error-box">
          {error}
        </div>

      )}


      {risk && (

        <div className="risk-result">

          <h3>
            Risk Assessment
          </h3>

          <div className="risk-score">
            {risk.riskScore}
          </div>

          <h2>
            {risk.riskLevel}
          </h2>

          <p>
            {risk.recommendation}
          </p>

        </div>

      )}

    </div>

  );
}


/* =========================
   ROUTE PAGE
========================= */

function RoutePage() {

  const [startLatitude, setStartLatitude] = useState("");
  const [startLongitude, setStartLongitude] = useState("");
  const [destinationLatitude, setDestinationLatitude] = useState("");
  const [destinationLongitude, setDestinationLongitude] = useState("");

  const [route, setRoute] = useState(null);
  const [error, setError] = useState("");

  const handlePlanRoute = async () => {

    if (
      !startLatitude ||
      !startLongitude ||
      !destinationLatitude ||
      !destinationLongitude
    ) {
      setError("Please enter all coordinates");
      return;
    }

    try {

      setError("");

      const data = await planRoute(
        Number(startLatitude),
        Number(startLongitude),
        Number(destinationLatitude),
        Number(destinationLongitude)
      );

      setRoute(data);

    } catch {

      setError("Unable to plan route");

    }

  };

  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          Route Planner
        </h2>

        <p>
          Calculate the distance between two
          geographical locations.
        </p>

      </div>


      <div className="route-form">

        <h3>
          Starting Location
        </h3>

        <div className="coordinate-row">

          <input
            type="number"
            placeholder="Start Latitude"
            value={startLatitude}
            onChange={(e) =>
              setStartLatitude(e.target.value)
            }
          />

          <input
            type="number"
            placeholder="Start Longitude"
            value={startLongitude}
            onChange={(e) =>
              setStartLongitude(e.target.value)
            }
          />

        </div>


        <h3>
          Destination
        </h3>

        <div className="coordinate-row">

          <input
            type="number"
            placeholder="Destination Latitude"
            value={destinationLatitude}
            onChange={(e) =>
              setDestinationLatitude(e.target.value)
            }
          />

          <input
            type="number"
            placeholder="Destination Longitude"
            value={destinationLongitude}
            onChange={(e) =>
              setDestinationLongitude(e.target.value)
            }
          />

        </div>


        <button
          className="route-button"
          onClick={handlePlanRoute}
        >
          PLAN ROUTE
        </button>

      </div>


      {error && (

        <div className="weather-error-box">
          {error}
        </div>

      )}


      {route && (

        <div className="route-result">

          <h3>
            Route Result
          </h3>

          <p>
            Distance:
            <strong>
              {" "}
              {route.distance.toFixed(2)} km
            </strong>
          </p>

          <p>
            Status:
            <strong>
              {" "}
              {route.routeStatus}
            </strong>
          </p>

          <p>
            {route.recommendation}
          </p>

        </div>

      )}

    </div>

  );
}


/* =========================
   FUEL PAGE
========================= */

function FuelPage() {

  const [distance, setDistance] = useState("");
  const [fuelRemaining, setFuelRemaining] = useState("");

  const [result, setResult] = useState(null);
  const [error, setError] = useState("");

  const handleFuel = async () => {

    if (!distance || fuelRemaining === "") {
      setError("Please enter distance and fuel");
      return;
    }

    try {

      setError("");

      const data = await calculateFuel(
        Number(distance),
        Number(fuelRemaining)
      );

      setResult(data);

    } catch {

      setError("Unable to calculate fuel");

    }

  };

  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          Fuel Calculator
        </h2>

        <p>
          Calculate the fuel required for your journey.
        </p>

      </div>


      <div className="route-form">

        <input
          type="number"
          placeholder="Distance (km)"
          value={distance}
          onChange={(e) =>
            setDistance(e.target.value)
          }
        />

        <input
          type="number"
          placeholder="Fuel Remaining (litres)"
          value={fuelRemaining}
          onChange={(e) =>
            setFuelRemaining(e.target.value)
          }
        />

        <button
          className="route-button"
          onClick={handleFuel}
        >
          CALCULATE FUEL
        </button>

      </div>


      {error && (

        <div className="weather-error-box">
          {error}
        </div>

      )}


      {result && (

        <div className="route-result">

          <h3>
            Fuel Result
          </h3>

          <p>
            Distance:
            <strong> {result.distance} km</strong>
          </p>

          <p>
            Fuel Required:
            <strong> {result.fuelRequired.toFixed(2)} L</strong>
          </p>

          <p>
            Fuel Remaining:
            <strong> {result.fuelRemaining} L</strong>
          </p>

          <p>
            Status:
            <strong> {result.status}</strong>
          </p>

          <p>
            {result.recommendation}
          </p>

        </div>

      )}

    </div>

  );
}


/* =========================
   GPS PAGE
========================= */

function GPSPage() {

  const [latitude, setLatitude] = useState("");
  const [longitude, setLongitude] = useState("");
  const [status, setStatus] = useState("");

  const getLocation = () => {

    setStatus("Getting your location...");

    if (!navigator.geolocation) {

      setStatus(
        "Geolocation is not supported by this browser."
      );

      return;
    }

    navigator.geolocation.getCurrentPosition(

      (position) => {

        setLatitude(
          position.coords.latitude.toFixed(6)
        );

        setLongitude(
          position.coords.longitude.toFixed(6)
        );

        setStatus(
          "GPS location updated successfully."
        );

      },

      () => {

        setStatus(
          "Unable to access GPS location."
        );

      }

    );

  };

  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          GPS Tracking
        </h2>

        <p>
          Track the current GPS coordinates of the fishing boat.
        </p>

      </div>


      <div className="gps-card">

        <div className="gps-icon">
          📍
        </div>

        <h3>
          Current Location
        </h3>


        <button
          className="gps-button"
          onClick={getLocation}
        >
          GET MY LOCATION
        </button>


        <div className="gps-coordinates">

          <div>

            <span>
              Latitude
            </span>

            <strong>
              {latitude || "--"}
            </strong>

          </div>


          <div>

            <span>
              Longitude
            </span>

            <strong>
              {longitude || "--"}
            </strong>

          </div>

        </div>


        {status && (

          <p className="gps-status">
            {status}
          </p>

        )}

      </div>

    </div>

  );
}


/* =========================
   EMERGENCY SOS PAGE
========================= */

function EmergencyPage() {

  const [name, setName] = useState("");
  const [boatNumber, setBoatNumber] = useState("");
  const [latitude, setLatitude] = useState("");
  const [longitude, setLongitude] = useState("");

  const [emergency, setEmergency] = useState(null);
  const [error, setError] = useState("");

  const getLocation = () => {

    if (!navigator.geolocation) {
      setError("Geolocation is not supported");
      return;
    }

    navigator.geolocation.getCurrentPosition(

      (position) => {

        setLatitude(
          position.coords.latitude.toFixed(6)
        );

        setLongitude(
          position.coords.longitude.toFixed(6)
        );

      },

      () => {

        setError("Unable to access GPS location");

      }

    );

  };


  const sendEmergencySOS = async () => {

    if (
      !name ||
      !boatNumber ||
      !latitude ||
      !longitude
    ) {

      setError(
        "Please fill in all emergency details"
      );

      return;
    }

    try {

      setError("");

      const data = await sendSOS(
        name,
        boatNumber,
        latitude,
        longitude
      );

      setEmergency(data);

    } catch {

      setError("Unable to send SOS");

    }

  };


  return (

    <div className="weather-page">

      <div className="page-heading">

        <h2>
          Emergency SOS
        </h2>

        <p>
          Send an emergency alert with your current location.
        </p>

      </div>


      <div className="sos-form">

        <h3>
          Emergency Details
        </h3>


        <input
          type="text"
          placeholder="Fisherman Name"
          value={name}
          onChange={(e) =>
            setName(e.target.value)
          }
        />


        <input
          type="text"
          placeholder="Boat Number"
          value={boatNumber}
          onChange={(e) =>
            setBoatNumber(e.target.value)
          }
        />


        <div className="coordinate-row">

          <input
            type="number"
            placeholder="Latitude"
            value={latitude}
            onChange={(e) =>
              setLatitude(e.target.value)
            }
          />

          <input
            type="number"
            placeholder="Longitude"
            value={longitude}
            onChange={(e) =>
              setLongitude(e.target.value)
            }
          />

        </div>


        <button
          className="location-button"
          onClick={getLocation}
        >
          📍 USE MY CURRENT LOCATION
        </button>


        <button
          className="sos-large-button"
          onClick={sendEmergencySOS}
        >
          🚨 SEND EMERGENCY SOS
        </button>

      </div>


      {error && (

        <div className="weather-error-box">
          {error}
        </div>

      )}


      {emergency && (

        <div className="sos-success">

          <div className="success-icon">
            ✓
          </div>

          <h3>
            SOS Sent Successfully
          </h3>

          <p>
            Emergency status:
            <strong> {emergency.status}</strong>
          </p>

          <p>
            Emergency ID:
            <strong> {emergency.id}</strong>
          </p>

          <p>
            Emergency location:
            <strong>
              {" "}
              {emergency.latitude},
              {" "}
              {emergency.longitude}
            </strong>
          </p>

          <p>
            Emergency alert has been registered.
          </p>

        </div>

      )}

    </div>

  );
}


export default App;
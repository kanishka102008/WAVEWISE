const API_BASE_URL = "http://localhost:8080";

export async function getWeather(location) {
  const response = await fetch(
    `${API_BASE_URL}/weather/${encodeURIComponent(location)}`
  );

  if (!response.ok) throw new Error("Unable to fetch weather");

  return response.json();
}

export async function getRisk(location) {
  const response = await fetch(
    `${API_BASE_URL}/risk/${encodeURIComponent(location)}`
  );

  if (!response.ok) throw new Error("Unable to fetch risk");

  return response.json();
}

export async function planRoute(
  startLatitude,
  startLongitude,
  destinationLatitude,
  destinationLongitude
) {
  const params = new URLSearchParams({
    startLatitude,
    startLongitude,
    destinationLatitude,
    destinationLongitude
  });

  const response = await fetch(
    `${API_BASE_URL}/route/plan?${params.toString()}`
  );

  if (!response.ok) throw new Error("Unable to plan route");

  return response.json();
}

export async function calculateFuel(distance, fuelRemaining) {
  const params = new URLSearchParams({
    distance,
    fuelRemaining
  });

  const response = await fetch(
    `${API_BASE_URL}/fuel/calculate?${params.toString()}`
  );

  if (!response.ok) throw new Error("Unable to calculate fuel");

  return response.json();
}

export async function sendSOS(
  fishermanName,
  boatNumber,
  latitude,
  longitude
) {
  const response = await fetch(
    `${API_BASE_URL}/emergency/sos`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        fishermanName,
        boatNumber,
        latitude: Number(latitude),
        longitude: Number(longitude)
      })
    }
  );

  if (!response.ok) {
    throw new Error("Unable to send SOS");
  }

  return response.json();
}
export async function getDashboard() {
  const response = await fetch(
    "http://localhost:8080/dashboard"
  );

  if (!response.ok) {
    throw new Error("Unable to fetch dashboard");
  }

  return response.json();
}
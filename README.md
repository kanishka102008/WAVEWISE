# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some Oxlint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react) uses [Oxc](https://oxc.rs)
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react-swc) uses [SWC](https://swc.rs/)

## React Compiler

The React Compiler is not enabled on this template because of its impact on dev & build performances. To add it, see [this documentation](https://react.dev/learn/react-compiler/installation).

## Expanding the Oxlint configuration

If you are developing a production application, we recommend using TypeScript with type-aware lint rules enabled. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) for information on how to integrate TypeScript and Oxlint's TypeScript related rules in your project.
# 🌊 WaveWise

## AI-Powered Fisherman Safety and Route Planning System

WaveWise is a Java-based web application designed to improve the safety of fishermen by providing weather-based risk information, fuel estimation, route assistance, and an emergency SOS notification system.

## 🚨 Problem Statement

Fishermen often face unpredictable weather conditions, limited access to real-time safety information, fuel management difficulties, and delays in receiving emergency assistance.

WaveWise aims to provide a simple digital platform that helps fishermen make safer decisions before and during their journey.

## 💡 Solution

WaveWise provides:

- 🌦️ Weather and sea-condition information
- ⚠️ Weather-based safety/risk status
- ⛽ Fuel estimation
- 🗺️ Route planning support
- 🚨 Emergency SOS system
- 📢 Notification of nearby fishermen during emergencies
- 📊 Safety dashboard

## 🚨 Emergency SOS

The SOS feature is one of the major features of WaveWise.

When a fisherman sends an emergency SOS:

1. The emergency request is recorded.
2. The system identifies the emergency location.
3. Nearby fishermen can be notified.
4. The emergency status can be tracked.
5. The emergency can be resolved once assistance is provided.

## 🛠️ Technologies Used

### Frontend

- React.js
- Vite
- JavaScript
- HTML
- CSS

### Backend

- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- H2 Database

### Development Tools

- IntelliJ IDEA
- Visual Studio Code
- Git
- GitHub
- Maven

## 🏗️ System Architecture

```text
              ┌─────────────────────┐
              │     React Frontend  │
              └──────────┬──────────┘
                         │
                      REST API
                         │
              ┌──────────▼──────────┐
              │   Spring Boot       │
              │      Backend        │
              └──────────┬──────────┘
                         │
          ┌──────────────┼──────────────┐
          │              │              │
      Weather         Emergency       Fuel
       Service         Service       Service
          │              │              │
          └──────────────┼──────────────┘
                         │
                  ┌──────▼──────┐
                  │  Database   │
                  └─────────────┘

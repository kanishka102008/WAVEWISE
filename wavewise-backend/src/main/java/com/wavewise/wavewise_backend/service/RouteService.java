package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.RouteResponse;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    public RouteResponse planRoute(double startLatitude,
                                   double startLongitude,
                                   double destinationLatitude,
                                   double destinationLongitude) {

        // Calculate approximate distance using the Haversine formula
        double earthRadius = 6371.0;

        double latDifference = Math.toRadians(
                destinationLatitude - startLatitude);

        double lonDifference = Math.toRadians(
                destinationLongitude - startLongitude);

        double a = Math.sin(latDifference / 2)
                * Math.sin(latDifference / 2)
                + Math.cos(Math.toRadians(startLatitude))
                * Math.cos(Math.toRadians(destinationLatitude))
                * Math.sin(lonDifference / 2)
                * Math.sin(lonDifference / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;

        String routeStatus;
        String recommendation;

        if (distance > 100) {
            routeStatus = "LONG_ROUTE";
            recommendation = "Long-distance route. Check weather and fuel before departure.";
        } else {
            routeStatus = "NORMAL";
            recommendation = "Route distance is within the normal range.";
        }

        return new RouteResponse(
                startLatitude,
                startLongitude,
                destinationLatitude,
                destinationLongitude,
                distance,
                routeStatus,
                recommendation
        );
    }
}

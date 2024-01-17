import React, { useEffect, useRef } from "react";

function MapaParticipantes({ marcadorAtacante, marcadorVictima, poligonos }) {
  const mapRef = useRef(null);
  const infoWindowRef = useRef(null);
  const poligonosRef = useRef([]);
  const marcadorAtacanteMarkerRef = useRef(null);
  const marcadorVictimaMarkerRef = useRef(null);

  useEffect(() => {
    let map;
    let infoWindow;

    function initMap() {
      map = new window.google.maps.Map(mapRef.current, {
        zoom: 14,
        center: { lat: 10.464612, lng: -66.975323 },
        options: {
          streetViewControl: false,
          mapTypeControl: false,
        },
      });

      infoWindow = new window.google.maps.InfoWindow();

      // Agregar marcador de atacante
      const marcadorAtacanteMarker = new window.google.maps.Marker({
        position: marcadorAtacante,
        map: map,
        icon: "https://maps.google.com/mapfiles/ms/icons/red-dot.png",
      });

      marcadorAtacanteMarkerRef.current = marcadorAtacanteMarker;

      // Agregar marcador de víctima
      const marcadorVictimaMarker = new window.google.maps.Marker({
        position: marcadorVictima,
        map: map,
        icon: "https://maps.google.com/mapfiles/ms/icons/green-dot.png",
      });

      marcadorVictimaMarkerRef.current = marcadorVictimaMarker;
    }

    function showArrays(event) {
      const polygon = this;
      const vertices = polygon.getPath();
      let contentString =
        "<b>Polygon</b><br>" +
        "Clicked location: <br>" +
        event.latLng.lat() +
        "," +
        event.latLng.lng() +
        "<br>";

      for (let i = 0; i < vertices.getLength(); i++) {
        const xy = vertices.getAt(i);

        contentString +=
          "<br>" + "Coordinate " + i + ":<br>" + xy.lat() + "," + xy.lng();
      }

      infoWindow.setContent(contentString);
      infoWindow.setPosition(event.latLng);
      infoWindow.open(map);
    }

    initMap();

    setTimeout(() => {
        if (poligonos && Array.isArray(poligonos) && poligonos.length > 0) {
          const poligonosArray = poligonos.map((poligono) => {
            const coordenadas = poligono.coordinates.map((coordenada) => ({
              lat: coordenada.lat,
              lng: coordenada.lng,
            }));
      
            const polygon = new window.google.maps.Polygon({
              paths: coordenadas,
              strokeColor: "#FF0000",
              strokeOpacity: 0.8,
              strokeWeight: 3,
              fillColor: "#FF0000",
              fillOpacity: 0.35,
            });
      
            polygon.setMap(map);
            polygon.addListener("click", showArrays);
            return polygon;
          });
      
          poligonosRef.current = poligonosArray;
        }
      }, 0);

    return () => {
      // Limpiar los recursos al desmontar el componente
      infoWindow.close();
      map = null;
    };
  }, [poligonos]);

  useEffect(() => {
    if (marcadorAtacanteMarkerRef.current) {
      marcadorAtacanteMarkerRef.current.setPosition(marcadorAtacante);
    }
  }, [marcadorAtacante]);

  useEffect(() => {
    if (marcadorVictimaMarkerRef.current) {
      marcadorVictimaMarkerRef.current.setPosition(marcadorVictima);
    }
  }, [marcadorVictima]);

  return <div ref={mapRef} className="mapa" />;
}

export default MapaParticipantes;
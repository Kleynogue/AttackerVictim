import React, { useEffect, useRef, useState } from "react";

function MapaZona({zona, eliminar, markerPosition, pointPosition, onMapClick, poligonos }) {
const mapRef = useRef(null);
const [map, setMap] = useState(null);
const [marker, setMarker] = useState(null);
const [point, setPoint] = useState(null);
const poligonosRef = useRef([]);


function initMap() {
    const mapInstance = new window.google.maps.Map(mapRef.current, {
        zoom: 16,
        options: {
            streetViewControl: false,
            mapTypeControl: false,
        },
    });

    // Agregar evento de clic al mapa
    mapInstance.addListener("click", (event) => {
        onMapClick(event);
    });

    setMap(mapInstance);
}

useEffect(() => {
    initMap();
}, []);

useEffect(() => {
    setTimeout(() => {
      // Crear y agregar polígonos
      const poligonosArray = poligonos.map((poligono) => {
        const coordenadas = poligono.coordinates.map((coordenada) => ({
          lat: coordenada.lat,
          lng: coordenada.lng,
        }));
  
        const polygon = new window.google.maps.Polygon({
          paths: coordenadas,
          strokeColor: "#FF0000",
          strokeOpacity: 0.6,
          strokeWeight: 3,
          fillColor: "#FF0000",
          fillOpacity: 0.35,
        });
  
        polygon.setMap(map);
        return polygon;
      });
  
      poligonosRef.current = poligonosArray;
  
      // Centrar el mapa en el polígono o en Caracas
      if (map) {
        if (poligonosArray.length > 0) {
          let bounds = new window.google.maps.LatLngBounds();
          let hasCoordinates = false;
  
          poligonosArray.forEach((poligono) => {
            const path = poligono.getPath();
            if (path && path.getLength() > 0) {
              hasCoordinates = true;
              path.forEach((coordenada) => {
                bounds.extend(coordenada);
              });
            }
          });
  
          if (hasCoordinates) {
            map.fitBounds(bounds);
          } else {
            const caracasLatLng = new window.google.maps.LatLng(
              10.488011,
              -66.879190
            );
            map.panTo(caracasLatLng);
            map.setZoom(12);
          }
        } else {
          const caracasLatLng = new window.google.maps.LatLng(
            10.488011,
            -66.879190
          );
          map.panTo(caracasLatLng);
          map.setZoom(12);
        }
      }
    }, 0);
  }, [poligonos, map]);

useEffect(() => {
    if (map && markerPosition) {
        if (marker) {
            // Actualizar la posición del marcador
            marker.setPosition(markerPosition);
        } else {
            // Crear un nuevo marcador en la ubicación inicial
            const markerInstance = new window.google.maps.Marker({
                position: markerPosition,
                map: map,
                icon: "https://maps.google.com/mapfiles/ms/icons/red-dot.png",
            });


            setMarker(markerInstance);
        }
    }
}, [markerPosition, map, marker]);

useEffect(() => {
    
    if (map && pointPosition) {
        if (point) {
            // Actualizar la posición del marcador
            point.setPosition(pointPosition);
            // Eliminar el manejador de eventos existente
            window.google.maps.event.clearListeners(point, "click");
            // Agregar un nuevo manejador de eventos al marcador actualizado
            point.addListener("click", (event) => {eliminar(pointPosition, zona);});
            //console.log("aaaaaaaaaaaaaaaaaa" + pointPosition.id);

        } else {
            // Crear un nuevo marcador en la ubicación inicial
            const pointInstance = new window.google.maps.Marker({
                position: pointPosition,
                map: map,
                icon: "https://maps.google.com/mapfiles/ms/icons/green-dot.png",
            });

            // Agregar evento de clic al marcador
            pointInstance.addListener("click", () => {eliminar(pointPosition, zona);});
            //console.log("aaaaaaaaaaaaaaaaaa" + pointPosition.id);
            setPoint(pointInstance);
        }
    }
}, [pointPosition, map]);

return <div ref={mapRef} className="mapa"></div>;
}

export default MapaZona;
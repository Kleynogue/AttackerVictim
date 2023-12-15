import { GoogleMap, Marker } from "@react-google-maps/api";
import { useMemo } from "react";
import '../assets/css/components/Mapa.css';

const Mapa = ({ markerPosition, onMapClick }) => {
  const center = useMemo(() => ({ lat: 10.464538, lng: -66.976386 }), []);

    if (!window.google || !window.google.maps) {
        
        return <h1>Loading...</h1>;
    }

  return (
    <div className="container-mapa">
      <GoogleMap
        mapContainerClassName="mapa"
        center={center}
        zoom={15}
        onClick={onMapClick}
        options={{
          streetViewControl: false,
          mapTypeControl: false,
        }}
      >
        {markerPosition && (
          <Marker position={markerPosition} />
        )}
      </GoogleMap>
    </div>
  );
};

export default Mapa;
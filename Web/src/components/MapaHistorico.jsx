import { GoogleMap, Marker } from "@react-google-maps/api";
import { useMemo } from "react";
import '../assets/css/components/Mapa.css';

const Mapa = ({ marker }) => {
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
        options={{
          streetViewControl: false,
          mapTypeControl: false,
        }}
      >
        {marker && (
          <Marker position={marker} icon={{
            url: 'https://maps.google.com/mapfiles/ms/icons/red-dot.png'}} />
        )}
      </GoogleMap>
    </div>
  );
};

export default Mapa;
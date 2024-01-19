package com.ucab.cmcapp.common.util;

import com.ucab.cmcapp.common.exceptions.JWTCreateException;
import com.ucab.cmcapp.common.exceptions.JWTSetKeyException;
import com.ucab.cmcapp.common.exceptions.JWTVerifyException;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.properties.Registry;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

public class JWT
{
    private static SecretKey _secretKey;
    private static String _issuer = Registry.getInstance().getProperty( Registry.JWT_ISSUER );
    private static String _algorithm = Registry.getInstance().getProperty( Registry.JWT_ALGORITHM );
    private static Logger _logger = LoggerFactory.getLogger( JWT.class );

    static
    {
        setKey();
    }

    private static void setKey()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering in JWT.setKey" );
        //endregion

        try
        {
            _secretKey = Keys.secretKeyFor( SignatureAlgorithm.forName( _algorithm ) );
        }
        catch( Exception e )
        {
            throw new JWTSetKeyException( e.getMessage() );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving JWT.setKey" );
        //endregion
    }

    public static String createToken(UsuarioDto usuario){
        String result;

        //region Instrumentation DEBUG
        _logger.debug( "Entering in JWT.createToken: subject {}", usuario.toString() );
        //endregion

        try {
            Claims claims = Jwts.claims();
            claims.setIssuer(_issuer);
            claims.setSubject(usuario.getUsername());
            claims.setNotBefore(new Date());
            claims.setIssuedAt(new Date());
            claims.setId(UUID.randomUUID().toString());

            // Información del tipo de usuario.
            claims.put("type", usuario.getTipo());

            result = Jwts.builder()
                    .setClaims(claims)
                    .signWith(_secretKey, SignatureAlgorithm.forName(_algorithm))
                    .compact();

        }catch (Exception e){
            throw new JWTCreateException(e.getMessage());
        }

        return result;
    }

    public static UsuarioDto verifyToken(String token){
        UsuarioDto result = new UsuarioDto();
        try {
            Jws<Claims> claims = Jwts.parser()
                    .requireIssuer(_issuer)
                    .setSigningKey(_secretKey)
                    .parseClaimsJws(token);

            String username = claims.getBody().getSubject();
            // Recuperando el tipo del usuario
            String type = (String) claims.getBody().get("type");

            result.setUsername(username);
            result.setTipo(type);
        }catch (Exception e){
            _logger.error("Invalid token");
            _logger.error(e.getMessage(), e);
            throw new JWTVerifyException(e.getMessage());
        }

        return result;
    }
}

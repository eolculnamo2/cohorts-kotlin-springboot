package com.cohorts.allowance.services.impl

import com.cohorts.allowance.constants.AuthConstants
import com.cohorts.allowance.services.JwtService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

@Service
class JwtServiceImpl : JwtService {
    override fun createJWT(id: String?, issuer: String?, subject: String?): String {
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMillis = System.currentTimeMillis()
        val now = Date(nowMillis)
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(AuthConstants.JWT_TOKEN)
        val signingKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName())
        val builder: JwtBuilder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey)
        val expMillis: Long = nowMillis + AuthConstants.TOKEN_TIMEOUT
        val exp = Date(expMillis)
        builder.setExpiration(exp)
        return builder.compact()
    }

    override fun decodeJWT(jwt: String?): Claims {
        // This line will throw an exception if it is not a signed JWS (as expected)
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(AuthConstants.JWT_TOKEN))
                .parseClaimsJws(jwt).getBody()
    }
}
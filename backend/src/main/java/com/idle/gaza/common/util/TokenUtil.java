package com.idle.gaza.common.util;

import com.idle.gaza.db.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 관련된 토큰 Util
 *
 * @author choe
 * @fileName TokenUtil
 * @since 2022.12.23
 */
@Log4j2
@Component
public class TokenUtil {

    public final static long TOKEN_VALIDATION_SECOND = 1000L * 60;
    public final static long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;

    final static public String ACCESS_TOKEN_NAME = "access";
    final static public String REFRESH_TOKEN_NAME = "refresh";

    @Value("${spring.jwt.secret}")
    private static String ACCESS_TOKEN_SECRET_KEY = "gazagazagazagazagazagazagazagazagazagazagazagazagaza";
    private static String REFRESH_TOKEN_SECRET_KEY = "zagazagazagazagazagazagazagazagazagazagazagazagazaga";

    public String generateAccessToken(User user) {
        return generateJwtToken(user, TOKEN_VALIDATION_SECOND, "access");
    }

    public String generateRefreshToken(User user) {
        return generateJwtToken(user, REFRESH_TOKEN_VALIDATION_SECOND, "refresh");
    }

    /**
     * 사용자 정보를 기반으로 토큰을 생성하여 반환 해주는 메서드
     *
     * @param user User : 사용자 정보
     * @return String : 토큰
     */
    public static String generateJwtToken(User user, long expireTime, String type) {
        // 사용자 시퀀스를 기준으로 JWT 토큰을 발급하여 반환해줍니다.
        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())                              // Header 구성
                .setClaims(createClaims(user))                       // Payload - Claims 구성
                .setSubject(String.valueOf(user.getId()))        // Payload - Subject 구성
                .signWith(SignatureAlgorithm.HS256, createSignature(type))  // Signature 구성
                .setExpiration(createExpiredDate(expireTime));                    // Expired Date 구성
        return builder.compact();
    }

    /**
     * 토큰을 기반으로 사용자 정보를 반환 해주는 메서드
     *
     * @param token String : 토큰
     * @return String : 사용자 정보
     */
    public static String parseTokenToUserInfo(String token) {
        return Jwts.parser()
                .setSigningKey(ACCESS_TOKEN_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 유효한 토큰인지 확인 해주는 메서드
     *
     * @param token String  : 토큰
     * @return boolean      : 유효한지 여부 반환
     */
    public static boolean isValidToken(String token, String type) {
        try {
            if(type.equals(ACCESS_TOKEN_NAME)) {
                Claims claims = getClaimsFormToken(token, ACCESS_TOKEN_NAME);
                System.out.println("여기는 와야지 제발");
                System.out.println(claims.getExpiration());
                log.info("expireTime :" + claims.getExpiration());
                log.info("userId :" + claims.get("userId"));
                log.info("userNm :" + claims.get("userNm"));
            } else if (type.equals(REFRESH_TOKEN_NAME)) {
                Claims claims = getClaimsFormToken(token, REFRESH_TOKEN_NAME);

                log.info("expireTime :" + claims.getExpiration());
                log.info("userId :" + claims.get("userId"));
                log.info("userNm :" + claims.get("userNm"));
            }

            return true;
        } catch (ExpiredJwtException exception) {
            log.error("Token Expired");
            return false;
        } catch (JwtException exception) {
            log.error("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            log.error("Token is null");
            return false;
        }
    }

    /**
     * Header 내에 토큰을 추출합니다.
     *
     * @param header 헤더
     * @return String
     */
    public static String getTokenFromHeader(String header) {
        return header.split(" ")[1];
    }

    /**
     * 토큰의 만료기간을 지정하는 함수
     *
     * @return Calendar
     */
    private static Date createExpiredDate(long expireTime) {
        return new Date(System.currentTimeMillis() + expireTime);
    }

    /**
     * JWT의 "헤더" 값을 생성해주는 메서드
     *
     * @return HashMap<String, Object>
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    /**
     * 사용자 정보를 기반으로 클래임을 생성해주는 메서드
     *
     * @param user User 사용자 정보
     * @return Map<String, Object>
     */
    private static Map<String, Object> createClaims(User user) {
        // 공개 클레임에 사용자의 이름과 이메일을 설정하여 정보를 조회할 수 있다.
        Map<String, Object> claims = new HashMap<>();

        log.info("userId :" + user.getId());
        log.info("userNm :" + user.getName());

        claims.put("userId", user.getId());
        claims.put("userNm", user.getName());
        return claims;
    }

    /**
     * JWT "서명(Signature)" 발급을 해주는 메서드
     *
     * @return Key
     */
    private static Key createSignature(String type) {
        if(type.equals(ACCESS_TOKEN_NAME)) {
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(ACCESS_TOKEN_SECRET_KEY);
            return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        } else {
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(REFRESH_TOKEN_SECRET_KEY);
            return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        }
    }


    /**
     * 토큰 정보를 기반으로 Claims 정보를 반환받는 메서드
     *
     * @param token : 토큰
     * @return Claims : Claims
     */
    private static Claims getClaimsFormToken(String token, String type) {
        try {
            if (type.equals(ACCESS_TOKEN_NAME)) {
                return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(ACCESS_TOKEN_SECRET_KEY))
                        .parseClaimsJws(token).getBody();
            } else {
                return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(REFRESH_TOKEN_SECRET_KEY))
                        .parseClaimsJws(token).getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 토큰을 기반으로 사용자 정보를 반환받는 메서드
     *
     * @param token : 토큰
     * @return String : 사용자 아이디
     */
    public static String getUserIdFromToken(String token, String type) {
        if(type.equals(ACCESS_TOKEN_NAME)) {
            Claims claims = getClaimsFormToken(token, ACCESS_TOKEN_NAME);
            return claims.get("userId").toString();
        } else {
            Claims claims = getClaimsFormToken(token, REFRESH_TOKEN_NAME);
            return claims.get("userId").toString();
        }
    }
}
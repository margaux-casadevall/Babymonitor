package helpers;

import models.User;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Helpers {
    private static final String jwtSecret = "03a1b263-c940-4160-bd3f-b86dcb300770";
    private static final String jwtHeader = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";

    //hashing of the password for security reasons
    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /*
    public static String createJwt(User user) {
        JSONObject payload = new JSONObject();

        payload.put("sub", "user");
        payload.put("aud", "user");
        payload.put("exp", System.currentTimeMillis() / 1000 + 604800);

        payload.put("username", user.getUsername());
        payload.put("role", user.getRole());

        String signature = hmacSha256(hmacSha256(jwtHeader, jwtSecret) + "." + hmacSha256(payload.toString(), jwtSecret), jwtSecret);
        String jwtToken = encode(jwtHeader.getBytes()) + "." + encode(payload.toString().getBytes()) + "." + signature;

        return jwtToken;
    }

    public static User getUser(String jwt) {
        String[] parts = jwt.split("\\.");

        JSONObject header = new JSONObject(decode(parts[0]));
        JSONObject payload = new JSONObject(decode(parts[1]));
        String signature = decode(parts[2]);

        if(payload.getLong("exp") < (System.currentTimeMillis() / 1000)){
            return null;
        }

        String headerAndPayloadHashed = hmacSha256(parts[0] + "." + parts[1], jwtSecret);

        boolean valid = signature.equals(headerAndPayloadHashed);

        if(!valid) {
            return null;
        }

        return new User(payload.getString("username"), payload.getString("role"));
    }

    private static String hmacSha256(String data, String secret) {
        try {

            byte[] hash = secret.getBytes(StandardCharsets.UTF_8);
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
            sha256Hmac.init(secretKey);

            byte[] signedBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            return encode(signedBytes);
        } catch (Exception ex) {
            return null;
        }
    }


    private static String encode(byte[] bytes) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static String decode(String encodedString) {
        return new String(Base64.getUrlDecoder().decode(encodedString));
    } */

    //return the redirect path for a given request and path
    public static String redirectUrl(HttpServletRequest request, String path) {
        if(request.getQueryString() == null) {
            return request.getContextPath() + path;
        }

        return request.getContextPath() + path + "?" + request.getQueryString();
    }
}

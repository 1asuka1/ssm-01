package com.gxa.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtManage {
    //定义Signature中的加密密码
    private final static String SECRET = "tangjiang";

    //生成token的方法
    public static String create(String name) {
        Calendar calendar = Calendar.getInstance();
        // 设置一天过期
        calendar.add(Calendar.SECOND, 60 * 60 * 24);

        // jwt header Map
        //alg属性表示签名使用的算法，默认为HMAC SHA256（写为HS256）
        //typ属性表示令牌的类型，JWT令牌统一写为JWT
        //最后，使用Base64 URL算法将上述JSON对象转换为字符串保存
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        //playload
        // build token
        // param backups {iss:Service, aud:APP}
//        iss: jwt签发者
//        sub: jwt所面向的用户
//        aud: 接收jwt的一方
//        exp: jwt的过期时间，这个过期时间必须要大于签发时间
//        nbf: 定义在什么时间之前，该jwt都是不可用的.
//        iat: jwt的签发时间 jti:jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。


        String token = JWT.create().withHeader(map) // header
                //token中自定义存放的key-value值
                .withClaim("name", name)// payload
                .withIssuedAt(new Date()) // sign time
                .withExpiresAt(calendar.getTime()) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature签名

        return token;
    }

    //token验证

    /**
     * 校验token是否正确
     *
     * @param name  用户名
     * @param token 密钥
     * @param name  用户的密码
     * @return 是否正确
     */
    public static boolean verifyToken(String token, String name, String pwd) throws Exception {
        DecodedJWT jwt = null;
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(pwd);
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
            throw new Exception("token验证失败");

        }

    }
}

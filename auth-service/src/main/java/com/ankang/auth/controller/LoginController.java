package com.ankang.auth.controller;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.ankang.auth.request.LoginRequest;
import com.ankang.auth.request.RefreshRequest;
import com.ankang.auth.respone.LoginResponse;
import com.ankang.auth.respone.ResponseCodeEnum;
import com.ankang.auth.respone.ResponseResult;
import com.ankang.auth.util.JWTUtil;
import com.ankang.clients.StaffClient;
import com.ankang.clients.UserCilent;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.userService.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class LoginController {

    final static String TOKEN = "token";
    final static String REFRESH_TOKEN = "refreshToken";
    @Value("${secretKey:TanzeXing}")
    private String secretKey;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    StaffClient staffClient;

    @Autowired
    UserCilent userCilent;

    @RequestMapping("/userLogin")
    public ResponseResult userLogin(@RequestBody LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        User requestUser = new User();
        requestUser.setUserUserName(username);
        requestUser.setUserPassWord(password);
        User databaseUser = userCilent.queryUserByLogin(requestUser);
        if(databaseUser.getUserUserName() == null || databaseUser.getUserPassWord() == null){
            databaseUser.setUserUserName("");
            databaseUser.setUserPassWord("");
        }
        if (databaseUser.getUserUserName().equals(username) && databaseUser.getUserPassWord().equals(password)) {
            //  生成Token
            String token = JWTUtil.generateToken(databaseUser.getUserId()+"", username, secretKey);

            //  生成刷新Token
            String refreshToken = UUID.randomUUID().toString().replace("-", "");

            //  放入缓存
            HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();

            String key = databaseUser.getUserId()+"";
            hashOperations.put(key, TOKEN, token);
            hashOperations.put(key, REFRESH_TOKEN, refreshToken);
            stringRedisTemplate.expire(key, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setRefreshToken(refreshToken);
            loginResponse.setUserId(databaseUser.getUserId()+"");
            loginResponse.setUsername(username);

            return ResponseResult.success(loginResponse);
        }

        return ResponseResult.error(ResponseCodeEnum.LOGIN_ERROR.getCode(), ResponseCodeEnum.LOGIN_ERROR.getMessage());
    }

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        Staff requestStaff = new Staff();
        requestStaff.setStaffUserName(username);
        requestStaff.setStaffPassWord(password);
        Staff databaseStaff = staffClient.queryStaffByLogin(requestStaff);
        if(databaseStaff.getStaffUserName() == null || databaseStaff.getStaffPassWord() == null){
            databaseStaff.setStaffUserName("");
            databaseStaff.setStaffPassWord("");
        }
        if (databaseStaff.getStaffUserName().equals(username) && databaseStaff.getStaffPassWord().equals(password)) {
            //  生成Token
            String token = JWTUtil.generateToken(databaseStaff.getStaffId()+"", username, secretKey);

            //  生成刷新Token
            String refreshToken = UUID.randomUUID().toString().replace("-", "");

            //  放入缓存
            HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();

            String key = databaseStaff.getStaffId()+"";
            hashOperations.put(key, TOKEN, token);
            hashOperations.put(key, REFRESH_TOKEN, refreshToken);
            stringRedisTemplate.expire(key, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setRefreshToken(refreshToken);
            loginResponse.setUserId(databaseStaff.getStaffId()+"");
            loginResponse.setUsername(username);

            return ResponseResult.success(loginResponse);
        }

        return ResponseResult.error(ResponseCodeEnum.LOGIN_ERROR.getCode(), ResponseCodeEnum.LOGIN_ERROR.getMessage());
    }

    @GetMapping("/logout")
    public ResponseResult logout(@RequestParam("userId") String userId) {
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String key = userId;
        hashOperations.delete(key, TOKEN);
        return ResponseResult.success();
    }

    @PostMapping("/refreshToken")
    public ResponseResult refreshToken(@RequestBody @Validated RefreshRequest request, BindingResult bindingResult) {
        String userId = request.getUserId();
        //通过userId去数据库查到userName
        String userName = "alanchen";
        String refreshToken = request.getRefreshToken();
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String key = userId;
        String originalRefreshToken = hashOperations.get(key, REFRESH_TOKEN);
        if (StringUtils.isBlank(originalRefreshToken) || !originalRefreshToken.equals(refreshToken)) {
            return ResponseResult.error(ResponseCodeEnum.REFRESH_TOKEN_INVALID.getCode(), ResponseCodeEnum.REFRESH_TOKEN_INVALID.getMessage());
        }

        //  生成新token
        String newToken = JWTUtil.generateToken(userId, userName, secretKey);
        hashOperations.put(key, TOKEN, newToken);
        stringRedisTemplate.expire(userId, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

        return ResponseResult.success(newToken);
    }
}

package com.idle.gaza.api.controller;

import com.idle.gaza.api.service.UserService;
import com.idle.gaza.common.codes.SuccessCode;
import com.idle.gaza.common.response.ApiResponse;
import com.idle.gaza.common.util.RedisUtil;
import com.idle.gaza.db.entity.JoinReq;
import com.idle.gaza.db.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<Object>> join(@RequestBody JoinReq joinReq) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        joinReq.setPassword(bCryptPasswordEncoder.encode(joinReq.getPassword()));

        User user = User.userBuilder()
                .userId(joinReq.getUserId())
                .name(joinReq.getName())
                .phone_number(joinReq.getPhone_number())
                .id(joinReq.getId())
                .pw(joinReq.getPassword())
                .gender(joinReq.getGender())
                .birthday(joinReq.getBirthday())
                .picture(joinReq.getPicture())
                .email(joinReq.getEmail())
                .email_domain(joinReq.getEmail_domain())
                .state(joinReq.getState())
                .build();

        userService.join(user);

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(user)
                .resultCode(SuccessCode.INSERT.getStatus())
                .resultMsg(SuccessCode.INSERT.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }

    /**
     * [API] 사용자 리스트 조회
     *
     * @param user User
     * @return ResponseEntity
     */
    @PostMapping("/user")
    public ResponseEntity<ApiResponse<Object>> selectCodeList(@RequestBody User user) {
        List<User> selectUserList = userService.selectUserList(user);
        ApiResponse<Object> ar = ApiResponse.builder()
                .result(selectUserList)
                .resultCode(SuccessCode.SELECT.getStatus())
                .resultMsg(SuccessCode.SELECT.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }

    /**
     * [API] 사용자 리스트 조회
     *
     * @param user User
     * @return ResponseEntity
     */
    @GetMapping("/needJWT")
    public ResponseEntity<ApiResponse<Object>> JWTtest(@RequestBody String ref) {
        RedisUtil redisUtil = new RedisUtil();

        System.out.println(redisUtil.getData(ref));
        ApiResponse<Object> ar = ApiResponse.builder()
                .result(null)
                .resultCode(SuccessCode.INSERT.getStatus())
                .resultMsg(SuccessCode.INSERT.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}
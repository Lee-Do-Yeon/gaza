package com.idle.gaza.api.controller;

import com.idle.gaza.api.dto.TokenDto;
import com.idle.gaza.api.service.UserService;
import com.idle.gaza.common.codes.SuccessCode;
import com.idle.gaza.common.response.ApiResponse;
import com.idle.gaza.common.util.RedisUtil;
import com.idle.gaza.common.util.TokenUtil;
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
    public ResponseEntity<ApiResponse<Object>> join(@RequestBody User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

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
    @PostMapping("/pw")
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
    @GetMapping("/users/{userId}")
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
    @PutMapping("/users/{userId}")
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
    @DeleteMapping("/users/{userId}")
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
    @PutMapping("/users/pw/{userId}")
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
    @PostMapping("/users/isLogin")
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
    @PostMapping("/users/guide")
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
     * [API] 로그아웃
     *
     * @param tokenDto TokenDto
     * @return ResponseEntity
     */
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Object>> logout(@RequestBody TokenDto tokenDto) {
        TokenUtil.logout(tokenDto);

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(null)
                .resultCode(200)
                .resultMsg("로그아웃 되었습니다.")
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}
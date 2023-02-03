package com.idle.gaza.api.controller;

import com.idle.gaza.api.dto.TokenDto;
import com.idle.gaza.api.request.UserUpdateRequest;
import com.idle.gaza.api.service.UserService;
import com.idle.gaza.common.codes.SuccessCode;
import com.idle.gaza.common.response.ApiResponse;
import com.idle.gaza.common.util.RedisUtil;
import com.idle.gaza.common.util.TokenUtil;
import com.idle.gaza.db.entity.JoinReq;
import com.idle.gaza.db.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "유저 API", tags = {"User"})
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
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
     * [API] 비밀 번호 찾기
     *
     * @param user User
     * @return ResponseEntity
     *
     * 이메일 통한 방법이라고 했는데 보류
     */
    @PostMapping("/pw")
    public ResponseEntity<ApiResponse<Object>> findPassword(@RequestBody User user) {
        List<User> selectUserList = userService.selectUserList(user);

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(selectUserList)
                .resultCode(SuccessCode.SELECT.getStatus())
                .resultMsg(SuccessCode.SELECT.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }

    /**
     * [API] 사용자 조회
     *
     * @param userId Integer
     * @return ResponseEntity
     *
     */
    @GetMapping("/users/{userId}")
    @ApiOperation(value = "사용자 조회", notes = "사용자를 조회한다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "성공"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "서버 오류"),
            @io.swagger.annotations.ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<ApiResponse<Object>> getUser(@PathVariable @ApiParam(value="유저 PK", required = true) Integer userId) {
        System.out.println("여기들어옴??");

        User user = userService.searchUser(userId);

        if(user == null) {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(HttpStatus.NO_CONTENT.value())
                    .resultMsg("회원이 없습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.NO_CONTENT);
        } else {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(user)
                    .resultCode(SuccessCode.SELECT.getStatus())
                    .resultMsg("회원이 조회되었습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.OK);
        }
    }

    /**
     * [API] 사용자 정보 수정
     *
     * @param userUpdateRequest UserUpdateRequest
     * @return ResponseEntity
     *
     */
    @ApiOperation(value = "사용자 정보 수정", notes = "사용자 정보를 수정한다.")
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "성공"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "서버 오류"),
            @io.swagger.annotations.ApiResponse(code = 204, message = "사용자 없음")
    })
    @PutMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<Object>> updateUser(@PathVariable int userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        int result = userService.updateUser(userId, userUpdateRequest);

        if(result == 0) {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(HttpStatus.NO_CONTENT.value())
                    .resultMsg("회원이 없습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.NO_CONTENT);
        } else {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(SuccessCode.UPDATE.getStatus())
                    .resultMsg("회원이 수정되었습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.OK);
        }
    }

    /**
     * [API] 회원 탈퇴
     *
     * @param userId Integer
     * @return ResponseEntity
     *
     */
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<Object>> deleteUser(@PathVariable Integer userId) {
        int result = userService.deleteUser(userId);

        if(result == 0) {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(HttpStatus.NO_CONTENT.value())
                    .resultMsg("회원이 없습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.NO_CONTENT);
        } else {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(SuccessCode.DELETE.getStatus())
                    .resultMsg("회원이 탈퇴되었습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.OK);
        }
    }

    /**
     * [API] 비밀번호 수정
     *
     * @param password String
     * @return ResponseEntity
     *
     */
    @PutMapping("/users/pw/{userId}")
    public ResponseEntity<ApiResponse<Object>> changePassword(@PathVariable int userId, @RequestParam String password) {
        int result = userService.updatePassword(userId, password);

        if(result == 0) {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(HttpStatus.NO_CONTENT.value())
                    .resultMsg("회원이 없습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.NO_CONTENT);
        } else {
            ApiResponse<Object> ar = ApiResponse.builder()
                    .result(null)
                    .resultCode(SuccessCode.UPDATE.getStatus())
                    .resultMsg("비밀번호가 변경되었습니다.")
                    .build();
            return new ResponseEntity<>(ar, HttpStatus.OK);
        }
    }

    /**
     * [API] 사용자 리스트 조회
     *
     * @param user User
     * @return ResponseEntity
     *
     * 토큰 어떻게 할지 고민 중
     */
    @PostMapping("/users/isLogin")
    public ResponseEntity<ApiResponse<Object>> checkLogin(@RequestBody User user) {
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
     * 
     * 로그인 확인 방법 고민 중
     */
    @PostMapping("/users/guide")
    public ResponseEntity<ApiResponse<Object>> joinGuide(@RequestBody User user) {
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
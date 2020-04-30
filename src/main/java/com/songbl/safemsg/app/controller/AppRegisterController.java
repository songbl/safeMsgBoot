
package com.songbl.safemsg.app.controller;


import com.songbl.bless.app.form.RegisterForm;
import com.songbl.bless.common.utils.R;
import com.songbl.bless.app.entity.UserEntity;
import com.songbl.bless.app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册
 *
 * 791243928@qq.com
 */
@RestController
@RequestMapping("/app")
public class AppRegisterController {
    @Autowired(required = false)
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
//        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getUsername());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        user.setGender(form.getGender());
        boolean b = userService.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("result",true);
        System.out.println("注册结果"+b);

        /**
         * {
         *     "msg": "success",
         *     "result": true,
         *     "code": 0
         * }
         */
        return R.ok(map);
    }
}

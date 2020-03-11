package kim.adrian.system.controller;

import com.adrian.common.entity.QueryRequest;
import com.adrian.common.entity.po.system.SystemUser;
import com.adrian.common.entity.vo.Result;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import kim.adrian.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserController
 * @Description
 * @Date 2020-01-08 17:15
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public Result userList(QueryRequest queryRequest, SystemUser user) {
        return Result.success(userService.findUserDetail(user, queryRequest));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result addUser(@Valid SystemUser user) {
        this.userService.createUser(user);
        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public Result updateUser(@Valid SystemUser user) {
        this.userService.updateUser(user);
        return Result.success();
    }

    @DeleteMapping("{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public Result deleteUser(@NotBlank(message = "{required}") @PathVariable("userIds") String userIds) {
        String[] ids = userIds.split(StringPool.COMMA);
        this.userService.deleteUsers(ids);
        return Result.success();
    }
}

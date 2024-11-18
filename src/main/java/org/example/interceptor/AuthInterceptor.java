package org.example.interceptor;


import org.example.entity.UsersEntity;
import org.example.exception.AuthException;
import org.example.mapper.UsersMapper;
import org.example.utils.JwtService;
import org.example.utils.UserUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    JwtService jwtService;
    @Resource
    UsersMapper usersMapper;
    private static void AuthFailer() throws AuthException {
        throw new AuthException(401, "认证xx失败");
    }

    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response
            , Object handler) throws Exception {
        //拿到请求的url地址
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        //检查是否已经登录
        String token = request.getHeader("authorization");
        if (token != null) {
            token = token.replace("Bearer ", "");

            String userid = jwtService.getSub(token);
            if (userid == null || !jwtService.validateToken(token)) {
                AuthFailer();
                return false;
            } else {
                try {
                    UsersEntity usersEntity = usersMapper.getUserById(Long.valueOf(userid));
                    if (usersEntity != null) {
                        //在全局的位置保存当前用户id
                        System.out.println("filter thread id:" + Thread.currentThread().getId());
                        UserUtils.setLoginUser(usersEntity);
                        return true;

                    } else {
                        AuthFailer();
                        return false;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    AuthFailer();
                    return false;
                } finally {
                    System.out.println("exit servlet");
//                    UserUtils.removeUser();
                }
            }
        } else {
            AuthFailer();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserUtils.removeUser();
        System.out.println("UserUtils.removeUser()");
    }
}

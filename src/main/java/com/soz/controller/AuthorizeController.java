package com.soz.controller;

import com.soz.pojo.AccessTokenDao;
import com.soz.pojo.GithubUser;
import com.soz.pojo.User;
import com.soz.provider.GithubProvider;
import com.soz.service.GithubService;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthorizeController {

    @Autowired
    private UserService userService;

    @Autowired
    private GithubService githubService;

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDao accessTokenDao = new AccessTokenDao();
        accessTokenDao.setCode(code);
        accessTokenDao.setRedirect_url(redirectUrl);
        accessTokenDao.setState(state);
        accessTokenDao.setClient_id(clientId);
        accessTokenDao.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDao);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user!=null){
            //登录成功,写cookie和session
            String name = user.getName();
            String picture = user.getAvatar_url();
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
            session.setAttribute("picture",picture);
            return "redirect:/";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("msg","授权登录失败");
            return "redirect:/login/login";
        }

    }

}

package com.tms.visa.base.session;

/**
 * Created by Administrator on 2016/8/8.
 */

import com.tms.visa.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUserSessionContext extends AbstractUserSessionContext {
    public SecurityUserSessionContext() {
    }

    public User getUser() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
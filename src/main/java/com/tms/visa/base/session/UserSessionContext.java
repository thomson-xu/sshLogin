package com.tms.visa.base.session;

import com.tms.visa.model.User;

/**
 * Created by Administrator on 2016/8/8.
 */


public interface UserSessionContext {
    User getUser();

    String getUserId();

    String getUsername();
}

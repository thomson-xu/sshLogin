package com.tms.visa.base.session;

import com.tms.visa.model.User;

/**
 * Created by Administrator on 2016/8/8.
 */


public abstract class AbstractUserSessionContext implements UserSessionContext {
    public AbstractUserSessionContext() {
    }

    public String getUserId() {
        return this.getUser().getSsoId();
    }

    public String getUsername() {
        return this.getUser().getFirstName();
    }

    public abstract User getUser();
}

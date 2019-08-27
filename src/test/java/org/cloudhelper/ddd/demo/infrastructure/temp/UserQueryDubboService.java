package org.cloudhelper.ddd.demo.infrastructure.temp;

import org.cloudhelper.ddd.demo.domain.model.user.User;

public interface UserQueryDubboService {
    public User queryById(Long userId);
}

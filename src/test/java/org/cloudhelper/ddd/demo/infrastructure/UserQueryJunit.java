package org.cloudhelper.ddd.demo.infrastructure;

import org.cloudhelper.ddd.demo.application.domain.model.user.User;
import org.cloudhelper.ddd.demo.infrastructure.temp.UserQueryDubboService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserQueryJunit {
    @Mock
    @Autowired
    UserQueryDubboService userQueryDubboService;
    @Before
    public void setUp() {
        // mock注解声明及初始化
        MockitoAnnotations.initMocks(this);
        // 针对 @Mock 类中的方法进行定制：当调用该接口时返回固定值
        when(userQueryDubboService.queryById(any(Long.class))).thenReturn(new User(1L));
    }

    @Test
    public void queryUser() {
        User user = userQueryDubboService.queryById(1L);
        System.out.println("userId="+user.getId());
    }
}

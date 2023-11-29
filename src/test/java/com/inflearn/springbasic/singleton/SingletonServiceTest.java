package com.inflearn.springbasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonServiceTest {

    @Test
    void singletonTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }
}

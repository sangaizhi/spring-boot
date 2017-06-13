package org.sangaizhi.servlet_container;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/6/13
 */
//@Component
public class CustomerServletContainer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setContextPath("/cusServlet1");
        container.setPort(8888);
    }
}

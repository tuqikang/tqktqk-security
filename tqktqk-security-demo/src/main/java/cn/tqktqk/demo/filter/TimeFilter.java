package cn.tqktqk.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-12 22:15
 */
//@Component
public class TimeFilter implements Filter {
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    /**
     * 处理逻辑
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = System.currentTimeMillis();
        /**
         * filterChain过滤器链，doFilter请求下一个过滤器
         */
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时:"+(System.currentTimeMillis()-start )+"ms");
        System.out.println("time filter end");
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}

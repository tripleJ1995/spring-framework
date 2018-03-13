/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.env;

/**
 * Interface indicating a component that contains and exposes an {@link Environment} reference.
 *
 * <p>All Spring application contexts are EnvironmentCapable, and the interface is used primarily
 * for performing {@code instanceof} checks in framework methods that accept BeanFactory
 * instances that may or may not actually be ApplicationContext instances in order to interact
 * with the environment if indeed it is available.
 *
 * <p>As mentioned, {@link org.springframework.context.ApplicationContext ApplicationContext}
 * extends EnvironmentCapable, and thus exposes a {@link #getEnvironment()} method; however,
 * {@link org.springframework.context.ConfigurableApplicationContext ConfigurableApplicationContext}
 * redefines {@link org.springframework.context.ConfigurableApplicationContext#getEnvironment
 * getEnvironment()} and narrows the signature to return a {@link ConfigurableEnvironment}.
 * The effect is that an Environment object is 'read-only' until it is being accessed from
 * a ConfigurableApplicationContext, at which point it too may be configured.
 *
 * 谷歌翻译
 * 公共接口EnvironmentCapable
 * 接口指示包含并公开环境参考的组件。
 * 所有Spring应用程序上下文都是EnvironmentCapable，接口主要用于在接受BeanFactory实例的框架方法中执行instanceof检查，
 * 如果BeanFactory实际上可用，它们可能实际上可能是ApplicationContext实例，以便与环境进行交互。
 * 如前所述，ApplicationContext扩展了EnvironmentCapable，从而暴露了一个getEnvironment（）方法;
 * 但是，ConfigurableApplicationContext重新定义getEnvironment（）并缩小签名以返回ConfigurableEnvironment。
 * 其效果是Environment对象在从ConfigurableApplicationContext访问之前是“只读”的，此时它也可以被配置。
 * @author Chris Beams
 * @since 3.1
 * @see Environment
 * @see ConfigurableEnvironment
 * @see org.springframework.context.ConfigurableApplicationContext#getEnvironment()
 */
public interface EnvironmentCapable {

	/**
	 * Return 返回此组件关联的环境。
	 */
	Environment getEnvironment();

}

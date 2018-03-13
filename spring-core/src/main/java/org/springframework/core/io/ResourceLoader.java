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

package org.springframework.core.io;

import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

/**
 * 加载资源的策略接口 (例如类路径或文件系统资源).
 *  需要ApplicationContext来提供此功能以及扩展的ResourcePatternResolver支持。
 *
 * DefaultResourceLoader是一个独立的实现，可以在ApplicationContext之外使用，也可以被ResourceEditor使用。
 *
 * 在ApplicationContext中运行时，使用特定上下文的资源加载策略，可以从Strings 中填充Resource数组和Resource类型的Bean属性。
 *
 * @author Juergen Hoeller
 * @since 10.03.2004
 * @see Resource
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 */
public interface ResourceLoader {

	/** 用于从类路径加载的伪URL前缀：“classpath：” */
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


	/**
	 * 返回指定资源位置的资源句柄。该句柄应该始终是一个可重用的资源描述符，允许多个InputStreamSource.getInputStream（）调用。
	 * 必须支持完全限定的网址，例如“file:C:/test.dat”。
	 * 必须支持类路径伪网址，例如“classpath:test.dat”。
	 * 应该支持相对文件路径，例如“WEB-INF/test.dat”。
	 * （这将是特定于实现的，通常由ApplicationContext接口的实现提供。）
	 * 请注意，资源句柄并不意味着已经存在资源; 你需要调用Resource.exists（）来检查是否存在。
	 * @param location the resource location
	 * @return a corresponding Resource handle (never {@code null})
	 * @see #CLASSPATH_URL_PREFIX
	 * @see Resource#exists()
	 * @see Resource#getInputStream()
	 */
	Resource getResource(String location);

	/**
	 * 获取此ResourceLoader使用的ClassLoader
	 * 需要直接访问ClassLoader的客户端可以使用ResourceLoader以统一的方式执行此操作，而不是依赖线程上下文ClassLoader。
	 * @see org.springframework.util.ClassUtils#getDefaultClassLoader()
	 */
	@Nullable
	ClassLoader getClassLoader();

}

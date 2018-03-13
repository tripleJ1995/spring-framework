/*
 * Copyright 2002-2007 the original author or authors.
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

package org.springframework.core.io.support;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 用于将位置模式（例如，Ant式路径(详情百度)）解析为Resource对象的策略接口。
 *
 * 这是对ResourceLoader接口的扩展。
 * 可以检查传入的ResourceLoader（例如，在上下文中运行时通过ResourceLoaderAware传入的ApplicationContext）是否也实现了此扩展接口。
 * athMatchingResourcePatternResolver是独立的实现，可在ApplicationContext外部使用，ResourceArrayPropertyEditor也可用于填充Resource 数组bean属性。
 * 可以与任何类型的位置模式一起使用（例如“/WEB-INF/*-context.xml”）：输入模式必须与策略实现相匹配。
 * 这个接口只是指定了转换方法，而不是特定的模式格式。该接口还为来自类路径的所有匹配资源建议新的资源前缀“classpath *："。
 * 请注意，在这种情况下，资源位置应该是没有占位符的路径（例如“/beans.xml”）,JAR文件或类目录可以包含多个具有相同名称的文件。
 *
 * @author Juergen Hoeller
 * @since 1.0.2
 * @see org.springframework.core.io.Resource
 * @see org.springframework.core.io.ResourceLoader
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 */
public interface ResourcePatternResolver extends ResourceLoader {

	/**
	 * 来自类路径的所有匹配资源的伪URL前缀：“classpath *：”
	 * 这与ResourceLoader的类路径URL前缀不同，因为它检索给定名称的所有匹配资源(e.g. "/beans.xml"),
	 * 例如在所有已部署的JAR文件的根目录中。
	 * classpath*: 前缀提供了装载多个 XML 配置文件的能力，当使用 classpath*: 前缀来指定 XML 配置文件时，
	 * 系统将搜索类加载路径，找出所有与文件名的文件，分别装载文件中的配置定义，最后合并成一个 ApplicationContext
	 * @see org.springframework.core.io.ResourceLoader#CLASSPATH_URL_PREFIX
	 */
	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

	/**
	 * 将给定的位置模式解析为资源对象。
	 * 尽可能避免重叠指向相同物理资源的资源条目。
	 * 结果应该有设置语义。
	 * @param locationPattern the location pattern to resolve
	 * @return the corresponding Resource objects
	 * @throws IOException in case of I/O errors
	 */
	Resource[] getResources(String locationPattern) throws IOException;

}

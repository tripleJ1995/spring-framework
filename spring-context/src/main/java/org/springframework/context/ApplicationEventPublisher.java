/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.context;

/**
 * 封装事件发布功能的接口。
 * 作为ApplicationContext的超级接口。
 *
 * @author Juergen Hoeller
 * @author Stephane Nicoll
 * @since 1.1.1
 * @see ApplicationContext
 * @see ApplicationEventPublisherAware
 * @see org.springframework.context.ApplicationEvent
 * @see org.springframework.context.event.EventPublicationInterceptor
 */
@FunctionalInterface
public interface ApplicationEventPublisher {

	/**
	 * 发布一个应用事件通知所有注册在此应用的匹配的监听器
	 * 事件可能是一个框架事件(such as RequestHandledEvent)或者是application-specific(特定于应用的)events.
	 * @param event the event to publish
	 * @see org.springframework.web.context.support.RequestHandledEvent
	 */
	default void publishEvent(ApplicationEvent event) {
		publishEvent((Object) event);
	}

	/**
	 * 发布一个事件通知所有注册在此应用的匹配的监听器
	 * 如果指定的事件不是ApplicationEvent，则将其包装在PayloadApplicationEvent中。
	 * @param event the event to publish
	 * @since 4.2
	 * @see PayloadApplicationEvent
	 */
	void publishEvent(Object event);

}

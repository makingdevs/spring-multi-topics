package com.makingdevs.aspects

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * Created by neodevelop on 26/11/16.
 *
 */
@Configuration
@ComponentScan("com.makingdevs.aspects")
@EnableAspectJAutoProxy
class AspectsConfig {
}

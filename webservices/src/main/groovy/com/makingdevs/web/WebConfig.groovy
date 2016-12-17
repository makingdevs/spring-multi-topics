package com.makingdevs.web

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by neodevelop on 17/12/16.
 */
@ComponentScan("com.makingdevs.web")
@EnableWebMvc
@Import(RepositoryRestMvcConfiguration)
class WebConfig {
}

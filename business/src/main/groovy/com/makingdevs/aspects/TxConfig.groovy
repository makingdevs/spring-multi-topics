package com.makingdevs.aspects

import com.makingdevs.config.AppConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.ImportResource

/**
 * Created by makingdevs on 12/2/16.
 */
@Configuration
@Import([AppConfig])
@ImportResource("classpath:TxAppCtx.xml")
class TxConfig {
}

package com.ki960213.plusdotcom.common.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Aspect
@Component
class LongResponseTimeDetector {

    private val log = LoggerFactory.getLogger(LongResponseTimeDetector::class.java)

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    fun loggingTest(joinPoint: ProceedingJoinPoint): Any? {
        val stopWatch = StopWatch()

        stopWatch.start()
        val result = joinPoint.proceed()
        stopWatch.stop()

        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val method = attributes.request.method
        val uri = attributes.request.requestURI

        log.info(
            "${
            LocalDateTime.now().format(LOGGING_TIME_FORMAT)
            }에 호출된 $method ${uri}의 응답 시간은 ${stopWatch.totalTimeMillis}ms 입니다."
        )
        if (stopWatch.totalTimeMillis >= RESPONSE_TIME_THRESHOLD) log.warn("너무 오래 걸렸습니다!")

        return result
    }

    companion object {

        private val LOGGING_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")

        private const val RESPONSE_TIME_THRESHOLD = 1000
    }
}

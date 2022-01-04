package cn.com.xuxiaowei.p6spy;

import cn.com.xuxiaowei.aspect.P6spyAspect;
import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.SingleLineFormat;
import com.p6spy.engine.spy.appender.Slf4JLogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 自定义 Slf4j
 *
 * @author xuxiaowei
 * @see SingleLineFormat
 * @since 0.0.1
 */
@Slf4j
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class CustomSlf4JLogger extends Slf4JLogger {

    @NonNull
    @Override
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void logSQL(int connectionId, String now, long elapsed,
                       Category category, String prepared, String sql, String url) {

        long nowLong = Long.parseLong(now);
        long epochSecond = nowLong / 1000;
        LocalDateTime nowLocalDateTime = LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.of("+8"));
        String nowFormat = nowLocalDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        final String msg = strategy.formatMessage(connectionId, nowFormat, elapsed,
//                category.toString(), "", sql, "");

        String msg = MDC.get(P6spyAspect.P6SPY_UUID) + "：" + nowFormat + "|" + elapsed + "|" + sql;

        if (Category.ERROR.equals(category)) {
            log.error(msg);
        } else if (Category.WARN.equals(category)) {
            log.warn(msg);
        } else if (Category.DEBUG.equals(category)) {
            log.debug(msg);
        } else {
            log.info(msg);
        }
    }

}

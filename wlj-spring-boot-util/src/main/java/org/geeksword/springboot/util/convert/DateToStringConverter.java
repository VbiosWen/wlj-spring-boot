package org.geeksword.springboot.util.convert;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @wenliujie
 */
public class DateToStringConverter implements Converter<LocalDateTime,String> {

    private static final String DEFAULT_FORMATTER_PATTERN =  "yyyy-MM-dd HH:mm:ss";

    private DateTimeFormatter dateTimeFormatter;

    private static final String DATE_PATTERN = DEFAULT_FORMATTER_PATTERN;

    @PostConstruct
    public void init(){
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
    }

    @Override
    public String convert(LocalDateTime value) {
        return value.format(dateTimeFormatter);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return SimpleType.constructUnsafe(LocalDateTime.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
      return SimpleType.constructUnsafe(String.class);
    }
}

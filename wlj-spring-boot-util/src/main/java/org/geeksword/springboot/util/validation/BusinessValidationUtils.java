package org.geeksword.springboot.util.validation;

import lombok.NonNull;
import org.apache.commons.lang.StringUtils;
import org.geeksword.springboot.util.exceptions.BusinessException;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @wenliujie
 */
public class BusinessValidationUtils {

    public static void isBlank(String str, String msg) {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(msg);
        }
    }

    public static void isNull(Object object, String msg) {
        if (Objects.isNull(object)) {
            throw new BusinessException(msg);
        }
    }

    public static void isTrue(boolean tag, String msg) {
        if (tag) {
            throw new BusinessException(msg);
        }
    }

    public static void rejectIfNull(@NonNull String fieldName, @NonNull Object object, String msg) {
        Object obj = getField(fieldName, object);
        if (Objects.isNull(obj)) {
            throw new BusinessException(msg);
        }
    }

    private static Object getField(String fieldName, Object object) {
        Field field = ReflectionUtils.findField(object.getClass(), fieldName);
        Assert.notNull(field, "not find field from field name.");
        return ReflectionUtils.getField(field, object);
    }

    public static void rejectIfEmpty(@NonNull String fieldName, @NonNull Object object, String msg) {
        Object obj = getField(fieldName, object);
        Assert.notNull(obj, String.format("get value from %s is null", fieldName));
        if (!(obj instanceof String)) {
            throw new BusinessException(String.format("the %s type must be string.", fieldName));
        }
        isBlank((String) obj, msg);
    }
}

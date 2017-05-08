package com.db;

/**
 * @author Fang Yong (fangyong02@baidu.com)
 */
public class CodeEnumUtils {
    public static <E extends Enum & CodeEnum> E parse(Class<E> enumClass, int code) {
        E codeDefault = null;
        for (E codeEnum : enumClass.getEnumConstants()) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
            if (codeEnum.getCode() == 0) {
                codeDefault = codeEnum;
            }
        }
        return codeDefault;
    }
}

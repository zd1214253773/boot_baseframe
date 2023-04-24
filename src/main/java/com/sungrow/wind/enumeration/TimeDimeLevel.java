package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/26 15:09
 */
public enum TimeDimeLevel {
    /**
     * 年
     */
    TIME_DIME_YEAR {
        @Override
        public String getFormat() {
            return "'%Y'";
        }
    },
    /**
     * 季
     */
    TIME_DIME_SEASON {
        @Override
        public String getFormat() {
            return "'%Y-%m'";
        }
    },

    /**
     * 月
     */
    TIME_DIME_MONTH {
        @Override
        public String getFormat() {
            return "'%Y-%m'";
        }
    },

    /**
     * 日
     */
    TIME_DIME_DAY {
        @Override
        public String getFormat() {
            return "'%Y-%m-%d'";
        }
    };

    public abstract String getFormat();


}

package com.sn.tulingr.util;
/*
判断特定情况的工具类
 */
public class IsNullOrEmpty {
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str)||"null".equals(str)){
			return true;
		}else{
			return false;
		}
	}

    public static boolean isEmptyZero(String str) {
        if(str==null||"".equals(str)||"null".equals(str)||"0".equals(str)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmptyNoLimited(String str) {
        if(str==null||"".equals(str)||"null".equals(str)||"不限".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}

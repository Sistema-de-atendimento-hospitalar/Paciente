package com.paciente.utils;

import org.apache.commons.lang3.StringUtils;

public class Utils {
	
	public static String completeCPF(String text) {
		return completeZeroLeft(text, 11);
	}

	public static String completeZeroLeft(String text, int length) {
		return StringUtils.leftPad(text, length, "0");
	}

}

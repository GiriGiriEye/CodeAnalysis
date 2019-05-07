package com.nju.edu.CodeAnalysis.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONUtil {
	public static String JavaToJson(Object object) {
		String result = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
			return result;
		}catch(JsonProcessingException jpe) {
			jpe.printStackTrace();
		}
		return result;
	}
}

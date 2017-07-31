package com.liferay.jenkins.boot.spring;

import org.json.JSONArray;
import org.json.JSONObject;

data class Slave(val slaveName: String) {
	fun toJSONObject() : JSONObject {
		var jsonObject = JSONObject();

		jsonObject.put("slaveName", slaveName);

		return jsonObject;
	}

	fun toJSONString() : String {
		var jsonObject = toJSONObject();

		return jsonObject.toString();
	}

}
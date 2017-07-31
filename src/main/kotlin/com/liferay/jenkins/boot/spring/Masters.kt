package com.liferay.jenkins.boot.spring;

import java.net.URL;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Masters() {
	var masters = ArrayList<Master>();

	init {
		val masterNames = arrayOf("test-1-0", "test-1-1", "test-1-2");

		for (masterName in masterNames) {
			val jsonURL = "http://${masterName}/computer/api/json?tree=computer[displayName]";

			println("Connecting to '${jsonURL}'")

			var jsonText = URL(jsonURL).readText()

			val jsonObject = JSONObject(jsonText);

			val computerJSONArray = jsonObject.getJSONArray("computer")

			var slaveNames = ArrayList<String>();

			var i : Int = 0;

			while (i < computerJSONArray.length()) {
				val computerJSONObject = computerJSONArray.getJSONObject(i);

				slaveNames.add(computerJSONObject.getString("displayName"));

				i++;
			}

			masters.add(Master(masterName, slaveNames));
		}
	}

	fun toJSONObject() : JSONObject {
		var jsonObject = JSONObject();

		var jsonArray = JSONArray();

		for (master in masters) {
			jsonArray.put(master.toJSONObject());
		}

		jsonObject.put("masters", jsonArray);

		return jsonObject;
	}

	fun toJSONString() : String {
		var jsonObject = toJSONObject();

		return jsonObject.toString();
	}
}
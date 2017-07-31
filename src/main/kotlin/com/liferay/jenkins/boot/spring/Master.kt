package com.liferay.jenkins.boot.spring;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

data class Master(val masterName: String, val slaveNames: List<String>) {
	var slaves = ArrayList<Slave>();

	init {
		for (slaveName in slaveNames) {
			if (slaveName.equals("master")) {
				continue;
			}

			slaves.add(Slave(slaveName));
		}
	}

	fun toJSONObject() : JSONObject {
		var jsonArray = JSONArray();

		for (slave in slaves) {
			var slaveName = slave.slaveName;

			if (slaveName.equals("master")) {
				continue;
			}

			jsonArray.put(slave.toJSONObject());
		}

		var jsonObject = JSONObject();

		jsonObject.put("masterName", masterName);
		jsonObject.put("slaves", jsonArray);

		return jsonObject;
	}

	fun toJSONString() : String {
		var jsonObject = toJSONObject();

		return jsonObject.toString();
	}
}
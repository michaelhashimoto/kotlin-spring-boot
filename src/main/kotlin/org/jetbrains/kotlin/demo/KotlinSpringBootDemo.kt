package org.jetbrains.kotlin.demo;

import java.net.URL;

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

data class Greeting(val id: Long, val content: String)

@RestController
class GreetingController {
	val counter = AtomicLong();

	@GetMapping("/greeting")
	fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) : Greeting {
		return Greeting(counter.incrementAndGet(), "Hello, $name");
	}
}

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args);

	val masters = Masters();
}


class Masters() {
	init {
		val masters = arrayOf("test-1-0", "test-1-1", "test-1-2");

		for(master in masters){
			var jsonText = URL("http://${master}/computer/api/json?tree=computer[displayName]").readText()

			println(jsonText)
		}
	}
}

class Master(val name: String) {
	init {
		require(name != null) {"Please set a master name."}
	}
}
package org.jetbrains.kotlin.demo;

import com.liferay.jenkins.boot.spring.Masters;

import java.net.URL;

import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@RestController
class MastersController {
	val masters = Masters();

	@GetMapping("/masters")
	fun masters() : String {
		return masters.toJSONString();
	}
}

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args);
}

// Look into
// Look into React / Angular (Frontend Framework).
// Look into GraphQL (Better REST API).
// Look into MongoDB / RedisDB (No SQL).
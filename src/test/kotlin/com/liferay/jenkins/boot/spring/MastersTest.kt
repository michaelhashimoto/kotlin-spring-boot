package com.liferay.jenkins.boot.spring;

import org.jetbrains.kotlin.demo.Masters;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

class MastersTest {

	@Test
	fun testPass() {
		Assert.assertTrue(true);
	}

	@Test
	fun testFail() {
		Assert.assertTrue(false);
	}

	@Test
	fun testMasters() {
		val masters = Masters()
	}

}
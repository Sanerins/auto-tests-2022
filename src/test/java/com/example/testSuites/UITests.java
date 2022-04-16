package com.example.testSuites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectPackages("com.example.tests")
public class UITests {
}
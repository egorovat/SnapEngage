# SnapEngage
QA Automation Engineer coding challenge

This Selenium test performs login on to [https://snapengage-qa](https://snapengage-qa.appspot.com/signin?to=hub) and takes a screenshots after asserting the porlat has been loaded.
A new screenshot is saved after each test run in a file ./screens/screenshot_${ISO_DATE_TIME}.jpg

`Technology Used : Java, TestNG, Selenium, Maven`

## Versions

* java 1.8
* selenium 3.141.59

## Running Tests

```bash
mvn clean test
```

# Description

This is a test project for web automation task. This project tests Login, Hover and Table sorting at [the-internet.herokuapp.com](http://the-internet.herokuapp.com).

##Technology

```
WebDriver, Java, JUnit, Maven, AssertJ
```


### Prerequisites

This example requires the following softwares to run.
  * [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
    * Note that Gauge works with Java 1.6 and above. But this particular example uses Java 1.7
  * Gauge Java plugin
    * can be installed using `gauge install java`
  * Chrome

### Setting up Maven

* [Maven installation instructions](http://maven.apache.org/install.html)

## Run tests

To run Test Suite execute

`mvn test`

or

If you want [surefire report](http://maven.apache.org/surefire/maven-surefire-report-plugin/usage.html) to be generated execute

`mvn clean surefire-report:report`

This uses Chrome as default browser for specs execution. Make sure Chrome is installed in your machine and [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/) is in PATH.
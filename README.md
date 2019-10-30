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

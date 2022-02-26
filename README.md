![](src/images/logo_main.svg)

# UI web automation проект для сайта косметики из тайланда [kupithai.ru](https://kupithai.ru/)

## Technology Stack:

| Java | Selenide | Gradle | Junit5 | Selenoid | Jenkins | IntelliJ IDEA | Allure Report | Allure Testops | Telegram |
|:------:|:----:|:------:|:------:|:--------:|:--------:|:-------------:|:---------:|:---------:|:--------:|
| ![Java](src/images/icons/Java.png) | ![Selenide](src/images/icons/Selenide.png) | ![Gradle](src/images/icons/Gradle.png) | ![JUnit5](src/images/icons/JUnit5.png) | ![Selenoid](src/images/icons/Selenoid.png) | ![Jenkins](src/images/icons/Jenkins.png) | ![Intelij_IDEA](src/images/icons/Intelij_IDEA.png) | ![Allure Report](src/images/icons/Allure_Report.png) | ![AllureTestOps](src/images/icons/AllureTestOps.png) | ![Telegram](src/images/icons/Telegram.png) |


## Параметры запуска

Для удаленного запуска тестов, необходимо заполнить remote.properties следующими данными:
For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

Run tests with filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Run tests locally:
```bash
gradle clean test
```

Serve report:
```bash
allure serve build/allure-results
```


## Смотри отчёты о прохождении автотестов и храни документацию в Allure TestOps

Click <a target="_blank" href="https://allure.autotests.cloud/project/968/dashboards">here</a> to see a list of automated test cases.

Here are the test cases:

![](src/images/screenshots/AllureTestops001.png)

Test launch overview:

![](src/images/screenshots/AllureTestops002.png)


## Запускай тесты удаленно через - Jenkins job!

Jenkins is a tool from where you can run the tests.
Click <a target="_blank" href="https://jenkins.autotests.cloud/job/009_Vitalii_Kupithai_UI_Automation/">here</a> to do that.

![](src/images/screenshots/Jenkins001.png)

## Интерграция с Jira

![](src/images/screenshots/Jira001.png)


## Получай оповещение о прохождении тестов прямо в Telegram!

Each test builds sent report into telegram bot

![](src/images/screenshots/TelegramReport001.png)
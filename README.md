![](images/logo_main.svg)

# UI web automation проект для сайта [kupithai.ru](https://kupithai.ru/)

## Технологический стек:

| Java | Selenide | Gradle | Junit5 | Selenoid | Jenkins | IntelliJ IDEA | Allure Report | Allure Testops | Telegram |
|:------:|:----:|:------:|:------:|:--------:|:--------:|:-------------:|:---------:|:---------:|:--------:|
| ![Java](images/icons/Java.png) | ![Selenide](images/icons/Selenide.png) | ![Gradle](images/icons/Gradle.png) | ![JUnit5](images/icons/JUnit5.png) | ![Selenoid](images/icons/Selenoid.png) | ![Jenkins](images/icons/Jenkins.png) | ![Intelij_IDEA](images/icons/Intelij_IDEA.png) | ![Allure Report](images/icons/Allure_Report.png) | ![AllureTestOps](images/icons/AllureTestOps.png) | ![Telegram](images/icons/Telegram.png) |


## Параметры запуска

Для удаленного запуска тестов, необходимо заполнить remote.properties следующими данными:

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


## Отчёты о прохождении автотестов и хранение документации организовано в Allure TestOps

Click <a target="_blank" href="https://allure.autotests.cloud/project/968/dashboards">here</a> to see a list of automated test cases.

Отчет о прохождении тестов:

![](images/screenshots/AllureTestops001.png)

Обзор тестового прогона:

![](images/screenshots/AllureTestops002.png)


## Удаленный запуск тестов возможен через - Jenkins job

Click <a target="_blank" href="https://jenkins.autotests.cloud/job/009_Vitalii_Kupithai_UI_Automation/">here</a> to do that.

![](images/screenshots/Jenkins001.png)

## Настроена Интерграция с Jira

![](images/screenshots/Jira001.png)


## Оповещение о прохождении тестов приходит в Telegram bot

![](images/screenshots/TelegramReport001.png)
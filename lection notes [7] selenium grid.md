# Selenium Grid
## Selenium Grid running Hub
```shell
java -jar selenium-server-standalone-3.141.59.jar -role hub
```
## Selenium Grid running Node
```shell
java -Dwebdriver.<browserName>.driver=<path to executable driver> \
-jar selenium-server-standalone-3.141.59.jar \
-role node -hub http://localhost:4444/grid/register \
-browser "browserName=<browserName>,platformName=<OS name>" -port 5557
```
## References
* [Selenium testing: new hope - Part I](https://hackernoon.com/selenium-testing-a-new-hope-7fa87a501ee9#.wn7h2t50g)
* [Selenium testing: new hope - Part II](https://hackernoon.com/selenium-testing-a-new-hope-a00649cdb100#.sal3gqw7y)
* [Тестирование в Яндексе. Как сделать отказоустойчивый грид из тысячи браузеров](https://habr.com/ru/company/yandex/blog/268309/)
* [Selenium Grid Tutorial: Hub & Node (with Example)](https://www.guru99.com/introduction-to-selenium-grid.html)
* [Setting up Selenium Grid to run your tests in parallel on multiple browsers](https://www.codementor.io/@olawalealadeusi896/setting-up-selenium-grid-to-run-your-tests-in-parallel-on-multiple-browsers-kl6vqi83a)

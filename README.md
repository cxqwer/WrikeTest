# To run tests use .xml file in "src\test\resources\" directory
# Or command: 'mvn clean test' and 'mvn site' if need to generate Allure-report

# Notes:
1. For about test framework: junit4
    - it's too difficult to use Allure report with out testNG. 
    The difference between testNG and Junit is minor in this task.
    So I used - testNG. It's easy in my opinion.
2. UI test only with selenium (without wrappers)
    - I used selenide only for Allure-reporting. All tests were written only with selenium


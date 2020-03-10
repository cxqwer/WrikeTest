# Simple UI test (maven, cucumber, junit, selenide)
# Run local or server(docker Selenoid)

# Notes:
1. For run use maven command mvn clean test with params: -Dbrowser=... -DrunType=local(or docker) -DbrowserVersion=...
2. Command: mvn site' if need to generate Allure-report
3. If need run group test -> use cucumber params: -Dcucumber.options="--tags @testsTag" (default @all)
 


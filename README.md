#ToDoMVCTestSuitesJUnitCategories

This project contain tests for ToDoMVC application:

 1.
 - TodosE2ETest with one “lifeCycle” test method
   covering operations at all filter and filtering completed tasks through filters (active, completed)
 - TodosOperationsAtAllFilterTest with all tests of “unit” style
   (one use case per test method, or two in exceptional cases like mark completed & clear completed)
   one test simulates bug, i.e. should fail

 2.
 Configuration of the following Test Suites via JUnit Categories:
 - All (by default)
 - Smoke (included Smoke)
 - Acceptance (excluded Smoke and Buggy)
 - Buggy (included Buggy)

 3. Configuration for browser (firefox or chrome) when running tests via mvn

 4. Allure reporter configuration with screenshots
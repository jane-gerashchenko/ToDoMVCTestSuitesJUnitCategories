package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ToDoMVCPage {

    public static ElementsCollection tasks = $$("#todo-list>li");

    public static SelenideElement task(String text){
        return tasks.findBy(exactText(text));
    }

    public static SelenideElement editingTask() {
        return tasks.findBy(cssClass("editing")).find(".edit");
    }

    @Step
    public static void openToDoMVCPage() {
        open("http://todomvc.com/examples/troopjs_require/#");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public static void editTask(String oldName, String newName) {
        task(oldName).find("label").doubleClick();
        editingTask().setValue(newName).pressEnter();
    }

    @Step
    public static void clearCompleted() {
        $("#clear-completed").click();
        $("#clear-completed").shouldBe(hidden);
    }

    @Step
    public static void addTasks(String... names) {
        for (String name: names) {
            $("#new-todo").setValue(name).pressEnter();
        }
    }

    @Step
    public static void deleteTask(String name) {
        task(name).hover().find(".destroy").click();
    }

    @Step
    public static void toggleTask(String name) {
        task(name).find(".toggle").click();
    }

    @Step
    public static void toggleAll() {
        $("#toggle-all").click();
    }

    @Step
    public static void filterAll() {
        $(By.linkText("All")).click();
    }

    @Step
    public static void filterActive() {
        $(By.linkText("Active")).click();
    }

    @Step
    public static void filterCompleted() {
        $(By.linkText("Completed")).click();
    }

    public static void assertItemsLeft (String itemsCounter) {
        $("#todo-count>strong").shouldBe("Counter should reflect number of active tasks left", exactText(itemsCounter));
    }

    public static void assertTasks(String... names) {
            tasks.shouldHave(exactTexts(names));
    }

    public static void assertVisibleTasks(String... names) {
        tasks.filter(visible).shouldHave(exactTexts(names));
    }

    public static void assertNoTasks() {
        tasks.shouldBe(empty);
    }
}

package com.todomvc.features;

import com.todomvc.categories.Buggy;
import com.todomvc.categories.Smoke;
import com.todomvc.testconfigs.AtToDoMVCWithClearedDataAfterEachTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.todomvc.pages.ToDoMVCPage.*;

public class ToDoMVC extends AtToDoMVCWithClearedDataAfterEachTest {

    @Test @Category(Smoke.class)
    public void testTasksLifeCycle() {

        addTasks("a", "b", "c", "d");
        assertItemsLeft("4");

        editTask("b", "b.edited");

        toggleTask("b.edited");
        toggleTask("d");
        assertItemsLeft("2");

        filterCompleted();
        assertVisibleTasks("b.edited", "d");
        toggleTask("b.edited");
        clearCompleted();

        filterActive();
        assertVisibleTasks("a", "b.edited", "c");
        assertItemsLeft("3");

        filterAll();
        deleteTask("b.edited");
        assertTasks("a", "c");
        assertItemsLeft("2");

        toggleAll();
        clearCompleted();
        assertNoTasks();
    }

    @Test @Category(Buggy.class)
    public void testFailure() {
        assertItemsLeft("0");
    }

    @Test
    public void testCreateTasks(){
        addTasks("a", "b", "c");
        assertTasks("a", "b", "c");
        assertItemsLeft("3");
    }

    @Test
    public void testEditTask() {
        addTasks("a", "b", "c");
        editTask("b", "b.edited");
        assertTasks("a", "b.edited", "c");
        assertItemsLeft("3");
    }

    @Test
    public void testDeleteTask() {
        addTasks("a", "b", "c");
        deleteTask("c");
        assertTasks("a", "b");
        assertItemsLeft("2");
    }

    @Test
    public void testMarkTaskAsCompletedReopenAndClear() {
        addTasks("a", "b", "c");
        toggleTask("a");
        toggleTask("c");
        assertItemsLeft("1");

        toggleTask("a");
        assertItemsLeft("2");

        clearCompleted();
        assertTasks("a", "b");
        assertItemsLeft("2");
    }

    @Test
    public void testMarkAllTasksAsCompleteAndClear() {
        addTasks("a", "b", "c");
        toggleAll();
        clearCompleted();
        assertNoTasks();
    }
}
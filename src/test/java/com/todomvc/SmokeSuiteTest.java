package com.todomvc;

import com.todomvc.categories.Smoke;
import com.todomvc.features.ToDoMVC;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses(ToDoMVC.class)
@Categories.IncludeCategory(Smoke.class)
public class SmokeSuiteTest {}

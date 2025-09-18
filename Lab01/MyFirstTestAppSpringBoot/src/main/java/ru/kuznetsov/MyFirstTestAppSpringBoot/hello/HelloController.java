package ru.kuznetsov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


@RestController
public class HelloController {
    private static ArrayList<String> globalList = null;
    private static HashMap<Integer, String> globalMap = null;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(required = false) String s) {
        if (globalList == null) {
            globalList = new ArrayList<>();
            return "Создан новый ArrayList!";
        }
        if (s != null) {
            globalList.add(s);
            return "Элемент '" + s + "' добавлен в ArrayList. Всего элементов: " + globalList.size();
        }
        if (globalList.isEmpty())
            return "Добавьте новый элемент с помощью: /update-array?s='Новый элемент'!";
        return "";
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        if (globalList == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(globalList);
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(required = false) String s) {
        if (globalMap == null) {
            globalMap = new HashMap<>();
            return "Создан новый HashMap!";
        }
        if (s != null) {
            var rndKey = new Random().nextInt();
            globalMap.put(rndKey, s);
            return "Создана пара: (" + rndKey + ", " + s + "). Всего элементов: " + globalMap.size();
        }
        if (globalMap.isEmpty())
            return "Добавьте новый элемент с помощью: /update-map?s='Новый элемент'!";
        return "";
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        if (globalMap == null) {
            return new HashMap<>();
        }
        return new HashMap<>(globalMap);
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        if (globalList == null)
            globalList = new ArrayList<>();
        if (globalMap == null)
            globalMap = new HashMap<>();

        var arraySize = globalList.size();
        var mapSize = globalMap.size();
        return "Размер ArrayList: " + arraySize + " | Размер HashMap: " + mapSize;
    }
}

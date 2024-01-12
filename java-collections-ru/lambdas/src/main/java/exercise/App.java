package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        if (image.length == 0) {
            return image;
        }

        var doubledArray = Arrays.stream(image)
                .map(App::duplicateValues)
                .flatMap(p -> Arrays.stream(new String[][] {p, p}))
                .toArray(String[][]::new);

        return doubledArray;
    }

    public static String[] duplicateValues(String[] Array) {
        var duplicateValues = Arrays.stream(Array)
                .flatMap(p -> Arrays.stream(new String[] {p, p}))
                .toArray(String[]::new);

        return duplicateValues;
    }
}


// Нам на вход приходит двумерный массив строк, необходимо преобразовать
// каждый подмассив в массив удвоенных элементов: .map(App::duplicateValues)
// где duplicateValues принимает на вход одномерный массив
// и через flatMap преобразует каждый элемент
// в стрим из 2 элементов (item -> Arrays.stream(new String[] {item, item}))
// Далее уже нужно продублировать сами массивы,также через flatMap,
// по похожей логике, как в duplicateValues, но уже преобразовать итоговый стрим
// к двумерному массиву .toArray(String[][]::new);
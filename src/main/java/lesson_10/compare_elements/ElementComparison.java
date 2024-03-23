package lesson_10.compare_elements;

import org.openqa.selenium.WebElement;

public class ElementComparison {
    public static void compareElements(WebElement element1, WebElement element2) {
        int x1 = element1.getLocation().getX();
        int y1 = element1.getLocation().getY();
        int width1 = element1.getSize().getWidth();
        int height1 = element1.getSize().getHeight();

        int x2 = element2.getLocation().getX();
        int y2 = element2.getLocation().getY();
        int width2 = element2.getSize().getWidth();
        int height2 = element2.getSize().getHeight();

        String verticalPosition;
        if (y1 == y2) {
            verticalPosition = "Элементы на одной горизонтальной линии";
        } else {
            verticalPosition = (y1 < y2) ? "Первый элемент находится выше" : "Второй элемент находится выше";
        }

        String horizontalPosition;
        if (x1 == x2) {
            horizontalPosition = "Элементы на одной вертикальной линии";
        } else {
            horizontalPosition = (x1 < x2) ? "Первый элемент находится левее" : "Второй элемент находится левее";
        }

        int area1 = width1 * height1;
        int area2 = width2 * height2;
        if (area1 > area2) {
            System.out.println("Первый элемент занимает большую площадь.");
        } else if (area1 < area2) {
            System.out.println("Второй элемент занимает большую площадь.");
        } else {
            System.out.println("Площади элементов равны.");
        }

        System.out.println(verticalPosition);
        System.out.println(horizontalPosition);
    }
}

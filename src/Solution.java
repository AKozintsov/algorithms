import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final String SHARP = "#";

    private static final String ASTERISK = "*";

    private static final String CIRCLE = "o";

    public static void main(String[] args) {
        System.out.println(flag(8));
    }

    public static String flag(Integer n) {
        String flag = "";
        Integer width = 3 * n;
        Integer height = 2 * n;
        Integer dynamicDistance = (width - 4) / 2;
        Integer pairsCount = (n - 2) / 2;
        Integer verticalCircleBorderDistance = n / 2;
        Integer horizontalDistance = (width - 2) / 2;
        flag += buildHorizontalBorder(width) + "\n";
        for (int i = 0; i < height; i++) {
            if (i < verticalCircleBorderDistance || i > height - verticalCircleBorderDistance - 1) {// is before or after inner figure
                flag += buildEmptyLine(width);
            } else if (i == verticalCircleBorderDistance || i == (height - verticalCircleBorderDistance - 1)) {//is first or last figure elements
                flag += buildAsteriskLine(horizontalDistance);
            } else if (i > verticalCircleBorderDistance && i < height - verticalCircleBorderDistance - 1) { //is core figure part
                for (int j = 0, circleCount = 1; j < n - 2; j++, i++) {
                    if (j < pairsCount) {
                        flag += buildCircleLine(dynamicDistance, circleCount);
                        if (dynamicDistance > n) {
                            dynamicDistance--;
                            circleCount++;
                        }
                    } else if (j == pairsCount) {
                        flag += buildCircleLine(dynamicDistance, circleCount);
                    } else {
                        dynamicDistance++;
                        circleCount--;
                        flag += buildCircleLine(dynamicDistance, circleCount);
                    }
                }
                i--;

            }
        }
        flag += buildHorizontalBorder(width);
        return flag;
    }

    private static String buildEmptyLine(Integer width) {
        return SHARP + repeatString(" ", width) + SHARP + "\n";
    }

    private static String buildAsteriskLine(Integer horizontalDistance) {
        return SHARP + repeatString(" ", horizontalDistance) + repeatString(ASTERISK, 2) +
                repeatString(" ", horizontalDistance) + SHARP + "\n";
    }

    private static String buildCircleLine(Integer borderDistance, Integer circleCount) {
        Integer circleToDraw = circleCount * 2;
        return SHARP + repeatString(" ", borderDistance) + ASTERISK + repeatString(CIRCLE, circleToDraw) + ASTERISK + repeatString(" ", borderDistance) + SHARP + "\n";
    }

    private static String buildHorizontalBorder(Integer verticalBorderLength) {
        String topBorder = "";
        for (int i = 0; i < verticalBorderLength + 2; i++) {
            topBorder += SHARP;
        }
        return topBorder;
    }

    private static String repeatString(String s, Integer n) {
        return IntStream.range(0, n).mapToObj(i -> s).collect(Collectors.joining(""));
    }

}
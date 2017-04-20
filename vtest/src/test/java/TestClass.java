import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import service.annotations.ComponentAnno;

/**
 * Created by 37 on 2016/9/27.
 */
public class TestClass {

    @Test
    public void TestAnnotationScan() throws InterruptedException {
        String serviceName;
        String gameobjectName;
        final String[] gameEventIds = new String[]{};
        final int[] actionEventIds = new int[]{};
        new FastClasspathScanner("service")
                .matchClassesWithAnnotation(ComponentAnno.class,
                        c -> {
                            System.out.println(c);
                            ComponentAnno annotation = c.getAnnotation(ComponentAnno.class);
                            System.out.println(annotation);
                            String[] gameEventIds1 = annotation.gameEventIds();
                            System.out.println(gameEventIds1.length + " " + Arrays.toString(gameEventIds1));
                            System.arraycopy(gameEventIds1, 0, gameEventIds, 0, gameEventIds1.length);
                            for (String gameEventId : gameEventIds1) {
                                System.out.println(gameEventId);
                            }
                        })
        .scan();

        ScanResult scanResult = new FastClasspathScanner("service").scan();
        List<String> namesOfClassesWithAnnotationsAllOf = scanResult.getNamesOfClassesWithAnnotationsAllOf(ComponentAnno.class);
        for (String name : namesOfClassesWithAnnotationsAllOf) {
            System.out.println(name);
        }

    }
}

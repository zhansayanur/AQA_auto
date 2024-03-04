package lesson_11.priority;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphabeticalOrderRunner extends BlockJUnit4ClassRunner {
    public AlphabeticalOrderRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> methods = super.computeTestMethods();
        List<FrameworkMethod> sortedMethods = new ArrayList<>(methods);
        Collections.sort(sortedMethods, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod method1, FrameworkMethod method2) {
                return method2.getName().compareTo(method1.getName());
            }
        });
        return sortedMethods;
    }
}


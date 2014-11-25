
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.google.inject.AnnotationDatabase;
import roboguice.fragment.FragmentUtil;

public class AnnotationDatabaseImpl extends AnnotationDatabase {

    public void fillAnnotationClassesAndFieldsNames(HashMap<String, Map<String, Set<String>>> mapAnnotationToMapClassWithInjectionNameToFieldSet) {
    
        String annotationClassName = null;
        Map<String, Set<String>> mapClassWithInjectionNameToFieldSet = null;
        Set<String> fieldNameSet = null;


        annotationClassName = "com.google.inject.Inject";
        mapClassWithInjectionNameToFieldSet = mapAnnotationToMapClassWithInjectionNameToFieldSet.get(annotationClassName);
        if( mapClassWithInjectionNameToFieldSet == null ) {
            mapClassWithInjectionNameToFieldSet = new HashMap<String, Set<String>>();
            mapAnnotationToMapClassWithInjectionNameToFieldSet.put(annotationClassName, mapClassWithInjectionNameToFieldSet);
        }

        fieldNameSet = new HashSet<String>();
        fieldNameSet.add("questionListPresentationModel");
        mapClassWithInjectionNameToFieldSet.put("com.liffft.simpleandroidarchitecture.MainActivity", fieldNameSet);

    }
    
    public void fillAnnotationClassesAndMethods(HashMap<String, Map<String, Set<String>>> mapAnnotationToMapClassWithInjectionNameToMethodsSet) {
    }
    
    public void fillAnnotationClassesAndConstructors(HashMap<String, Map<String, Set<String>>> mapAnnotationToMapClassWithInjectionNameToConstructorsSet) {

        String annotationClassName = null;
        Map<String, Set<String>> mapClassWithInjectionNameToConstructorSet = null;
        Set<String> constructorSet = null;


        annotationClassName = "com.google.inject.Inject";
        mapClassWithInjectionNameToConstructorSet = mapAnnotationToMapClassWithInjectionNameToConstructorsSet.get(annotationClassName);
        if( mapClassWithInjectionNameToConstructorSet == null ) {
            mapClassWithInjectionNameToConstructorSet = new HashMap<String, Set<String>>();
            mapAnnotationToMapClassWithInjectionNameToConstructorsSet.put(annotationClassName, mapClassWithInjectionNameToConstructorSet);
        }

        constructorSet = new HashSet<String>();
        constructorSet.add("<init>:com.liffft.simpleandroidarchitecture.service.ProjectService:com.liffft.simpleandroidarchitecture.routing.ProjectRouter");
        mapClassWithInjectionNameToConstructorSet.put("com.liffft.simpleandroidarchitecture.presentationmodel.QuestionListPresentationModel", constructorSet);

        constructorSet = new HashSet<String>();
        constructorSet.add("<init>:android.app.Application");
        mapClassWithInjectionNameToConstructorSet.put("com.liffft.simpleandroidarchitecture.routing.ProjectRouter", constructorSet);

    }
    
    public void fillClassesContainingInjectionPointSet(HashSet<String> classesContainingInjectionPointsSet) {
        classesContainingInjectionPointsSet.add("com.liffft.simpleandroidarchitecture.MainActivity");
        classesContainingInjectionPointsSet.add("com.liffft.simpleandroidarchitecture.presentationmodel.QuestionListPresentationModel");
        classesContainingInjectionPointsSet.add("com.liffft.simpleandroidarchitecture.routing.ProjectRouter");
    }
    

    public void fillBindableClasses(HashSet<String> injectedClasses) {
        injectedClasses.add("com.liffft.simpleandroidarchitecture.service.ProjectService");
        injectedClasses.add("com.liffft.simpleandroidarchitecture.presentationmodel.QuestionListPresentationModel");
        injectedClasses.add("android.app.Application");
        injectedClasses.add("com.liffft.simpleandroidarchitecture.routing.ProjectRouter");

        if(FragmentUtil.hasNative) {
            injectedClasses.add("android.app.FragmentManager");
        }

        if(FragmentUtil.hasSupport) {
            injectedClasses.add("android.support.v4.app.FragmentManager");
        }
    }

}

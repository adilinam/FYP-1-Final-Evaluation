#Following files are changed from the original asanchez branch:

In project named "org.eclipse.m2m.qvt.oml" we have created a new package named "org.eclipse.m2m.qvt.oml.mapping.pivot.test" which contains
a singleton class to persist different objects required for mapping.

In the file named "InternalTransformationExecutor.java", singleton class is used for storing objects.

changes are given below

org.eclipse.m2m.qvt.oml
+
+
+---------org.eclipse.m2m.qvt.oml.mapping.pivot.test
+           +
+           +
+           +--------QvtOperationalMappingArgumentsContainer.java
+
+ 
+---------org.eclipse.m2m.internal.qvt.oml
            +
            +
            +--------InternalTransformationExecutor.java
          
#Following projects are added:
org.eclipse.m2m.qvt.oml.pivot.mapping 

The project org.eclipse.m2m.qvt.oml.pivot.mapping contain the mapping of the traditional QVTo to Pivot Based QVTo AST.


The class "ExecuteMapping.java" contain the test run function needed to exeute the mapping.

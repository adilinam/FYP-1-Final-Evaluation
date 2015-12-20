/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on Jun 29, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.legacy.libraries;

import java.util.Arrays;
import java.util.List;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;

/**
 * @since 3.5
 */
public class StringLibrary {
    
    /**
     * Metainfo for the native methods should be accessible throu the static
     * methods of inner class <code>Metainfo</code> with the same signature
     * ant <code>String[]</code> return type. Returned array should contains
     * string representation of OCL classifiers:
     * 
     * array[0]     - Context classifier
     * array[n]     - Classifier corresponds to the n-th operation parameter 
     * array[n+1]   - Return type classifier
     */
    public static class Metainfo {

//        private static final String[] STARTS_WITH = new String[] {
//        	STRING_CONTEXT,
//                "String", "Boolean" }; //$NON-NLS-1$ //$NON-NLS-2$

//        public static String[] startsWith(String self, String prefix) {
//            return STARTS_WITH;
//        }

        private static final String[] STARTS_WITH_OFFSET = new String[] {
        	STRING_CONTEXT,
                "String", "Integer", "Boolean" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        public static String[] startsWith(String self, String prefix,
                Integer tofset) {
            return STARTS_WITH_OFFSET;
        }

//        private static final String[] ENDS_WITH = new String[] {
//        	STRING_CONTEXT,
//                "String", "Boolean" }; //$NON-NLS-1$ //$NON-NLS-2$

//        public static String[] endsWith(String self, String suffix) {
//            return ENDS_WITH;
//        }

//        private static final String[] INDEX_OF = new String[] {
//        	STRING_CONTEXT,
//                "String", "Integer" }; //$NON-NLS-1$ //$NON-NLS-2$

//        public static String[] indexOf(String self, String str) {
//            return INDEX_OF;
//        }

        private static final String[] INDEX_OF_FROMINDEX = new String[] {
        	STRING_CONTEXT,
                "String", "Integer", "Integer" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        public static String[] indexOf(String self, String str,
                Integer fromIndex) {
            return INDEX_OF_FROMINDEX;
        }

//        private static final String[] LAST_INDEX_OF = new String[] {
//        	STRING_CONTEXT,
//                "String", "Integer" }; //$NON-NLS-1$ //$NON-NLS-2$

//        public static String[] lastIndexOf(String self, String str) {
//            return LAST_INDEX_OF;
//        }

        private static final String[] LAST_INDEX_OF_FROMINDEX = new String[] {
        	STRING_CONTEXT,
                "String", "Integer", "Integer" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        public static String[] lastIndexOf(String self, String str,
                Integer fromIndex) {
            return LAST_INDEX_OF_FROMINDEX;
        }

//        private static final String[] TRIM = new String[] {
//        	STRING_CONTEXT,
//                "String" }; //$NON-NLS-1$

//        public static String[] trim(String self) {
//            return TRIM;
//        }

//        private static final String[] REPLACE_ALL = new String[] {
//        	STRING_CONTEXT,
//                "String", "String", "String" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

//        public static String[] replaceAll(String self, String regexp,
//                String replacement) {
//            return REPLACE_ALL;
//        }

        private static final String[] REPLACE = new String[] {
        	STRING_CONTEXT,
                "String", "String", "String" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        public static String[] replace(String self, String what, String with) {
            return REPLACE;
        }
        
//        private static final String[] TO_LOWER_CASE = new String[] {
//        	STRING_CONTEXT,
//            	"String" }; //$NON-NLS-1$ 

//	    public static String[] toLowerCase(String self) {
//	        return TO_LOWER_CASE;
//	    }
	    
//        private static final String[] TO_UPPER_CASE = new String[] {
//        	STRING_CONTEXT,
//        		"String" }; //$NON-NLS-1$ 

//	    public static String[] toUpperCase(String self) {
//	        return TO_UPPER_CASE;
//	    }

	    private static final String[] SPLIT_1 = new String[] {
	    	STRING_CONTEXT,
	    		"String", "Sequence(String)" };  //$NON-NLS-1$ //$NON-NLS-2$
	    
	    public static String[] split(String self, String regex) {
	    	return SPLIT_1;
	    }
	    
	    private static final String[] SPLIT_2 = new String[] {
	    	STRING_CONTEXT,
	    		"String", "Integer", "Sequence(String)" };  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	    
	    public static String[] split(String self, String regex, Integer limit) {
	    	return SPLIT_2;
	    }
	    
    }

    private static final Integer INDEX_NOT_FOUND = new Integer(-1);

//    public Boolean startsWith(String self, String prefix) {
//        if (self == null || prefix == null) {
//            return Boolean.FALSE;
//        }
//        return Boolean.valueOf(self.startsWith(prefix));
//    }
    
    @Operation(contextual=true)
    public Boolean startsWith(String self, String prefix, Integer toffset) {
        if (self == null || prefix == null || toffset == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(self.startsWith(prefix, toffset.intValue()));
    }

//    public Boolean endsWith(String self, String suffix) {
//        if (self == null || suffix == null) {
//            return Boolean.FALSE;
//        }
//        return Boolean.valueOf(self.endsWith(suffix));
//    }

//    public Integer indexOf(String self, String str) {
//        if (self == null || str == null) {
//            return INDEX_NOT_FOUND;
//        }
//        return new Integer(self.indexOf(str));
//    }
    
    @Operation(contextual=true)
    public Integer indexOf(String self, String str, Integer fromIndex) {
        if (self == null || str == null || fromIndex == null) {
            return INDEX_NOT_FOUND;
        }
        return new Integer(self.indexOf(str, fromIndex.intValue()));
    }

//    public Integer lastIndexOf(String self, String str) {
//        if (self == null || str == null) {
//            return INDEX_NOT_FOUND;
//        }
//        return new Integer(self.lastIndexOf(str)+1);
//    }

    @Operation(contextual=true)
    public Integer lastIndexOf(String self, String str, Integer fromIndex) {
        if (self == null || str == null || fromIndex == null) {
            return INDEX_NOT_FOUND;
        }
        return new Integer(self.lastIndexOf(str, fromIndex.intValue())+1);
    }

//    public String trim(String self) {
//        if (self == null) {
//            return self;
//        }
//        return self.trim();
//    }

//    public String replaceAll(String self, String regexp, String replacement) {
//        if (self == null || regexp == null || replacement == null) {
//            return self;
//        }
//        return self.replaceAll(regexp, replacement);
//    }

    @Operation(contextual=true)
    public String replace(String self, String what, String with) {
        if (self == null || what == null || with == null) {
            return self;
        }
        return self.replaceFirst(what, with);
    }
    
//    public String toLowerCase(String self) {
//    	if (self == null) {
//    		return null;
//    	}
//    	return self.toLowerCase();
//    }
    
//    public String toUpperCase(String self) {
//    	if (self == null) {
//    		return null;
//    	}
//    	return self.toUpperCase();
//    }
    
    @Operation(contextual=true)
    public List<String> split(String self, String regex) {
    	if (self == null || regex == null) {
    		return null;
    	}
    	return Arrays.asList(self.split(regex));
    }
    
    @Operation(contextual=true)
    public List<String> split(String self, String regex, Integer limit) {
    	if (self == null || regex == null || limit == null) {
    		return null;
    	}
    	return Arrays.asList(self.split(regex, limit.intValue()));
    }
    
    private static final String STRING_CONTEXT = Libraries.OCL_LIBRARY_PACKAGE + "::String"; //$NON-NLS-1$
    
}

/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.qvt.oml.tools.coverage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.junit.runner.RemoteTestRunner;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.QVTOCoverageDecorator;
import org.eclipse.m2m.qvt.oml.util.ISessionData;
import org.eclipse.m2m.qvt.oml.util.ISessionData.SimpleEntry;

@SuppressWarnings("restriction")
public class Shell {

    public static void main(String[] args) {

        List<Class<? extends QvtGenericVisitorDecorator>> visitorDecorators = new ArrayList<Class<? extends QvtGenericVisitorDecorator>>();
        visitorDecorators.add(QVTOCoverageDecorator.class);

        SimpleEntry<List<Class<? extends QvtGenericVisitorDecorator>>> decoratorsEntry = new ISessionData.SimpleEntry<List<Class<? extends QvtGenericVisitorDecorator>>>(
                visitorDecorators);

        try {
            Field field = QVTEvaluationOptions.class.getField("VISITOR_DECORATORS");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, decoratorsEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RemoteTestRunner.main(args);
    }
}

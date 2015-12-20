#*******************************************************************************
# Copyright (c) 2008 Borland Software Corporation and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     Borland Software Corporation - initial API and implementation
#*******************************************************************************
#perl -w
use strict;
while(<>) {
	if(m{transformation\s+([^;]+);}) {
		print "transformation models.$1.$1;\n"
	}
	else {
		print;
	}
}

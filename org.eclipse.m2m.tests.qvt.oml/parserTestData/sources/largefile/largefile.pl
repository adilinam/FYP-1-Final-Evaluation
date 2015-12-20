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
#!perl -w
use strict;

my $text = <<header;
transformation largefile;
modeltype ECORE uses 'http://www.eclipse.org/emf/2002/Ecore';
header
	
print "$text\n";

for(my $i = 0; $i < 1500; $i++) {
	print "query foo$i(): String {\n    'foo$i'\n}\n";
}

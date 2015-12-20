#*******************************************************************************
# Copyright (c) 2013 E.D.Willink and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#!/bin/bash

rm -rf buildroot MMT-QVTo.*
mkdir buildroot
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/org.eclipse.qvto.git/releng/org.eclipse.qvto.releng.buckminster/releng/qvto-build.properties"

	echo
	echo "# Define the Build Type (added by Hudson job definition)"
	echo "build.type=${BUILD_TYPE}"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the timestamp to use for changed components (added by Hudson job definition)"
	echo "buckminster.build.timestamp=${BUILD_ID}"

	echo
	echo "# Define the Build Alias (added by Hudson job definition)"
	echo "build.alias=${BUILD_ALIAS}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# Put Eclipse-SourceReferences declarations in the MANIFEST.MFs (added by Hudson job definition)"
	echo "generateSourceReferences=true"

	echo
	echo "# Define if Hudson Build should create javadoc (added by Hudson job definition)"
	echo "manage.javadoc=${MANAGE_JAVADOC}"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.output"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/shared/download-staging.priv/modeling/mmt/qvto"
	echo "git.qvto.local.repository.location=${WORKSPACE}/org.eclipse.qvto.git"
	echo "reference.repository=${REFERENCE_REPOSITORY}"

	echo
	echo "# Sign the jars (added by Hudson job definition)"
	echo "signing.type=eclipse.local"
	echo "site.signing=${SITE_SIGNING}"

	echo
	echo "# Eclipse local download area (added by Hudson job definition"
	echo "eclipse.download=file:/home/data/httpd/download.eclipse.org"
	echo
	echo "# Required Properties for Publishing (added by Hudson job definition)"
	echo "packages.base=MMT-QVTo.downloads"
	echo "tests.base=MMT-QVTo.test.results"
	echo "javadoc.base=MMT-QVTo.javadoc"
	echo "version=3.5.0"
	echo "downloads.area=/home/data/httpd/download.eclipse.org/mmt/qvto"


} > buildroot/build.properties
:
{
	echo "# Define the Build ID to use for tagging (added by Hudson job definition)"
	echo "build.id=${COMPACT_BUILD_ID}"

} > buildroot/tagging.properties
:

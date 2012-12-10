MODULE = "AutoShutDown"
DESCRIPTION = "automated power off for STB"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv
SRCREV = ""
PV = "0.3+git${SRCPV}"
PKGV = "0.3+git${GITPKGV}"
PR = "r2"

require openplugins.inc

SRC_REV = "406e54cb250fecb5040dba844098140982186668"
SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=git;tag=${SRC_REV} \
	   file://autoshutdown-default-time_20121207.patch;patch=1;pnum=1 \
	  "

inherit autotools

FILES_${PN} = "/"

require assume-gplv2.inc

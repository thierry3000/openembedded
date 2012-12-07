MODULE = "AutoShutDown"
DESCRIPTION = "automated power off for STB"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv
SRCREV = ""
PV = "0.3+git${SRCPV}"
PKGV = "0.3+git${GITPKGV}"
PR = "r1"

require openplugins.inc
SRC_URI += "file://autoshutdown-default-time_20121207.patch;patch=1;pnum=1 "

inherit autotools

FILES_${PN} = "/"

require assume-gplv2.inc

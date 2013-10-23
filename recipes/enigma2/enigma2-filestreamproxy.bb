DESCRIPTION = "file transcoding util."
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r0"
SRCREV="4601bc13bc6f08e124d60f7c004ff2e1cacdfc31"

SRC_URI = "git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=master;tag=${SRCREV}"

inherit autotools pkgconfig

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/filestreamproxy ${D}/usr/bin
}

FILES_${PN} = "${bindir}/filestreamproxy"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES = "${PN}"


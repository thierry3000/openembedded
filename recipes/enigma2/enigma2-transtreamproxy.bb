DESCRIPTION = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r3"
SRCREV="aab1af78d7c8152e5f3e8eafc61496898184df9f"

SRC_URI = "git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=transtreamproxy;tag=${SRCREV}"

inherit autotools

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}


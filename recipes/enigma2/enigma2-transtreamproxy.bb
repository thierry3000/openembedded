DESCRIPTION = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r5"
SRCREV="7302a1cf53b36472514c668de7ea9b201c1ba6fb"

SRC_URI = "git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=transtreamproxy;tag=${SRCREV}"

inherit autotools

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}


DESCRIPTION = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r6"
SRCREV="b55a219498eeceb63a98dcfdc7597b7c40d6977c"
DEPENDS += "boost"

SRC_URI = "git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=transtreamproxy;tag=${SRCREV}"

inherit autotools

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}


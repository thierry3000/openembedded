DESCIPTION = "helper tool to use usb dvb frontends"
MAINTAINER = "PLi team"
LICENSE = "GPLv2"


PV = "1.0+git${SRCPV}"
PR = "r1"
SRC_REV = ""

SRC_URI = "git://openpli.git.sourceforge.net/gitroot/openpli/vtuner;protocol=git;tag=${SRC_REV} \
	file://ut_buffer_size.patch;patch=1;pnum=2 \
	file://${PN}.sh "

S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/${PN}.sh ${D}/etc/init.d/${PN}
}

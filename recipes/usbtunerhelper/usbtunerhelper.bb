DESCIPTION = "helper tool to use usb dvb frontends"
MAINTAINER = "PLi team"
LICENSE = "GPLv2"


PV = "1.0+git${SRCPV}"
PR = "r2"
SRC_REV = ""

SRC_URI = " \
	git://code.vuplus.com/git/vtuner.git;protocol=git;tag=${SRC_REV} \
	file://${PN}.sh \
	"

S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/${PN}.sh ${D}/etc/init.d/${PN}
}

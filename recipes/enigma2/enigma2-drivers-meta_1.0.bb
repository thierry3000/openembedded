DESCRIPTION = "Descriptions for driver packages used by enigma2"
LICENSE = "proprietary"
MAINTAINER = "kos <kos@dev3>"

PR = "r0"

SRC_URI = " \
	file://index-enigma2-drivers.xml \
	file://driver_r8192cu.xml \
"

S = "${WORKDIR}"

DEPENDS = " \
	r8192cu \
"

do_install() {
	install -d ${D}${datadir}/meta
	install ${WORKDIR}/*.xml ${D}${datadir}/meta
}

FILES_${PN} = "${datadir}/meta"
PACKAGE_ARCH = "all"

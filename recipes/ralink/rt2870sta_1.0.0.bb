DESCRIPTION = "install RT2870STA.dat file for ralink drivers"

PV = "1.0.0"
PR = "r0"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://RT2870STA.dat"

S = "${WORKDIR}/"

do_compile() {
        :
}

do_install() {
	install -d  ${D}/etc/Wireless/RT2870STA/
	install -m 0755 ${WORKDIR}/RT2870STA.dat ${D}/etc/Wireless/RT2870STA/
}

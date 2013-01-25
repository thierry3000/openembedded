DESCRIPTION = "Firmware for rt73 based USB wifi adaptors"
LICENSE = "unknown"

PR = "r2"

SRC_URI = "ftp://ftp.pl.scene.org/vol/rzm1/linux-gentoo/distfiles/RT71W_Firmware_V1.8.zip "

S = "${WORKDIR}/RT71W_Firmware_V${PV}"

do_install() {
	install -d ${D}/${base_libdir}/firmware
	install -m 0644 rt73.bin ${D}/${base_libdir}/firmware/
}

FILES_${PN} = "${base_libdir}/firmware/"
PACKAGE_ARCH = "all"

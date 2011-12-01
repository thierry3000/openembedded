
require linux-firmware.inc

PR = "r1"

DESCRIPTION = "Temporary Firmware collections"

SRCREV = "13f0b6bda7b567d29c747196aa65ad82b18651ca"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 *.fw rt2870.bin ${D}${base_libdir}/firmware
}

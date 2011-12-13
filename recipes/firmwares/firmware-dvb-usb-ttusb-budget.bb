require linux-firmware.inc

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware/ttusb-budget/
        install -m 0644 ttusb-budget/dspbootcode.bin ${D}/${base_libdir}/firmware/ttusb-budget/
}


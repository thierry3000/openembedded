require linux-firmware.inc

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 dvb-fe-xc5000-1.1.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-fe-xc5000-1.6.114.fw ${D}/${base_libdir}/firmware/
}

